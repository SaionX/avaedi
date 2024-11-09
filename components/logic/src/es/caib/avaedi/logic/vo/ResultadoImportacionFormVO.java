package es.caib.avaedi.logic.vo;

import es.caib.avaedi.at4forms.logic.vo.FormVO;

public class ResultadoImportacionFormVO extends ResultadoImportacionListadoVO implements FormVO {

	private static final long serialVersionUID = -3770418301657665943L;

	public ResultadoImportacionFormVO(EdificioFormVO[] edificiosDisponibles, EstadoInformeFormVO[] estadoInformes, InformeFormVO informe, boolean edificioExistia) {
		super(edificiosDisponibles, estadoInformes, informe, edificioExistia);
	}

	public ResultadoImportacionFormVO() {
		super();
	}
}