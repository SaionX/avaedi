package es.caib.avaedi.logic.vo;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

public abstract class InspeccionBaseVO extends BaseVO {

	//Campos extra
	private String municipioLabel;
	private int municipioId;
	private int edificioId;
	private String edificioLabel;

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

	public int getEdificioId() {
		return edificioId;
	}

	public void setEdificioId(int edificioId) {
		this.edificioId = edificioId;
	}

	public String getEdificioLabel() {
		return edificioLabel;
	}

	public void setEdificioLabel(String edificioLabel) {
		this.edificioLabel = edificioLabel;
	}

	public abstract String getInspeccionLabel();

	public abstract void setInspeccionLabel(String inspeccionLabel);

	public abstract int getInspeccionId();

	public abstract void setInspeccionId(int inspeccionId);

}
