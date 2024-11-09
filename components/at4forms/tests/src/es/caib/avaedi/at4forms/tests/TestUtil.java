package es.caib.avaedi.at4forms.tests;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

import org.hibernate.engine.jdbc.NonContextualLobCreator;



/**
 * Utilidades para generar datos para tests
 * @author agarcia
 *
 */
public class TestUtil {


	public static String decimales3 = "0,000";

	/**
	 * Genera un CLOB
	 */
	public static Clob newClob() {
		return NonContextualLobCreator.INSTANCE.wrap(NonContextualLobCreator.INSTANCE.createClob(newString()));
	}


	
	/**
	 * Genera un boolean
	 */
	public static boolean newBoolean() {
		return (Math.random() > 0.5);
	}

	/**
	 * Genera un char
	 */
	public static char newChar() {
		return "0123456789abcdefghijklmnopqrstuvwxyz".charAt( new Double(Math.random() * 30).intValue());
	}

	/**
	 * Genera un byte
	 */
	public static byte newByte() {
		return (byte)newChar();
	}

	/**
	 * Genera un short
	 */
	public static short newShort() {
		return (short)newChar();
	}

	/** Genera un Date
	 */
	public static Date newDate() {
		return new Date();
	}

	/**
	 * Genera un Integer positivo
	 */
	public static Integer newInteger() {
		return new Double(Math.ceil(Math.random() * 500)).intValue();
	}

	/**
	 * Genera un Integer positivo
	 */
	public static Integer newInteger(int max) {
		return new Double(Math.ceil(Math.random() * (max))).intValue();
		
	}

	/**
	 * Genera un Double
	 */
	public static Double newDouble() {
		return Math.random() * 500;
	}


	/**
	 * Genera un Long
	 */
	public static Long newLong() {
		return new Double(Math.random() * 500).longValue();
	}


	/**
	 * Genera un String
	 */
	public static String newString() {
		String ret = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eleifend lacus at diam facilisis, in semper leo porta. Nullam non vestibulum purus. Nulla dictum rhoncus metus, ac fringilla magna. Proin in dui lacus. Phasellus mattis laoreet velit ac aliquet. Nullam sit amet erat at nisl facilisis consectetur et sit amet tortor. Pellentesque facilisis, urna eu congue accumsan, nunc leo volutpat mauris, ut fermentum massa ligula ut erat. Curabitur lacinia nunc vel sapien fermentum auctor. Fusce id pretium nunc. Duis sit amet mauris in risus varius interdum in at tellus. Proin non posuere nisl. Donec elementum a tellus sit amet tempor. Etiam ullamcorper aliquet nulla at accumsan." +
				"Suspendisse iaculis lacus vitae mi aliquet vulputate. Donec tempor rhoncus purus a commodo. Maecenas pretium eleifend erat eget facilisis. Donec augue metus, bibendum sit amet diam id, facilisis cursus urna. Vivamus vulputate volutpat metus, a rhoncus mi porttitor sit amet. Sed sit amet ultrices nisl. Proin convallis viverra mi vitae viverra. Donec ut turpis ac sapien ullamcorper posuere." +
				"Suspendisse suscipit varius iaculis. Aenean pharetra tortor at mauris lacinia, eget dapibus leo ullamcorper. Pellentesque quis metus lorem. Fusce nec mauris non massa sollicitudin consequat at quis dolor. Nunc congue massa vel magna imperdiet viverra. Nullam congue ultricies orci at pellentesque. Ut lobortis interdum nisi, id elementum diam scelerisque at. Quisque malesuada suscipit elementum. Etiam ultrices sapien eu imperdiet rutrum. Maecenas rutrum consectetur est, scelerisque molestie dui rhoncus vel. Fusce a justo sit amet turpis tempus tempor at vel eros. In rhoncus rhoncus turpis a posuere. Phasellus gravida, mi a dignissim dignissim, massa quam mattis metus, vitae maximus magna arcu at odio." +
				"Nullam non tincidunt urna, sit amet dignissim eros. Praesent ullamcorper vel arcu quis tempus. Phasellus nibh ipsum, imperdiet vitae enim tincidunt, elementum condimentum dolor. In est nisi, sagittis in nunc et, lacinia ultricies mauris. Ut vel augue faucibus, lacinia urna ut, hendrerit mi. Maecenas vel lacinia sapien. Maecenas ultrices malesuada tellus ut convallis. Nunc imperdiet, dolor vitae porttitor condimentum, mi elit cursus ligula, sed pellentesque diam quam vel ante. Morbi tempor ligula leo, eget pretium turpis pharetra consectetur. Aenean sollicitudin, mauris eget maximus iaculis, magna diam accumsan leo, ac posuere erat risus a mauris. Maecenas consectetur, nisi in dictum euismod, orci velit aliquam dui, sit amet luctus lectus velit tempus ipsum. Phasellus sit amet sagittis nisi. In eleifend faucibus nunc sit amet volutpat. Proin malesuada ex diam, at euismod justo mollis dignissim."+
				"Mauris faucibus, erat eu mollis fermentum, lorem risus rhoncus turpis, vitae varius arcu nibh vel neque. Nunc felis est, efficitur ut aliquam nec, lacinia ac lacus. Nam commodo ac massa a elementum. Curabitur efficitur arcu quis tristique suscipit. Etiam vitae libero a justo varius pharetra vitae vel mauris. Aliquam nisi risus, convallis quis accumsan vel, malesuada ut nulla. Aenean suscipit nisi sed dui dictum malesuada a et sem. ";
		return ret.substring(0, newInteger());
	}

	/**
	 * Genera un String
	 */
	public static String newString(int maxLen) {
		String ret = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eleifend lacus at diam facilisis, in semper leo porta. Nullam non vestibulum purus. Nulla dictum rhoncus metus, ac fringilla magna. Proin in dui lacus. Phasellus mattis laoreet velit ac aliquet. Nullam sit amet erat at nisl facilisis consectetur et sit amet tortor. Pellentesque facilisis, urna eu congue accumsan, nunc leo volutpat mauris, ut fermentum massa ligula ut erat. Curabitur lacinia nunc vel sapien fermentum auctor. Fusce id pretium nunc. Duis sit amet mauris in risus varius interdum in at tellus. Proin non posuere nisl. Donec elementum a tellus sit amet tempor. Etiam ullamcorper aliquet nulla at accumsan." +
				"Suspendisse iaculis lacus vitae mi aliquet vulputate. Donec tempor rhoncus purus a commodo. Maecenas pretium eleifend erat eget facilisis. Donec augue metus, bibendum sit amet diam id, facilisis cursus urna. Vivamus vulputate volutpat metus, a rhoncus mi porttitor sit amet. Sed sit amet ultrices nisl. Proin convallis viverra mi vitae viverra. Donec ut turpis ac sapien ullamcorper posuere." +
				"Suspendisse suscipit varius iaculis. Aenean pharetra tortor at mauris lacinia, eget dapibus leo ullamcorper. Pellentesque quis metus lorem. Fusce nec mauris non massa sollicitudin consequat at quis dolor. Nunc congue massa vel magna imperdiet viverra. Nullam congue ultricies orci at pellentesque. Ut lobortis interdum nisi, id elementum diam scelerisque at. Quisque malesuada suscipit elementum. Etiam ultrices sapien eu imperdiet rutrum. Maecenas rutrum consectetur est, scelerisque molestie dui rhoncus vel. Fusce a justo sit amet turpis tempus tempor at vel eros. In rhoncus rhoncus turpis a posuere. Phasellus gravida, mi a dignissim dignissim, massa quam mattis metus, vitae maximus magna arcu at odio." +
				"Nullam non tincidunt urna, sit amet dignissim eros. Praesent ullamcorper vel arcu quis tempus. Phasellus nibh ipsum, imperdiet vitae enim tincidunt, elementum condimentum dolor. In est nisi, sagittis in nunc et, lacinia ultricies mauris. Ut vel augue faucibus, lacinia urna ut, hendrerit mi. Maecenas vel lacinia sapien. Maecenas ultrices malesuada tellus ut convallis. Nunc imperdiet, dolor vitae porttitor condimentum, mi elit cursus ligula, sed pellentesque diam quam vel ante. Morbi tempor ligula leo, eget pretium turpis pharetra consectetur. Aenean sollicitudin, mauris eget maximus iaculis, magna diam accumsan leo, ac posuere erat risus a mauris. Maecenas consectetur, nisi in dictum euismod, orci velit aliquam dui, sit amet luctus lectus velit tempus ipsum. Phasellus sit amet sagittis nisi. In eleifend faucibus nunc sit amet volutpat. Proin malesuada ex diam, at euismod justo mollis dignissim."+
				"Mauris faucibus, erat eu mollis fermentum, lorem risus rhoncus turpis, vitae varius arcu nibh vel neque. Nunc felis est, efficitur ut aliquam nec, lacinia ac lacus. Nam commodo ac massa a elementum. Curabitur efficitur arcu quis tristique suscipit. Etiam vitae libero a justo varius pharetra vitae vel mauris. Aliquam nisi risus, convallis quis accumsan vel, malesuada ut nulla. Aenean suscipit nisi sed dui dictum malesuada a et sem. ";
		return ret.substring(0, newInteger(maxLen));		
	}
	

	/**
	 * Genera un BigDecimal
	 */
	public static BigDecimal newBigDecimal() {

		return new BigDecimal(newDouble());
	}


	/**
	 * Genera un float
	 */
	public static float newFloat() {
		return new Double(Math.random() * 500).floatValue();
	}





}
