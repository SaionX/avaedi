package es.caib.avaedi.logic.bo;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.logic.util.ArchivoDTO;
import es.caib.avaedi.logic.vo.ResultadoImportacionListadoVO;

public interface ImportadorBO {

	ResultadoImportacionListadoVO importarInforme(ArchivoDTO iee, ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId) throws GenericBusinessException;

	ResultadoImportacionListadoVO saveImport(Integer claveInforme, Integer estadoInformeId, String numeroExtra, Integer edificioAction) throws GenericBusinessException;

	boolean cancelImport(Long informeId, boolean municipioUnico, Integer municipioPermitido) throws GenericBusinessException;

}
