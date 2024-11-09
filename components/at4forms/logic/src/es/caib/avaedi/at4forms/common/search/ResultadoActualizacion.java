package es.caib.avaedi.at4forms.common.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.beans.BeanUtils;

import es.caib.avaedi.at4forms.logic.vo.ListadoVO;

/**
 * Encapsula el resultado de una actualización
 * @author agarcia
 */
@DataTransferObject
public class ResultadoActualizacion {

	private boolean correcto = true;
	private List<String> addedElementKeys = new ArrayList<String>();
	private List<String> updatedElementKeys = new ArrayList<String>();
	private List<String> deletedElementKeys = new ArrayList<String>();
	private String message;
	private Map<String, String> errors = new HashMap<String, String>();
	private List<String> warnings = new ArrayList<String>();

	private ListadoVO updatedElement = null;

	private String valor = null;
	private String debugMessage = "";

	
	public ResultadoActualizacion() {
	}

	/**
	 * Crea un ResultadoActualizacion a partir de otro
	 * @param ret
	 */
	public ResultadoActualizacion(ResultadoActualizacion ret) {
		
		BeanUtils.copyProperties(ret, this);
	}
	

	/** Indica si la ejecución se ejecutó correctamente
	 * @return correcto
	 */
	public boolean isCorrecto() {
		return this.correcto;
	}

	/** Fija si la ejecución se ejecutó correctamente
	 * @param correcto el valor correcto a fijar
	 */
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	/** success es un Alias de "correcto"
	 * @return correcto
	 */
	public boolean isSuccess() {
		return this.isCorrecto();
	}

	/** success es un Alias de "correcto"
	 * @param correcto the correcto to set
	 */
	public void setSuccess(boolean correcto) {
		this.setCorrecto(correcto);
	}

	/** Añade el elemento como uno de los añadidos
	 *
	 * @param claveElemento
	 */
	public void addedElement(String claveElemento) {
		this.addedElementKeys.add(claveElemento);
	}

	/**
	 * Añade el elemento como uno de los eliminados
	 * @param id
	 */
	public void deletedElement(String id) {
		this.deletedElementKeys.add(id);
	}

	/**
	 * Añade el elemento como uno de los actualizados
	 * @param id
	 */
	public void updatedElement(String id) {
		this.updatedElementKeys.add(id);
	}

	/**
	 * Añade un mensaje de error. Además, fija correcto a false
	 * @param id
	 * @param message
	 */
	public void addError (String id, String message) {
		this.errors.put(id, message);
		this.setCorrecto(false);
	}

	/** Devuelve la lista de claves añadidas
	 * @return la lista de claves añadidas
	 */
	public List<String> getAddedElementKeys() {
		return this.addedElementKeys;
	}

	/** Fija la lista de claves añadidas
	 * @param addedElementKeys la lista de claves añadidas
	 */
	public void setAddedElementKeys(List<String> addedElementKeys) {
		this.addedElementKeys = addedElementKeys;
	}

	/** Devuelve la lista de claves actualizadas
	 * @return la lista de claves actualizadas
	 */
	public List<String> getUpdatedElementKeys() {
		return this.updatedElementKeys;
	}

	/** Fija la lista de claves actualizadas
	 * @param updatedElementKeys la lista de claves actualizadas
	 */
	public void setUpdatedElementKeys(List<String> updatedElementKeys) {
		this.updatedElementKeys = updatedElementKeys;
	}

	/** Devuelve la lista de claves eliminadas
	 * @return la lista de claves eliminadas
	 */
	public List<String> getDeletedElementKeys() {
		return this.deletedElementKeys;
	}

	/** Fija la lista de claves eliminadas
	 * @param deletedElementKeys la lista de claves eliminadas
	 */
	public void setDeletedElementKeys(List<String> deletedElementKeys) {
		this.deletedElementKeys = deletedElementKeys;
	}

	/** Devuelve el mensaje de error
	 * @return el mensaje de error
	 */
	public String getMessage() {
		return this.message;
	}

	/** Fija el mensaje de error
	 * @param message el mensaje de error
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** Devuelve la lista de errores, que es un mapa: campo->mensaje
	 * @return la lista de errores
	 */
	public Map<String, String> getErrors() {
		return this.errors;
	}

	/** Fija la lista de errores
	 * @param errors la lista de errores
	 */
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	/** Devuelve el elemento modificado
	 * @return el elemento modificado
	 */
	public ListadoVO getUpdatedElement() {
		return this.updatedElement;
	}

	/** Fija el elemento modificado
	 * @param contenidoFormulario el elemento modificado
	 */
	public void setUpdatedElement(ListadoVO updatedElement) {
		this.updatedElement = updatedElement;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setUpdatedElementKeys(Long[] expedientIds) {
		ArrayList<String> idsStringList = new ArrayList<String>();
		for (Long id : expedientIds) {
			idsStringList.add(id.toString());
		}
		this.setUpdatedElementKeys(idsStringList);
	}

	public void setDebugMessage(String log) {
		
		this.debugMessage = log;
		
	}

	/**
	 * @return the debugMessage
	 */
	public String getDebugMessage() {
		return debugMessage;
	}

	public void addWarning(String message) {
		this.warnings.add(message);
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}


}
