package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado TipoVia
 */
@DataTransferObject
public class TipoViaListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getNombreEs();
	}

	private int clave;
	private String codigoCatastro;
	private String nombreEs;
	private String nombreCa;

	public TipoViaListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getCodigoCatastro() {
		return this.codigoCatastro;
	}

	public void setCodigoCatastro(String codigoCatastro) {
		this.codigoCatastro = codigoCatastro;
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
