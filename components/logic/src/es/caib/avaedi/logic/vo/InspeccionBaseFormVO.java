package es.caib.avaedi.logic.vo;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

public interface InspeccionBaseFormVO extends FormVO {

	public String getMunicipioLabel();

	public void setMunicipioLabel(String municipioLabel);

	public int getMunicipioId();

	public void setMunicipioId(int municipioId);
}
