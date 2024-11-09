package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado GrupoCaracteristicas
 */
@DataTransferObject
public class GrupoCaracteristicasListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getNombreEs();
	}

	private int id;
	private String nombreEs;
	private String nombreCa;

	public GrupoCaracteristicasListadoVO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
