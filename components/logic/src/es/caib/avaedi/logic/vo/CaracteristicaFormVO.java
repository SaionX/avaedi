package es.caib.avaedi.logic.vo;

import java.util.Set;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

/**
 * TransferObject para el formulario Caracteristica
 */
@DataTransferObject
public class CaracteristicaFormVO extends CaracteristicaListadoVO implements FormVO {

	private static final long serialVersionUID = 1L;

	private Set<ValorListadoVO> valores;

	public CaracteristicaFormVO() {
	}

	public Set<ValorListadoVO> getValores() {
		return this.valores;
	}

	public void setValores(Set<ValorListadoVO> valores) {
		this.valores = valores;
	}

}
