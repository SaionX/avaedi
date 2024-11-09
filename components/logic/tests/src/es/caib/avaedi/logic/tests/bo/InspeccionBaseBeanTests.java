package es.caib.avaedi.logic.tests.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.at4forms.tests.BaseBeanTests;
import es.caib.avaedi.at4forms.tests.TestUtil;
import es.caib.avaedi.logic.bo.EdificioBO;
import es.caib.avaedi.logic.bo.EstadoInformeBO;
import es.caib.avaedi.logic.bo.InformeBO;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.bo.TipoViaBO;
import es.caib.avaedi.logic.bo.ValorBO;
import es.caib.avaedi.logic.bo.ViaBO;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.InformeFormVO;
import es.caib.avaedi.logic.vo.InspeccionFormVO;
import es.caib.avaedi.logic.vo.ValorListadoVO;
import es.caib.avaedi.logic.vo.ViaFormVO;

public abstract class InspeccionBaseBeanTests<FO extends FormVO, B extends BaseBO<? extends ListadoVO, FO>> extends BaseBeanTests<FO, B> {

	/**
	*Bean para acceder a los metodos de negocio: Informe
	*/
 @Autowired @Qualifier("InformeBean")
	private InformeBO informeBO;

	/**
	*Bean para acceder a los metodos de negocio: Valor
	*/
 @Autowired @Qualifier("ValorBean")
	private ValorBO valorBO;
	
	/**
	 * Rellena una instancia de Inspeccion aleatoriamente
	 */
	protected InspeccionFormVO fillNewRecord(InspeccionFormVO record) throws GenericBusinessException  {
		
		Date ahora = new Date();
		record.setDateCreation(ahora);
		record.setLastModified(ahora);
		record.setCreatorUser("testrunner");
		record.setModUser("testrunner");
		this.fillRandomRecord(record, false);
		return record;
	}
 
	/**
	 * Rellena una instancia de Inspeccion aleatoriamente
	 */
	protected InspeccionFormVO fillRandomRecord(InspeccionFormVO record, boolean forUpdate) throws GenericBusinessException  {

		if (!forUpdate) {
			//Damos de alta un informe
			InformeFormVO informe = fillNewRecord(new InformeFormVO());
			informe = this.informeBO.add(informe);
			//record.setInformeId( this.informeBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );
			record.setInformeId(informe.getClave());
		}
  

		record.setAccesibilidadAjustesrazonablesCostes( TestUtil.newString(255) );
  
		record.setConservacionDatosgeneralesArchivos( TestUtil.newString(255) );
  
		record.setIeeCompleta( TestUtil.newInteger() );
  
		record.setAlturaSobreRasante( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setAnoConstruccion( TestUtil.newInteger() );
  
		record.setAnoConstruccionReferencia( TestUtil.newString(255) );
  
		record.setAnoRehabilitacion( TestUtil.newInteger() );
  
		record.setAnoRehabilitacionReferencia( TestUtil.newString(255) );
  
		record.setInspeccionDatosedificioNucleosescalerasTipoId( TestUtil.newInteger() );
  
		record.setInspeccionDatosedificioParcelaTipoId( TestUtil.newInteger() );
  
		record.setInspeccionDatosedificioUnnucleoescalerasTipoId( TestUtil.newInteger() );
  
		record.setInspeccionDatosedificioUsoTipoId( TestUtil.newInteger() );
  
		record.setMediaViviendasPorPlanta( TestUtil.newInteger() );
  
		record.setNumAparcamientos( TestUtil.newInteger() );
  
		record.setNumLocales( TestUtil.newInteger() );
  
		record.setNumTrasteros( TestUtil.newInteger() );
  
		record.setNumViviendas( TestUtil.newInteger() );
  
		record.setPlantasBajoRasanteUsoPrincipal( TestUtil.newInteger() );
  
		record.setPlantasBajoRasanteUsosSecundarios( TestUtil.newInteger() );
  
		record.setPlantasBajoRasanteUsosSecundariosTipo( TestUtil.newString(255) );
  
		record.setPlantasSobreRasanteUsoPrincipal( TestUtil.newInteger() );
  
		record.setPlantasSobreRasanteUsosSecundarios( TestUtil.newInteger() );
  
		record.setPlantasSobreRasanteUsosSecundariosTipo( TestUtil.newString(255) );
  
		record.setSuperficieConstruida( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setSuperficieMediaAparcamientos( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setSuperficieMediaLocales( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setSuperficieMediaTrasteros( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setSuperficieMediaViviendas( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setSuperficieParcela( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setTotalAscensores( TestUtil.newString(255) );
  
		record.setTotalEscaleras( TestUtil.newString(255) );
  
		record.setTotalViviendasConAccesoVariosNucleos( TestUtil.newString(255) );
  
		record.setTotalViviendasSinAccesoAscensor( TestUtil.newString(255) );
  
		record.setUsoTexto( TestUtil.newString(255) );
  
		record.setNumero( TestUtil.newInteger() );
  
		record.setTipoVia( TestUtil.newString(255) );
  
		record.setVia( TestUtil.newString(255) );
  
		record.setPrincipal( TestUtil.newBoolean() );
  
		record.setReferenciaCatastral( TestUtil.newString(255) );
  
		record.setEdificioCodigoPostal( TestUtil.newString(255) );
  
		record.setEdificioComunTexto( TestUtil.newString(255) );
  
		record.setEdificioInspeccionIdentificacionedificioComunesTipoId( TestUtil.newInteger() );
  
		record.setEdificioInspeccionIdentificacionedificioObjetoTipoId( TestUtil.newInteger() );
  
		record.setEdificioInspeccionPropiedadRegimenTipoId( TestUtil.newInteger() );
  
		record.setEdificioNumeroManual( TestUtil.newString(255) );
  
		record.setEdificioObjetoTexto( TestUtil.newString(255) );
  
		record.setEdificioObservaciones( TestUtil.newString(255) );
  
		record.setEdificioPisoLetra( TestUtil.newString(255) );
  
		record.setEdificioPoblacion( TestUtil.newString(255) );
  
		record.setEdificioProvincia( TestUtil.newString(255) );
  
		record.setEdificioProvinciaId( TestUtil.newInteger() );
  
		record.setEdificioRegimenTexto( TestUtil.newString(255) );
  
		record.setEdificioTipoViaManual( TestUtil.newString(255) );
  
		record.setEdificioViaManual( TestUtil.newString(255) );
  
		record.setPropiedadNif( TestUtil.newString(255) );
  
		record.setPropiedadTitular( TestUtil.newString(255) );
  
		record.setRepresentanteCodigoPostal( TestUtil.newString(255) );
  
		record.setRepresentanteCondicion( TestUtil.newString(255) );
  
		record.setRepresentanteDireccion( TestUtil.newString(255) );
  
		record.setRepresentanteEmail( TestUtil.newString(255) );
  
		record.setRepresentanteNif( TestUtil.newString(255) );
  
		record.setRepresentanteNombre( TestUtil.newString(255) );
  
		record.setRepresentantePoblacion( TestUtil.newString(255) );
  
		record.setRepresentanteProvincia( TestUtil.newString(255) );
  
		record.setRepresentanteTelefonoFijo( TestUtil.newString(255) );
  
		record.setRepresentanteTelefonoMovil( TestUtil.newString(255) );
  
		record.setTecnicoNif( TestUtil.newString(255) );
  
		record.setTecnicoTecnico( TestUtil.newString(255) );
  
		record.setTecnicoTitulacion( TestUtil.newString(255) );
  
			Set<ValorListadoVO> elementsValores = new HashSet<ValorListadoVO>();
			ValorListadoVO elementValores = new ValorListadoVO();
			elementValores.setId(this.valorBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getId());
			elementsValores.add(elementValores);
			record.setValores( elementsValores );
  

	return record;
	}

	/**
	*Bean para acceder a los metodos de negocio: EstadoInforme
	*/
 @Autowired @Qualifier("EstadoInformeBean")
	private EstadoInformeBO estadoInformeBO;
	
	/**
	*Bean para acceder a los metodos de negocio: Edificio
	*/
 @Autowired @Qualifier("EdificioBean")
	private EdificioBO edificioBO;
	
	/**
	*Bean para acceder a los metodos de negocio: Via
	*/
@Autowired @Qualifier("ViaBean")
	private ViaBO viaBO;
	
/**
*Bean para acceder a los metodos de negocio: TipoVia
*/
@Autowired @Qualifier("TipoViaBean")
private TipoViaBO tipoViaBO;

/**
*Bean para acceder a los metodos de negocio: Municipio
*/
@Autowired @Qualifier("MunicipioBean")
private MunicipioBO municipioBO;

	private InformeFormVO fillNewRecord(InformeFormVO record) throws GenericBusinessException {

			Date ahora = new Date();
			record.setDateCreation(ahora);
			record.setLastModified(ahora);
			record.setCreatorUser("testrunner");
			record.setModUser("testrunner");
		
			record.setEstadoInformeId( this.estadoInformeBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

			EdificioFormVO edificio = fillNewRecord(new EdificioFormVO());
			edificio = this.edificioBO.add(edificio);
			record.setEdificioId( edificio.getClave() );
			record.setFechaInforme( TestUtil.newDate() );
			record.setFechaAlta( TestUtil.newDate() );

			return record;

	}
	
	/**
	 * Rellena una instancia de Edificio aleatoriamente
	 */
	protected EdificioFormVO fillNewRecord(EdificioFormVO record) throws GenericBusinessException  {

		Date ahora = new Date();
		record.setDateCreation(ahora);
		record.setLastModified(ahora);
		record.setCreatorUser("testrunner");
		record.setModUser("testrunner");
  
		ViaFormVO via = fillNewRecord(new ViaFormVO());
		via = this.viaBO.add(via);
		record.setViaId( via.getClave() );

		record.setNumeroCatastro( TestUtil.newString(64) );
		record.setNumeroExtra( TestUtil.newString(64) );
		record.setReferenciaCatastral( TestUtil.newString(14) );
		record.setAntiguedad( TestUtil.newInteger() );
		record.setCentroX( null  );
		record.setCentroY( null );

	return record;
	}
	
	/**
	 * Rellena una instancia de Via aleatoriamente
	 */
	protected ViaFormVO fillNewRecord(ViaFormVO record) throws GenericBusinessException  {

		Date ahora = new Date();
		record.setDateCreation(ahora);
		record.setLastModified(ahora);
		record.setCreatorUser("testrunner");
		record.setModUser("testrunner");
  
		record.setTipoViaId( this.tipoViaBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );
		record.setMunicipioId( this.municipioBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		record.setNombre( TestUtil.newString(255) );
  
		record.setCodigoCatastro( TestUtil.newInteger() );

	return record;
	}
	
}
