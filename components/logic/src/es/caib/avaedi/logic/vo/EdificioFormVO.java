package es.caib.avaedi.logic.vo;

import java.util.Set;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario Edificio
 */
@DataTransferObject
public class EdificioFormVO extends EdificioListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	private Set<InformeListadoVO> informes;

	public EdificioFormVO() {
	}

	public Set<InformeListadoVO> getInformes() {
		return this.informes;
	}

	public void setInformes(Set<InformeListadoVO> informes) {
		this.informes = informes;
	}

}
