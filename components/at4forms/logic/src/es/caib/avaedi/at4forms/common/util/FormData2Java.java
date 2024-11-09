package es.caib.avaedi.at4forms.common.util;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.hibernate.Hibernate;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.logic.util.BigDecimalFormatter;

/**
 * Utilidades para convertir datos de formulario recibidos como cadena. Todos los métodos hacen además testeo de nulls.
 * @author agarcia
 *
 */
public class FormData2Java {


	public static String decimales3 = "0,000";

	/**
	 * Convierte una cadena a CLOB
	 * @param formDataStr Cadena
	 */
	public static Clob toClob(String formDataStr) {
		if (!StringUtils.isEmpty(formDataStr)) {
			return Hibernate.createClob(formDataStr);
		} else {
			return null;
		}
	}


    /**
     * Convierte un CLOB a cadena
     * @param clob
     * @return
     * @throws java.sql.SQLException
     */
	public static final String toString(Clob clob) throws SQLException {
		if (clob != null) {
			StringBuffer sOutputClob = new StringBuffer();
            try {
            	Reader rd = clob.getCharacterStream();
            	char[] buf = new char[2048];
            	int iRead = 1;
            	while (iRead > 0) {
            		buf[0] = 0;
            		iRead = rd.read(buf, 0, 80);
            		if (iRead < 0)
            			break;
            		buf[iRead] = 0;
            		sOutputClob.append(new String(buf, 0, iRead));	
            	}
            } catch (IOException ioe) {
                throw (new SQLException(ioe.getMessage()));
            }
            return sOutputClob.toString();
		} else {
			return null;
        }
	}
	
	/**
	 * Convierte a boolean
	 * @param formDataStr Cadena 'true' o 'false'
	 */
	public static boolean toBoolean(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return false;
		} else {
			return Boolean.valueOf(formDataStr);
		}
	}


	/** Convierte a Date
	 * @param formDataStr Cadena en formato dd-MM-yyyy
	 */
	public static Date toDate(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		}
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return format.parse(formDataStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/** Convierte a Date
	 * @param formDataStr Cadena
	 * @param format formato
	 */
	public static Date toDate(String formDataStr, String formato) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		}
		DateFormat format = new SimpleDateFormat(formato);
		try {
			return format.parse(formDataStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/** Convierte a Date
	 * @param formDataStr Cadena en formato HH:mm
	 */
	public static Date toTime(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		}
		DateFormat format = new SimpleDateFormat("HH:mm");
		try {
			return format.parse(formDataStr);
		} catch (ParseException e) {
			return null;
		}
	}



	/**
	 * Convierte a Integer
	 * @param formDataStr
	 */
	public static Integer toInteger(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		} else {
			return Integer.valueOf(formDataStr);
		}
	}


	/**
	 * Convierte a int
	 * @param formDataStr
	 */
	public static int toInt(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return 0;
		} else {
			return Integer.valueOf(formDataStr);
		}
	}


	/**
	 * Convierte a Double
	 * @param formDataStr
	 */
	public static Double toDouble(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		} else {
			return Double.valueOf(formDataStr.replace(',', '.'));
		}
	}


	/**
	 * Convierte a Long
	 * @param formDataStr
	 */
	public static Long toLong(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		} else {
			return Long.valueOf(formDataStr);
		}
	}


	/**
	 * Convierte a char
	 * @param formDataStr
	 */
	public static Character toChar(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		} else {
			return formDataStr.charAt(0);
		}
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

	public static String timeToString(Date data) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		if (data != null) {
			return format.format(data);
		} else {
			return null;
		}
	}

	public static String dateTimeToString(Date data) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
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


	/**
	 * Convierte de Date a cadena formato dd-MM-yyyy
	 * @param data
	 */
	public static String toDetailedString(Date data, String locale) {
        Format formatter;
        String strData;

        formatter = new SimpleDateFormat("d", new Locale(locale));
        strData = formatter.format(data);

        formatter = new SimpleDateFormat("MMMM", new Locale(locale));
        if (formatter.format(data).substring(0, 1).matches("[aeiouAEIOU]")) {
        	strData += " d'";
        } else {
        	strData += " de ";
        }
        strData = formatter.format(data);

        formatter = new SimpleDateFormat("yyyy", new Locale(locale));
        strData += " de " + formatter.format(data);

		return strData;
	}

	/**
	 * Convierte un Double a String para presentación
	 * @param latitud
	 * @return
	 */
	public static String toString(Double d) {
		if (d == null) return "";
		return String.valueOf(d);
	}
	
	/**
	 * Convierte un float a String para presentación
	 * @param f
	 * @return
	 */
	public static String toString(Float f) {
		if (f == null) return "";
		return String.valueOf(f);
	}
	
	/**
	 * Convierte un integer a String para presentación
	 * @param i
	 * @return
	 */
	public static String toString(Integer i) {
		if (i == null) return "";
		return String.valueOf(i);
	}
	
	/**
	 * Convierte un objeto a String para presentación
	 * @param i
	 * @return
	 */
	public static String toString(Set<? extends BaseVO> set) {
		if (set == null || set.size() < 1) return "";
		boolean first = true;
		StringBuilder s = new StringBuilder();
		for (BaseVO o : set) {
			if (!first) {
				s.append(", ");
			}
			s.append(o.getPrimaryLabel());
			first = false;
		}
		
		return s.toString();
	}
	
	
	/**
	 * Convierte un objeto a String para presentación
	 * @param i
	 * @return
	 */
	public static String toString(Object o) {
		if (o == null) return "";
		return String.valueOf(o);
	}
	
	/**
	 * Convierte a BigDecimal
	 * @param formDataStr
	 * @param formato
	 */
	public static BigDecimal toBigDecimal(String formDataStr, String formato) {

		BigDecimal bd = null;

		if (!StringUtils.isEmpty(formDataStr) && !StringUtils.isEmpty(formato) ) {
			DecimalFormat format = new DecimalFormat(formato);
			try {
				double value =format.parse(formDataStr).doubleValue();
				bd = new BigDecimal(value);
			} catch (ParseException e) {
				return null;
			}
		}
		return bd;
	}
	public static BigDecimal toBigDecimal(String formDataStr) {
		if(formDataStr == null){
			return null;
		}
		Number number;
		try {
			number = NumberFormat.getInstance(Locale.FRANCE).parse(formDataStr);
		} catch (ParseException e) {
			return null;
		}
	    double d = number.doubleValue();
		return new BigDecimal(d);
	}


	public static float toFloat(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return 0;
		} else {
			return Float.valueOf(formDataStr.replace(',', '.'));
		}
	}


	public static Float toFloatObject(String formDataStr) {
		if (StringUtils.isEmpty(formDataStr)) {
			return null;
		} else {
			return Float.valueOf(formDataStr.replace(',', '.'));
		}
	}



    /**
     * Testea si la subcadena key existe en formData y la fija a null si es vacía
     * @param formData
     * @param key
     * @return si hay que modificar la cadena
     */
    public static boolean needsUpdate(Map<String, ?> formData, String key) {
    	if (!formData.containsKey(key)) {
    		return false;
    	}
    	if (StringUtils.isEmpty(formData, key)) {
    		formData.put(key, null); //Si es "", queremos que quede a null
    	}
    	return true;
    }






}
