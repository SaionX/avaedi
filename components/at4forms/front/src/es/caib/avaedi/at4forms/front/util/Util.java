package es.caib.avaedi.at4forms.front.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

import com.aeat.valida.Validador;


public class Util {

	public final static Vector <String> EXTENSIONS = new Vector<String>(Arrays.asList("pdf", "odt", "doc", "zip", "jrxml", "csv", "xml"));
	public final static Vector <String> MIME = new Vector<String>
								(Arrays.asList("application/pdf",
										       "application/vnd.oasis.opendocument.text",
										       "application/msword",
											   "application/zip",
											   "application/octet-stream",
											   "text/csv",
											   "application/xml"));
	public final static String ESTAT_INICIAL_EXPEDIENT = "ESTAT_INICIAL";


	/**
	 * validarCuentaBancaria
	 * @param cuenta
	 * @return
	 */
	public static boolean validarIban(String cuenta) {

		return IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(cuenta);

	}



	/**
	 * validarCuentaBancaria
	 * @param cuenta
	 * @return
	 */
	public static boolean validarCuentaBancaria(String cuenta) {
		Pattern cuentaPattern = Pattern.compile("\\d{20}");
		Matcher m = cuentaPattern.matcher(cuenta);
		if (m.matches()) {
			// cuenta cumple el patrón (20 dígitos)
			String banco = cuenta.substring(0, 4);
			String sucursal = cuenta.substring(4,8);
			String dc = cuenta.substring(8, 10);
			String ccc = cuenta.substring(10, 20);
			if (!( obtenerDigito("00" + banco + sucursal ) == Integer.parseInt(String.valueOf(dc.charAt(0)))) || !(obtenerDigito(ccc) == Integer.parseInt(String.valueOf(dc.charAt(1))))) {
				return false;
			} else {
				return true;
			}
		}
		return false;

	}


	/**
	 * obtenerDigito
	 * @param valor
	 * @return
	 */
	private static int obtenerDigito(String valor) {
		Integer[] valores = new Integer[]{1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

		Integer control = 0;
		for (int i=0; i <=9; i++) {
			control += Integer.parseInt(String.valueOf(valor.charAt(i))) * valores[i];
		}
		control = 11 - (control % 11);
		if (control == 11) {
			control = 0;
		} else if (control == 10) {
			control = 1;
		}
		return control;
	}


	/**
	 * normalizeCharacters
	 * @param cadena
	 * @return
	 */
	public static String normalizeCharacters(String cadena) {
		cadena = cadena.replaceAll("á", "a");
		cadena = cadena.replaceAll("é", "e");
		cadena = cadena.replaceAll("í", "i");
		cadena = cadena.replaceAll("ó", "o");
		cadena = cadena.replaceAll("ú", "u");
		cadena = cadena.replaceAll("à", "a");
		cadena = cadena.replaceAll("è", "e");
		cadena = cadena.replaceAll("ì", "i");
		cadena = cadena.replaceAll("ò", "o");
		cadena = cadena.replaceAll("ù", "u");
		cadena = cadena.replaceAll("ü", "u");
		cadena = cadena.replaceAll("Á", "A");
		cadena = cadena.replaceAll("É", "E");
		cadena = cadena.replaceAll("Í", "I");
		cadena = cadena.replaceAll("Ó", "O");
		cadena = cadena.replaceAll("Ú", "U");
		cadena = cadena.replaceAll("À", "A");
		cadena = cadena.replaceAll("È", "E");
		cadena = cadena.replaceAll("Ì", "I");
		cadena = cadena.replaceAll("Ò", "O");
		cadena = cadena.replaceAll("Ù", "U");
		cadena = cadena.replaceAll("Ü", "U");
		cadena = cadena.replaceAll("/", "-");
		cadena = cadena.replaceAll(" ", "_");
		return cadena;
	}


	/**
	 * dataAvuiFormatLlarg
	 * @param lang
	 * @return
	 */
	public static String dataAvuiFormatLlarg(String lang) {
		return dataFormatLlarg(new Date(), lang);
	}


	/**
	 * dataFormatLlarg
	 * @param date
	 * @param lang
	 * @return
	 */
	public static String dataFormatLlarg(Date date, String lang) {
		if (date == null) {
			return "";
		}
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale(lang));
		String result = df.format(date);
		if ("ca".equals(lang)) {
			result = result.replaceFirst("/ ([ao])", "d'$1").replaceAll("/", "de");
		}
		return result;
	}


	/**
	 * formatMoneda
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatMoneda(String valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}
		double valorDouble = Double.parseDouble(valor);
		return formatMoneda(valorDouble);
	}


	/**
	 * formatMoneda
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatMoneda(Double valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		NumberFormat formatter = new DecimalFormat("#,##0.00", simbolos);
		String cadena = formatter.format(valor);
		return cadena;
	}

	/**
	 * formatNumericoEntero
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatNumericoEntero(Double valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}
		NumberFormat formatter = new DecimalFormat("#,###");
		return formatter.format(valor);
	}


	/**
	 * formatNumericoEntero
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatNumericoEntero(Long valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}
		NumberFormat formatter = new DecimalFormat("#,###");
		return formatter.format(valor);
	}


	/**
	 * formatNumericoEntero
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatNumericoEntero(String valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}
		double valorDouble = Double.parseDouble(valor);
		return formatNumericoEntero(valorDouble);
	}


	/**
	 * sustituyeEuro
	 * @param cadena
	 * @return
	 */
	public static String sustituyeEuro(String cadena) {
		if (cadena == null) {
			return "";
		}
		return cadena.replaceAll("&euro;", "€");
	}

	/**
	 * checkNif, para validaciones de nif
	 *
	 * */
	public static Boolean checkNif(String nif) {

		if (nif == null) {
			return false;
		}

		return new Validador().checkNif(nif.toUpperCase()) > 0;

	}


	/**
	 * Trunca la cadena a un máximo de caracteres
	 * @param str
	 * @param maxLen
	 * @return
	 */
	public static String truncate (String str, int maxLen) {
		if (str == null) {
			return str;
		}
		return str.substring(0, Math.min(maxLen, str.length()));
	}



}
