package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Via
 */
@DataTransferObject
public class ViaListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getNombre();
	}

	private int clave;
	private String tipoViaLabel;
	private int tipoViaId;
	private String municipioLabel;
	private int municipioId;
	private String nombre;
	private int codigoCatastro;

	public ViaListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getTipoViaLabel() {
		return this.tipoViaLabel;
	}

	public void setTipoViaLabel(String tipoViaLabel) {
		this.tipoViaLabel = tipoViaLabel;
	}

	public int getTipoViaId() {
		return this.tipoViaId;
	}

	public void setTipoViaId(int tipoViaId) {
		this.tipoViaId = tipoViaId;
	}

	public String getMunicipioLabel() {
		return this.municipioLabel;
	}

	public void setMunicipioLabel(String municipioLabel) {
		this.municipioLabel = municipioLabel;
	}

	public int getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoCatastro() {
		return this.codigoCatastro;
	}

	public void setCodigoCatastro(int codigoCatastro) {
		this.codigoCatastro = codigoCatastro;
	}

}
