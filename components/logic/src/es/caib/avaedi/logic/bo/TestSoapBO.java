package es.caib.avaedi.logic.bo;

import java.util.List;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaCoord;
import es.caib.avaedi.meh.catastro.Df;
import es.caib.avaedi.meh.catastro.Muni;
import es.caib.avaedi.meh.catastro.Numereror;

/**
 * TODO: Renombrar a DatosCatastroBO
 * 
 */
public interface TestSoapBO {

	List<Muni> getMunicipios(String provincia) throws GenericBusinessException, CatastroSoapException;

	List<Df> getCalles(String municipio, String tipoVia, String nombreVia) throws GenericBusinessException, CatastroSoapException;

	Bico getConsulta(String provincia, String municipio, String tipoVia, String calle, String numero, String bloque, String escalera, String planta, String puerta) throws GenericBusinessException, CatastroSoapException;

	Bico getConsulta(String municipio, String nombreVia, String numero) throws GenericBusinessException, CatastroSoapException;

	Bico getConsulta(Integer municipioId, Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException;

	Numereror getNumeros(Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException;

	ConsultaCoord getCoordenadas(String municipio, String referenciaCatastral) throws GenericBusinessException, CatastroSoapException;

	Numereror getNumeros(String provincia, String municipio, String tipoVia, String nombreVia, String numero) throws GenericBusinessException, CatastroSoapException;

}
