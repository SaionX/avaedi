package es.caib.avaedi.logic.tests.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.logic.bo.*;
import es.caib.avaedi.logic.vo.*;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.tests.BaseBeanTests;
import es.caib.avaedi.at4forms.tests.TestUtil;
import es.caib.avaedi.common.model.*;

import java.util.*;

import org.junit.Test;


/**
 * Tests para el Bean: AccesibilidadPublicos
 * @author agarcia@at4.net
 *
 */
public class AccesibilidadPublicosBeanTest extends InspeccionBaseBeanTests<AccesibilidadPublicosFormVO, AccesibilidadPublicosBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AccesibilidadPublicos
	 */
	@Autowired @Qualifier("AccesibilidadPublicosBean")
	protected AccesibilidadPublicosBO mainBean;

	/** Bean para acceder a los métodos de negocio: AccesibilidadPublicos
	 */
	protected AccesibilidadPublicosBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Inspeccion
	*/
 @Autowired @Qualifier("InspeccionBean")
	private InspeccionBO inspeccionBO;
	
	/** Bean para acceder a los metodos de negocio: Inspeccion
	* @param bean the bean to set
	*/
	public void setInspeccionBO(InspeccionBO bean) {
		this.inspeccionBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByInspeccionTest() throws GenericBusinessException {
		int inspeccionId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInspeccion(inspeccionId);
	}





	/**
	 * Rellena una instancia de AccesibilidadPublicos aleatoriamente
	 */
	protected AccesibilidadPublicosFormVO fillRandomRecord(AccesibilidadPublicosFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			//record.setInspeccionId( this.inspeccionBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getId() );
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setAlojamientosaccesibles1porcada50( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesMinimo1( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesMinimo2( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesMinimo4( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesMinimo6( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesMinimo8( TestUtil.newString(255) );
  
		record.setAlojamientosaccesiblesObservaciones( TestUtil.newString(255) );
  
		record.setAparcamientoComercialPorfraccion( TestUtil.newString(255) );
  
		record.setAparcamientoObservaciones( TestUtil.newString(255) );
  
		record.setAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion( TestUtil.newString(255) );
  
		record.setAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion( TestUtil.newString(255) );
  
		record.setAparcamientoResidencialpublicoPoralojamiento( TestUtil.newString(255) );
  
		record.setAparcamientoSillaruedas( TestUtil.newString(255) );
  
		record.setEntreplantasAccesible( TestUtil.newInteger() );
  
		record.setEntreplantasAccesibleAscensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasAccesibleAscensornoaccesibleDimensiones( TestUtil.newString(255) );
  
		record.setEntreplantasAccesibleAscensororampaaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasAccesibleRampaascensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasElementosaccesibles( TestUtil.newInteger() );
  
		record.setEntreplantasElementosaccesiblesAscensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasElementosaccesiblesAscensornoaccesibleDimensione( TestUtil.newString(255) );
  
		record.setEntreplantasElementosaccesiblesAscensororampaaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasElementosaccesiblesRampaascensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasNoaccesible( TestUtil.newInteger() );
  
		record.setEntreplantasNoaccesibleAscensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasNoaccesibleAscensornoaccesibleDimensiones( TestUtil.newString(255) );
  
		record.setEntreplantasNoaccesibleAscensororampaaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasNoaccesibleRampaascensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasObservaciones( TestUtil.newString(255) );
  
		record.setEntreplantasZonasusopublico( TestUtil.newInteger() );
  
		record.setEntreplantasZonasusopublicoAscensornoaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasZonasusopublicoAscensornoaccesibleDimensiones( TestUtil.newString(255) );
  
		record.setEntreplantasZonasusopublicoAscensororampaaccesible( TestUtil.newString(255) );
  
		record.setEntreplantasZonasusopublicoRampaascensornoaccesible( TestUtil.newString(255) );
  
		record.setEsTecnicoInspeccion( TestUtil.newInteger() );
  
		record.setExteriorEdificioitinerarioaccesibleViapublica( TestUtil.newInteger() );
  
		record.setExteriorEdificioitinerarioaccesibleZonascomunes( TestUtil.newInteger() );
  
		record.setExteriorObservaciones( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionAscensores( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionAscensoresBrailearabigo( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionAscensoresNumeroplanta( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactiles( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactilesArranqueescalera( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactilesColorcontrastado( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactilesItinerarioaccesi( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactilesRelieveexterior( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBandasvisualestactilesRelieveinterior( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBuclemagnetico( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionBuclemagneticoSenalizado( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionObservaciones( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPrivadoSiaAparcamiento( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPrivadoSiaAscensores( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPrivadoSiaEntradas( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPrivadoSiaItinerarios( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPrivadoSiaPlazasreservadas( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaAparcamiento( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaAscensores( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaEntradas( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaItinerarios( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaPlazasreservadas( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaPuntosatencion( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionPublicoSiaServicioshigienicos( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionServicioshigienicossenalizados( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionSianorma( TestUtil.newString(255) );
  
		record.setInformacionsenalizacionTodosusosObservaciones( TestUtil.newString(255) );
  
		record.setMecanismosAccesibles( TestUtil.newString(255) );
  
		record.setMecanismosObservaciones( TestUtil.newString(255) );
  
		record.setMobiliariofijoObservaciones( TestUtil.newString(255) );
  
		record.setMobiliariofijoPuntoaccesible( TestUtil.newString(255) );
  
		record.setNif( TestUtil.newString(255) );
  
		record.setPiscinasEntradaaccesible( TestUtil.newString(255) );
  
		record.setPiscinasObservaciones( TestUtil.newString(255) );
  
		record.setPlantasItinerarioaccesibleElementosaccesibles( TestUtil.newInteger() );
  
		record.setPlantasItinerarioaccesibleEntresi( TestUtil.newInteger() );
  
		record.setPlantasItinerarioaccesibleObservaciones( TestUtil.newString(255) );
  
		record.setPlantasItinerarioaccesibleZonasusoprivado( TestUtil.newInteger() );
  
		record.setPlantasItinerarioaccesibleZonasusopublico( TestUtil.newInteger() );
  
		record.setPlazasreservadasDiscapacidadauditiva( TestUtil.newString(255) );
  
		record.setPlazasreservadasObservaciones( TestUtil.newString(255) );
  
		record.setPlazasreservadasSillaruedas( TestUtil.newString(255) );
  
		record.setPlazasreservadasZonaesperaSillaruedas( TestUtil.newString(255) );
  
		record.setServicioshigienicosAseoaccesible( TestUtil.newString(255) );
  
		record.setServicioshigienicosCabinaduchaaccesibles( TestUtil.newString(255) );
  
		record.setServicioshigienicosObservaciones( TestUtil.newString(255) );
  
		record.setTecnico( TestUtil.newString(255) );
  
		record.setTitulacion( TestUtil.newString(255) );

	return record;
	}

}


