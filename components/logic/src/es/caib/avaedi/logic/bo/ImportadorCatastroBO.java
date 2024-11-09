package es.caib.avaedi.logic.bo;

import java.util.List;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioListadoVO;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.Lrcdnp;
import es.caib.avaedi.meh.catastro.Muni;

public interface ImportadorCatastroBO {

	String importarMunicipios() throws GenericBusinessException, CatastroSoapException;

	MunicipioFormVO municipioSoap2VO(Muni instance);

	EdificioFormVO bicoSoap2VO(Bico instance);

	String importarVias(String municipio) throws GenericBusinessException, CatastroSoapException;

	List<EdificioListadoVO> lrcdnpSoap2VO(Lrcdnp datosSoap);

}
