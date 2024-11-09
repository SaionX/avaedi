package es.caib.avaedi.logic.vo;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario ConfigAplicacion
 */
@DataTransferObject
public class ConfigAplicacionFormVO extends ConfigAplicacionListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	public ConfigAplicacionFormVO() {
	}

}
