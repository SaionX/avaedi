package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Caracteristica
 */
@DataTransferObject
public class CaracteristicaListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getCaracteristica();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getNombreEs();
	}

	private String caracteristica;
	private String grupoCaracteristicasLabel;
	private int grupoCaracteristicasId;
	private String nombreEs;
	private String nombreCa;

	public CaracteristicaListadoVO() {
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getGrupoCaracteristicasLabel() {
		return this.grupoCaracteristicasLabel;
	}

	public void setGrupoCaracteristicasLabel(String grupoCaracteristicasLabel) {
		this.grupoCaracteristicasLabel = grupoCaracteristicasLabel;
	}

	public int getGrupoCaracteristicasId() {
		return this.grupoCaracteristicasId;
	}

	public void setGrupoCaracteristicasId(int grupoCaracteristicasId) {
		this.grupoCaracteristicasId = grupoCaracteristicasId;
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
