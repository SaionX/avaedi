package es.caib.avaedi.logic.util;

/**
 * Clase de utilidad para detectar el entorno de ejecucion en el que estamos
 * corriendo (tomcat, jboss, etc)
 * 
 * @author agarcia
 * 
 */
public class RuntimeServerHelper {

	public static final String JBOSS_ID = "jboss";
	public static final String TOMCAT_ID = "tomcat";

	/**
	 * Instancia única
	 */
	static private RuntimeServerHelper _instance = null;

	/**
	 * @return The unique instance of this class.
	 */
	static public RuntimeServerHelper getInstance() {
		if (null == _instance) {
			_instance = new RuntimeServerHelper();
		}
		return _instance;
	}

	/* Declaramos el constructor private para evitar que otros creen instancias */
	private RuntimeServerHelper() {
	}

	public boolean serverSupportsEJB() {

		return this.isJBoss();

	}

	private Boolean isJboss = null;

	public boolean isJBoss() {
		if (this.isJboss == null) {
			this.isJboss = new Boolean(this.classExists("/org/jboss/Main.class"));
		}
		return this.isJboss.booleanValue();
	}

	private boolean classExists(String className) {
		try {
			ClassLoader.getSystemClassLoader().loadClass(className);
			return true;
		} catch (ClassNotFoundException cnfe) {
			if (this.getClass().getResource(className) != null) {
				return true;
			} else {
				return false;
			}
		}
	}

}
