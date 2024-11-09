package es.caib.avaedi.at4forms.common.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Utilidades para el manejo de cadenas
 * @author agarcia
 *
 */
public class StringUtils {

	/**
	 * Testea si la cadena es nula o vacía
	 * @param str
	 * @return true si la cadena es nula o vacía
	 */
	public static boolean isEmpty (String str) {
		return ((str == null) || str.equals(""));
	}

	/**
	 * Testea si la subcadena key existe en formData y no es vacía
	 * @param formData
	 * @param key
	 * @return true si la cadena no existe
	 */
	public static boolean isEmpty(Map<String, ?> formData, String key) {
		if (!formData.containsKey(key)) {
			return true;
		}
		return isEmpty((String)formData.get(key));
	}

	/**
	 * formatMoneda, copiat del Utils del front (per emprar-ho al TransferObject...)
	 * @param valor
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatMoneda(Double valor) throws NumberFormatException {
		if (valor == null) {
			return "";
		}
		NumberFormat formatter = new DecimalFormat("#,###.00");
		String cadena = formatter.format(valor);
		if (cadena.startsWith(",") || cadena.startsWith(".")) {
			cadena = "0" + cadena;
		}
		return cadena;
	}


	/**
	 * formatCuentaCorriente, devuelve el nº de cuenta separado por guiones siguiendo el formato estandar (4-4-2-10)
	 * @param valor
	 * @return
	 */
	public static String formatCuentaCorriente(String cuenta) {
		String rtdo = "";
		String separador = "-";
		if ((cuenta != null) && !cuenta.contains(separador)) { // no fué formateada con anterioridad
			rtdo += cuenta.substring(0, 4) + separador + cuenta.substring(4, 8) +
					separador + cuenta.substring(8, 10) + separador +
					cuenta.substring(10, cuenta.length());
		}
		return rtdo;
	}


	/**
	 * NullSafe equals
	 * @param long1
	 * @param long2
	 */
	public static boolean equals (Object o1, Object o2) {
		return ( ((o1 == null) && (o2 == null)) || (((o1 != null) && (o2 != null)) && o1.equals(o2))) ;
	}

	
	/**
	 * Convierte de Date a cadena formato dd-MM-yyyy
	 * @param data
	 */
	public static String toString(Date data) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		if (data != null) {
			return format.format(data);
		} else {
			return null;
		}
	}


	/**
	 * Convierte de Date a cadena formato
	 * @param data
	 */
	public static String toString(Date data, String formato) {
		DateFormat format = new SimpleDateFormat(formato);
		if (data != null) {
			return format.format(data);
		} else {
			return null;
		}
	}

	public static String implode(String separator, String... data) {
		StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < data.length - 1; i++) {
	    //data.length - 1 => to not add separator at the end
	        if (!data[i].matches(" *")) {//empty string are ""; " "; "  "; and so on
	            sb.append(data[i]);
	            sb.append(separator);
	        }
	    }
	    sb.append(data[data.length - 1].trim());
	    return sb.toString();
    }

	
}
