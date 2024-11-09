package es.caib.avaedi.at4forms.front.service.items;

import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.beans.BeanUtils;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * Transfer Object para el contenido de un formulario
 * @author agarcia
 *
 */
@DataTransferObject
public class ContenidoFormulario<T extends FormVO> {

	private T data = null;
	private boolean success = true;

	private boolean canDelete = true;
	private boolean canUpdate = true;
	
	public ContenidoFormulario(boolean success) {
		super();
		this.success = success;
	}

	public ContenidoFormulario(T data) {
		super();
		this.data = data;
		this.success = true;
	}


	public ContenidoFormulario(ContenidoFormulario<T> load) {
		BeanUtils.copyProperties(load, this);
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}


	/** Indica si se produjo algún error
	 * @return false si se produjo algún error
	 */
	public boolean isSuccess() {
		return this.success;
	}

	/** Fija si se produjo algún error
	 * @param success false si se produjo algún error, true en caso contrario
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/** Indica si los datos del el formulario son modificables
	 * @return si los datos del el formulario son modificables
	 */
	public boolean isCanUpdate() {
		return this.canUpdate;
	}


	/** Fija si los datos del el formulario son modificables
	 * @param canUpdate true si los datos del el formulario son modificables
	 */
	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}


	/** Indica si el contenido del formulario se puede eliminar
	 * @return true si el contenido del formulario se puede eliminar
	 */
	public boolean isCanDelete() {
		return this.canDelete;
	}

	/**
	 * Fija si el contenido del formulario se puede eliminar
	 * @param canDelete true si el contenido del formulario se puede eliminar
	 */
	public void setCanDelete(boolean canDelete) {
		   this.canDelete = canDelete;
	}

	
}
