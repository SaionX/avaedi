package es.caib.avaedi.at4forms.front.service.items;

import java.util.HashMap;
import java.util.Map;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;


/**
 * Interfaz que describe al bean capaz de mantener la configuración actual del sistema At4Framework
 * @author agarcia
 *
 */
public interface ConfigHolder {

	/**
	 * Configuración actual del sistema At4Framework
	 * @author agarcia
	 *
	 */
	public class Config {

		private int periodicidadCambiosEstado;
		private int numDiasAvisoPresentarComision;
		private String idiomaDefecto;
		private String subtituloEmpresa;
		private String nombreEmpresa;
		private Map<String, String> valueMap = new HashMap<String, String>();

		/** Devuelve la periodidicad para avisar de cambios de estado en proyectos
		 * @return la periodidicad para avisar de cambios de estado en proyectos
		 */
		public int getPeriodicidadCambiosEstado() {
			return this.periodicidadCambiosEstado;
		}

		/** Fija la periodidicad para avisar de cambios de estado en proyectos
		 * @param periodicidadCambiosEstado la periodidicad para avisar de cambios de estado en proyectos
		 */
		public void setPeriodicidadCambiosEstado(int periodicidadCambiosEstado) {
			this.periodicidadCambiosEstado = periodicidadCambiosEstado;
		}

		/** Devuelve la periodicidad (en días) para aviso de propuestas en estado "PresentarComision"
		 * @return periodicidad (en días) para aviso de propuestas en estado "PresentarComision"
		 */
		public int getNumDiasAvisoPresentarComision() {
			return this.numDiasAvisoPresentarComision;
		}

		/** Fija la periodicidad (en días) para aviso de propuestas en estado "PresentarComision"
		 * @param numDiasAvisoPresentarComision periodicidad (en días) para aviso de propuestas en estado "PresentarComision"
		 */
		public void setNumDiasAvisoPresentarComision(int numDiasAvisoPresentarComision) {
			this.numDiasAvisoPresentarComision = numDiasAvisoPresentarComision;
		}

		/** Devuelve el idioma por defecto de la aplicación
		 * @return el idioma por defecto de la aplicación
		 */
		public String getIdiomaDefecto() {
			return this.idiomaDefecto;
		}

		/** Fija el idioma por defecto de la aplicación
		 * @param idiomaDefecto el idioma por defecto de la aplicación
		 */
		public void setIdiomaDefecto(String idiomaDefecto) {
			this.idiomaDefecto = idiomaDefecto;
		}

		/** Devuelve el subtítulo de la empresa para mostrar en la aplicación
		 * @return el subtítulo de la empresa
		 */
		public String getSubtituloEmpresa() {
			return this.subtituloEmpresa;
		}

		/** Fija el subtítulo de la empresa para mostrar en la aplicación
		 * @param subtituloEmpresa el subtítulo de la empresa
		 */
		public void setSubtituloEmpresa(String subtituloEmpresa) {
			this.subtituloEmpresa = subtituloEmpresa;
		}

		/** Devuelve el título de la empresa para mostrar en la aplicación
		 * @return el título de la empresa
		 */
		public String getNombreEmpresa() {
			return this.nombreEmpresa;
		}

		/** Fija el título de la empresa
		 * @param nombreEmpresa el título de la empresa
		 */
		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}

		/**
		 * Fija el valor de una propiedad de configuración
		 * @param codi
		 * @param valor
		 */
		public void putValue(String codi, String valor) {
			this.valueMap.put(codi, valor);
		}

		/**
		 * Devuelve el valor de una propiedad de configuración
		 * @param codi
		 * @return valor de una propiedad de configuración
		 */
		public String getValue (String codi) {
			return this.valueMap.get(codi);
		}

	}

	/**
	 * Obtiene la configuración actual
	 * @return la configuración actual
	 * @throws GenericBusinessException
	 */
    public Config getConfig() throws GenericBusinessException;

    /**
     * Recarga la configuración
     */
    public void reloadConfig();

}
