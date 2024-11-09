package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.common.model.ValorId;

/**
 * TransferObject para la implementacion del listado Valor
 */
@DataTransferObject
public class ValorListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}

	@Override
	public String getPrimaryLabel() {
		return "<b>"+ this.getCaracteristicaLabel() +"</b> - "+ this.getNombreEs();
	}

	private ValorId id;
	private String caracteristicaLabel;
	private String caracteristicaId;
	private String nombreEs;
	private String nombreCa;

	public ValorListadoVO() {
	}

	public ValorId getId() {
		return this.id;
	}

	public void setId(ValorId id) {
		this.id = id;
	}

	public String getCaracteristicaLabel() {
		return this.caracteristicaLabel;
	}

	public void setCaracteristicaLabel(String caracteristicaLabel) {
		this.caracteristicaLabel = caracteristicaLabel;
	}

	public String getCaracteristicaId() {
		return this.caracteristicaId;
	}

	public void setCaracteristicaId(String caracteristicaId) {
		this.caracteristicaId = caracteristicaId;
	}

	public String getNombreEs() {
		return this.nombreEs;
	}

	public void setNombreEs(String nombreEs) {
		this.nombreEs = nombreEs;
	}

	public String getNombreCa() {
		return this.nombreCa;
	}

	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}

}
