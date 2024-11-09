package es.caib.avaedi.logic.bo;

import java.awt.Point;
import java.util.List;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.logic.vo.EdificioSoapVO;
import es.caib.avaedi.logic.vo.NumeroSoapVO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.meh.catastro.Bico;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaDnp;
import es.caib.avaedi.meh.catastro.www.Consulta_Coordenadas;

public interface DatosCatastroBO {

	EdificioSoapVO getEdificio(Integer viaId, String numero) throws GenericBusinessException, CatastroSoapException;

	EdificioSoapVO updateCoords(EdificioSoapVO resultado) throws GenericBusinessException;

	EdificioSoapVO getEdificio(Integer viaId, String numero, boolean withCoords) throws GenericBusinessException, CatastroSoapException;

	List<NumeroSoapVO> getNumeros(int municipioId, int viaId, String query) throws GenericBusinessException, CatastroSoapException;

	Point getCoords(String codigocatastro) throws GenericBusinessException;

	EdificioSoapVO getEdificio(String refCat) throws GenericBusinessException, CatastroSoapException;

	ConsultaDnp getDatosByRef(String refCat) throws GenericBusinessException, CatastroSoapException;

	EdificioSoapVO bico2Edificio(Bico bico, TipoViaFormVO tipoVia, ViaFormVO via);

	EdificioSoapVO bico2Edificio(Bico bico) throws GenericBusinessException;

	Consulta_Coordenadas getReferenciasByLoc(String coordenadaX, String coordenadaY) throws GenericBusinessException;

}
