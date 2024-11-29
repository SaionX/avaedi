package es.caib.avaedi.logic.bo;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.logic.util.ArchivoDTO;
import es.caib.avaedi.logic.vo.ResultadoImportacionListadoVO;

import java.util.Date;

public interface ImportadorBO {

	ResultadoImportacionListadoVO importarInforme(ArchivoDTO iee, ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String tipusIEE, boolean renovacio, boolean subsana) throws GenericBusinessException;
	ResultadoImportacionListadoVO importarInformeIte(ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String numeroCadastre, boolean favorable) throws GenericBusinessException;
	ResultadoImportacionListadoVO importarInformeSubsana(ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String numeroCadastre) throws GenericBusinessException;

	ResultadoImportacionListadoVO saveImport(Integer claveInforme, Integer estadoInformeId, String numeroExtra, Integer edificioAction) throws GenericBusinessException;

	boolean cancelImport(Long informeId, boolean municipioUnico, Integer municipioPermitido) throws GenericBusinessException;

}
