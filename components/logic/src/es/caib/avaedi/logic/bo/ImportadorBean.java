package es.caib.avaedi.logic.bo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import es.caib.avaedi.at4forms.common.util.Constants;
import es.caib.avaedi.common.model.AcusticaMejorasAcusticas;
import es.caib.avaedi.logic.vo.*;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.common.model.AcusticaMejorasAcusticasId;
import es.caib.avaedi.iee.model.AccesibilidadAjustesrazonablesType;
import es.caib.avaedi.iee.model.AccesibilidadPublicosType;
import es.caib.avaedi.iee.model.AccesibilidadValoracionfinalesType;
import es.caib.avaedi.iee.model.AcusticaComprobacionesType;
import es.caib.avaedi.iee.model.AcusticaDatosgeneralesType;
import es.caib.avaedi.iee.model.AcusticaMedidasmejorasType;
import es.caib.avaedi.iee.model.AcusticaMejorasacusticasType;
import es.caib.avaedi.iee.model.AcusticaRuidoexteriorVentanaAperturasType;
import es.caib.avaedi.iee.model.AcusticaRuidoexteriorVentanaVidriosType;
import es.caib.avaedi.iee.model.AcusticaRuidoexteriorVentanasType;
import es.caib.avaedi.iee.model.AcusticaRuidoinstalacionesType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesGarajeOtrosType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesSueloflotanteTiposType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTechoCaracteristicasType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTechoTiposType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesTipoOtrosType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorhorizontalesType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorunionesType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesSeparacionElementosType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesSeparacionGruposType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesSeparacionSubgruposType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesSeparacionTiposType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesTabiquesCaracteristicasType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesTabiquesType;
import es.caib.avaedi.iee.model.AcusticaRuidointeriorverticalesType;
import es.caib.avaedi.iee.model.AcusticaRuidosexterioresType;
import es.caib.avaedi.iee.model.AcusticaValoracionfinalType;
import es.caib.avaedi.iee.model.AcusticasType;
import es.caib.avaedi.iee.model.CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType;
import es.caib.avaedi.iee.model.CerramientoscubiertasCarpinteriavidriovidriospredominantesType;
import es.caib.avaedi.iee.model.CerramientoscubiertasCubiertainclinadacoberturasType;
import es.caib.avaedi.iee.model.CerramientoscubiertasCubiertaplanatransitablesType;
import es.caib.avaedi.iee.model.CerramientoscubiertasFachadaprincipalacabadosrevestidosType;
import es.caib.avaedi.iee.model.CerramientoscubiertasFachadaprincipalacabadosvistosType;
import es.caib.avaedi.iee.model.CerramientoscubiertasOtrasfachadasacabadosrevestidosType;
import es.caib.avaedi.iee.model.CerramientoscubiertasOtrasfachadasacabadosvistosType;
import es.caib.avaedi.iee.model.CerramientoscubiertasType;
import es.caib.avaedi.iee.model.CimentacionesCimentacionesprofundasType;
import es.caib.avaedi.iee.model.CimentacionesCimentacionessuperficialesType;
import es.caib.avaedi.iee.model.CimentacionesSistemascontencionesType;
import es.caib.avaedi.iee.model.CimentacionesType;
import es.caib.avaedi.iee.model.ConservacionDatosgeneralesType;
import es.caib.avaedi.iee.model.DescripcionType;
import es.caib.avaedi.iee.model.DocumentacionOtroType;
import es.caib.avaedi.iee.model.EficienciasenergeticasType;
import es.caib.avaedi.iee.model.EstructurasCubiertacerchasporticosType;
import es.caib.avaedi.iee.model.EstructurasCubiertaforjadoshorizontalesType;
import es.caib.avaedi.iee.model.EstructurasCubiertaforjadosinclinadosType;
import es.caib.avaedi.iee.model.EstructurasCubiertaotrosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalplantatipoestructurasprincipalesType;
import es.caib.avaedi.iee.model.EstructurasHorizontalplantatipoforjadosentrevigadosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalplantatipoforjadossecundariosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalplantatipootrosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalsueloforjadosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalsueloforjadossanitariosType;
import es.caib.avaedi.iee.model.EstructurasHorizontalsuelootrosType;
import es.caib.avaedi.iee.model.EstructurasType;
import es.caib.avaedi.iee.model.EstructurasVerticalmuroscargasType;
import es.caib.avaedi.iee.model.EstructurasVerticalpilaresType;
import es.caib.avaedi.iee.model.HistoricoType;
import es.caib.avaedi.iee.model.InspeccionDatosedificiosType;
import es.caib.avaedi.iee.model.InspeccionIdentificacionedificiosType;
import es.caib.avaedi.iee.model.InspeccionPropiedadesType;
import es.caib.avaedi.iee.model.InspeccionRepresentantesType;
import es.caib.avaedi.iee.model.InspeccionTecnicosType;
import es.caib.avaedi.iee.model.InspeccionType;
import es.caib.avaedi.iee.model.InstalacionesAbastecimientocontadoresType;
import es.caib.avaedi.iee.model.InstalacionesAbastecimientosType;
import es.caib.avaedi.iee.model.InstalacionesAcscentralcombustiblesType;
import es.caib.avaedi.iee.model.InstalacionesCalefaccioncentralcombustiblesType;
import es.caib.avaedi.iee.model.InstalacionesCalefaccioncentralesType;
import es.caib.avaedi.iee.model.InstalacionesComunicacionesictsType;
import es.caib.avaedi.iee.model.InstalacionesContraincendiosType;
import es.caib.avaedi.iee.model.InstalacionesContrarayosType;
import es.caib.avaedi.iee.model.InstalacionesElectricacontadoresType;
import es.caib.avaedi.iee.model.InstalacionesElectricasType;
import es.caib.avaedi.iee.model.InstalacionesGascanalizadocombustiblesType;
import es.caib.avaedi.iee.model.InstalacionesGascanalizadocontadoresType;
import es.caib.avaedi.iee.model.InstalacionesRefrigeracioncolectivotorresType;
import es.caib.avaedi.iee.model.InstalacionesSaneamientobajantesType;
import es.caib.avaedi.iee.model.InstalacionesSaneamientocolectoresType;
import es.caib.avaedi.iee.model.InstalacionesSaneamientosType;
import es.caib.avaedi.iee.model.InstalacionesType;
import es.caib.avaedi.iee.model.InstalacionesVentilacionaparcamientosType;
import es.caib.avaedi.iee.model.InstalacionesVentilacioncuartoshumedosType;
import es.caib.avaedi.iee.model.ValoracionParcialType;
import es.caib.avaedi.logic.util.ArchivoDTO;
import es.caib.avaedi.logic.util.At4Utilities;
import es.caib.avaedi.meh.catastro.CatastroSoapException;
import es.caib.avaedi.meh.catastro.ConsultaDnp;
import es.caib.avaedi.meh.catastro.Dtdnp;
import es.caib.avaedi.meh.catastro.Locs;

@Component("ImportadorBean")
@Transactional(rollbackFor = { GenericBusinessException.class })
public class ImportadorBean implements ImportadorBO {

	public class ImportadorEventHandler implements ValidationEventHandler {

		@Override
		public boolean handleEvent(ValidationEvent ve) {
			log.error("Marshaller event handler says: " + ve.getMessage() + " (Exception: " + ve.getLinkedException() + ")");
			if (ve.getSeverity() == ValidationEvent.FATAL_ERROR) {
				return false;

			} else {
				return true;

			}
		}
	}

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ImportadorBean.class);

	@Autowired
	@Qualifier("DatosCatastroBean")
	@EJB
	private DatosCatastroBO datosCatastroBO;

	@Autowired
	@Qualifier("EdificioBean")
	@EJB
	private EdificioBO edificioBO;

	@Autowired
	@Qualifier("MunicipioBean")
	@EJB
	private MunicipioBO municipioBO;

	@Autowired
	@Qualifier("UsuarioBean")
	@EJB
	private UsuarioBO usuarioBO;

	@Autowired
	@Qualifier("ViaBean")
	@EJB
	private ViaBO viaBO;

	@Autowired
	@Qualifier("InformeBean")
	@EJB
	private InformeBO informeBO;

	@Autowired
	@Qualifier("InspeccionBean")
	@EJB
	private InspeccionBO inspeccionBO;

	@Autowired
	@Qualifier("BlobBean")
	@EJB
	private BlobBO blobBO;

	@Autowired
	@Qualifier("EstadoInformeBean")
	@EJB
	private EstadoInformeBO estadoInformeBO;

	//BEANS PARA ACCEDER A DATOS ESPECIFICOS DE INSPECCION
	@Autowired
	@Qualifier("AccesibilidadPublicosBean")
	@EJB
	private AccesibilidadPublicosBO accesibilidadPublicosBO;

	@Autowired
	@Qualifier("AcusticaRuidosInterioresUnionesBean")
	@EJB
	private AcusticaRuidosInterioresUnionesBO acusticaRuidosInterioresUnionesBO;

	@Autowired
	@Qualifier("AcusticaValoracionFinalBean")
	@EJB
	private AcusticaValoracionFinalBO acusticaValoracionFinalBO;

	@Autowired
	@Qualifier("AcusticaRuidosInterioresVerticalesBean")
	@EJB
	private AcusticaRuidosInterioresVerticalesBO acusticaRuidosInterioresVerticalesBO;

	@Autowired
	@Qualifier("AcusticaComprobacionesBean")
	@EJB
	private AcusticaComprobacionesBO acusticaComprobacionesBO;

	@Autowired
	@Qualifier("InstalacionesBean")
	@EJB
	private InstalacionesBO instalacionesBO;

	@Autowired
	@Qualifier("CerramientosCubiertasBean")
	@EJB
	private CerramientosCubiertasBO cerramientosCubiertasBO;

	@Autowired
	@Qualifier("AccesibilidadValoracionFinalesBean")
	@EJB
	private AccesibilidadValoracionFinalesBO accesibilidadValoracionFinalesBO;

	@Autowired
	@Qualifier("AcusticaRuidoInstalacionesBean")
	@EJB
	private AcusticaRuidoInstalacionesBO acusticaRuidoInstalacionesBO;

	@Autowired
	@Qualifier("EstructuraBean")
	@EJB
	private EstructuraBO estructuraBO;

	@Autowired
	@Qualifier("CimentacionesBean")
	@EJB
	private CimentacionesBO cimentacionesBO;

	@Autowired
	@Qualifier("AccesibilidadAjustesRazonablesBean")
	@EJB
	private AccesibilidadAjustesRazonablesBO accesibilidadAjustesRazonablesBO;

	@Autowired
	@Qualifier("EficienciasEnergeticasBean")
	@EJB
	private EficienciasEnergeticasBO eficienciaEnergeticaBO;

	@Autowired
	@Qualifier("AcusticaRuidosExterioresBean")
	@EJB
	private AcusticaRuidosExterioresBO acusticaRuidosExterioresBO;

	@Autowired
	@Qualifier("AcusticaMejorasAcusticasBean")
	@EJB
	private AcusticaMejorasAcusticasBO acusticaMejorasAcusticasBO;

	@Autowired
	@Qualifier("AcusticaRuidosInterioresHorizontalesBean")
	@EJB
	private AcusticaRuidosInterioresHorizontalesBO acusticaRuidosInterioresHorizontalesBO;

	@Autowired
	@Qualifier("AcusticaDatosGeneralesBean")
	@EJB
	private AcusticaDatosGeneralesBO acusticaDatosGeneralesBO;

	@Autowired
	@Qualifier("AcusticasBean")
	@EJB
	private AcusticasBO acusticasBO;

	@Autowired
	@Qualifier("ConservacionBean")
	@EJB
	private ConservacionBO conservacionBO;

	@Autowired
	@Qualifier("DeficienciaBean")
	@EJB
	private DeficienciaBO deficienciaBO;

	@Autowired
	@Qualifier("ValoracionParcialBean")
	@EJB
	private ValoracionParcialBO valoracionParcialBO;

	@Autowired
	@Qualifier("HistoricoBean")
	@EJB
	private HistoricoBO historicoBO;

	@Autowired
	@Qualifier("DocumentacionOtroBean")
	@EJB
	private DocumentacionOtroBO documentosBO;

	@Autowired
	@Qualifier("FechaVisitaBean")
	@EJB
	private FechaVisitaBO fechaVisitaBO;

	@Autowired
	@Qualifier("ValorBean")
	@EJB
	private ValorBO valorBO;

	//FIN DE BEANS PARA ACCEDER A DATOS ESPECIFICOS DE INSPECCION 

	@Override
	public ResultadoImportacionFormVO importarInforme(ArchivoDTO iee, ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String tipusIEE, boolean renovacio, boolean subsana) throws GenericBusinessException {

		Date now = new Date();
		InspeccionType inspeccionImportada = null;
		byte[] zipBytes = null;

		//TODO: Comprobar nombres, tamaños y extensiones.
		comprobarArchivos(iee, pdf);

		try {
			zipBytes = iee.getByteData();
		} catch (IOException e) {
			String error = "Error leyendo los datos del archivo IEE";
			log.error(error, e);
			throw new GenericBusinessException(error, e);
		}

		inspeccionImportada = this.extractInspeccionfromIee(new ByteArrayInputStream(zipBytes));
		//TODO: Comprobar que la importacion es una inspeccion de tipo completa

		String referenciaCatastral = null;
		if (inspeccionImportada.getInspeccionIdentificacionedificioReferenciacatastrales() == null || inspeccionImportada.getInspeccionIdentificacionedificioReferenciacatastrales().getReferencia() == null || inspeccionImportada.getInspeccionIdentificacionedificioReferenciacatastrales().getReferencia().getReferenciaCatastral() == null) {
			String error = "Error intentando recuperar la referencia catastral de la inspeccion a importar";
			log.error(error);
			throw new GenericBusinessException(error);

		} else {
			referenciaCatastral = inspeccionImportada.getInspeccionIdentificacionedificioReferenciacatastrales().getReferencia().getReferenciaCatastral();
		}

		ValidacioEdifici validacioEdifici = getValidacioEdifici(user, validarMunicipio, municipioId, referenciaCatastral, inspeccionImportada);

		InformeFormVO informeraw = new InformeFormVO();

		informeraw.setEdificioId(validacioEdifici.edificiosDisponibles[0].getClave());

		int estado = 5;

		informeraw.setEstadoInformeId(estado);
		informeraw.setFechaAlta(now);
//		informeraw.setFechaInforme(now);
		informeraw.setFechaInforme(dataFirma);

		setResumenAuditoria(informeraw, user, now);
		InformeFormVO informe = this.informeBO.add(informeraw);

		BlobFormVO archivoPDF = new BlobFormVO();
		BlobFormVO archivoIEE = new BlobFormVO();
		try {
			archivoPDF.setDatos(pdf.getByteData());
		} catch (IOException e) {
			String error = "Error leyendo los datos del archivo PDF";
			log.error(error, e);
			throw new GenericBusinessException(error, e);
		}
		archivoIEE.setDatos(zipBytes);

		setResumenAuditoria(archivoPDF, user, now);
		setResumenAuditoria(archivoIEE, user, now);

		archivoPDF = this.blobBO.add(archivoPDF);
		//TODO: Creo que el mime que usa es incorrecto porque luego se descarga en un formato raro
		archivoIEE = this.blobBO.add(archivoIEE);

		informe.setPdfArxiu(new Long(archivoPDF.getClave()));
		informe.setPdfArxiuMime(pdf.getMimeType());
		informe.setIeeArxiu(new Long(archivoIEE.getClave()));
		informe.setIeeArxiuMimeType(iee.getMimeType());
		informe.setTipusIee(tipusIEE);
		informe.setRenovacio(renovacio);
		informe.setSubsana(subsana);

		informe = this.informeBO.update(informe.getClave(), informe);

		//InspeccionFormVO inspeccion = this.generarInforme(inspeccionImportada, informe.getClave()); // Por ahora no necesitamos la inspeccion generada
		this.generarInforme(inspeccionImportada, informe.getClave());

		EstadoInformeFormVO[] estadosDisponibles = this.getEstadosDisponibles(inspeccionImportada);

		ResultadoImportacionFormVO ret = new ResultadoImportacionFormVO(validacioEdifici.edificiosDisponibles, estadosDisponibles, informe, validacioEdifici.existia);
		//ret.setEdificioExistia(existia);
		//ret.setEdificio(edificioBD);
		//ret.setInforme(informe);
		//ret.setInspeccion(inspeccion);
		ret.setCorrecto(true);

		return ret;
	}

	@Override
	public ResultadoImportacionFormVO importarInformeIte(ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String numeroCadastre, boolean favorable) throws GenericBusinessException {

		ValidacioEdifici validacioEdifici = getValidacioEdifici(user, validarMunicipio, municipioId, numeroCadastre, null);

		InformeFormVO informeraw = new InformeFormVO();

		informeraw.setEdificioId(validacioEdifici.edificiosDisponibles[0].getClave());

		Date now = new Date();
		int estado = 5;

		informeraw.setEstadoInformeId(estado);
		informeraw.setFechaAlta(now);
		informeraw.setFechaInforme(dataFirma);

		setResumenAuditoria(informeraw, user, now);
		InformeFormVO informe = this.informeBO.add(informeraw);

		BlobFormVO archivoPDF = new BlobFormVO();
		BlobFormVO archivoIEE = new BlobFormVO();
		try {
			archivoPDF.setDatos(pdf.getByteData());
		} catch (IOException e) {
			String error = "Error leyendo los datos del archivo PDF";
			log.error(error, e);
			throw new GenericBusinessException(error, e);
		}

		setResumenAuditoria(archivoPDF, user, now);
		archivoPDF = this.blobBO.add(archivoPDF);

		informe.setPdfArxiu(new Long(archivoPDF.getClave()));
		informe.setPdfArxiuMime(pdf.getMimeType());

		// Nous camps
		informe.setTipusIee(TipusIee.T30);
		informe.setEstadoInformeId(favorable ? Constants.ESTADO_INFORME_FAVORABLE : Constants.ESTADO_INFORME_DESFAVORABLE);

//		this.generarInformeIte(inspeccionImportada, informe.getClave());

		EstadoInformeFormVO[] estadosDisponibles = new EstadoInformeFormVO[] {
				this.estadoInformeBO.load(Constants.ESTADO_INFORME_FAVORABLE),
				this.estadoInformeBO.load(Constants.ESTADO_INFORME_DESFAVORABLE) };
		informe.setEstadoInformeId(favorable ? Constants.ESTADO_INFORME_FAVORABLE : Constants.ESTADO_INFORME_DESFAVORABLE);

		informe = this.informeBO.update(informe.getClave(), informe);

		ResultadoImportacionFormVO ret = new ResultadoImportacionFormVO(validacioEdifici.edificiosDisponibles, estadosDisponibles, informe, validacioEdifici.existia);
		ret.setCorrecto(true);

		return ret;
	}

//	private InspeccionFormVO generarInformeIte(InformeFormVO informe) throws GenericBusinessException {
//		InspeccionFormVO instance = new InspeccionFormVO();
//
//
//
//		return instance;
//	}

	@Override
	public ResultadoImportacionFormVO importarInformeSubsana(ArchivoDTO pdf, String user, boolean validarMunicipio, Integer municipioId, Date dataFirma, String numeroCadastre) throws GenericBusinessException {

		ValidacioEdifici validacioEdifici = getValidacioEdifici(user, validarMunicipio, municipioId, numeroCadastre, null);

		InformeFormVO informeraw = new InformeFormVO();

		EdificioFormVO edifici = validacioEdifici.edificiosDisponibles[0];

		InformeListadoVO ultimInforme = edifici.getUltimInforme();
		if (ultimInforme == null) {
			String error = "No se puede realitzar una subsanación, debido a que no existe un informe desfavorable previo.";
			log.error(error);
			throw new GenericBusinessException(error);
		}

		TipusIee tipusIee = edifici.getTipusIeeUltimInforme();
		informeraw.setEdificioId(edifici.getClave());

		Date now = new Date();
		int estado = Constants.ESTADO_INFORME_EN_CURSO;

		informeraw.setEstadoInformeId(estado);
		informeraw.setFechaAlta(now);
		informeraw.setFechaInforme(dataFirma);

		setResumenAuditoria(informeraw, user, now);
		InformeFormVO informe = this.informeBO.add(informeraw);

		BlobFormVO archivoPDF = new BlobFormVO();
		try {
			archivoPDF.setDatos(pdf.getByteData());
		} catch (IOException e) {
			String error = "Error leyendo los datos del archivo PDF";
			log.error(error, e);
			throw new GenericBusinessException(error, e);
		}

		setResumenAuditoria(archivoPDF, user, now);
		archivoPDF = this.blobBO.add(archivoPDF);

		informe.setPdfArxiu(new Long(archivoPDF.getClave()));
		informe.setPdfArxiuMime(pdf.getMimeType());

		// Nous camps
		informe.setTipusIee(tipusIee);
		informe.setSubsana(true);

//		this.generarInformeSubsanacio(ultimInforme, informe.getClave());

		EstadoInformeFormVO[] estadosDisponibles = new EstadoInformeFormVO[] {
				this.estadoInformeBO.load(Constants.ESTADO_INFORME_FAVORABLE),
				this.estadoInformeBO.load(Constants.ESTADO_INFORME_DESFAVORABLE) };
		informe.setEstadoInformeId(Constants.ESTADO_INFORME_FAVORABLE);

		informe = this.informeBO.update(informe.getClave(), informe);

		ResultadoImportacionFormVO ret = new ResultadoImportacionFormVO(validacioEdifici.edificiosDisponibles, estadosDisponibles, informe, validacioEdifici.existia);
		ret.setCorrecto(true);

		return ret;
	}

//	private InspeccionFormVO generarInformeSubsanacio(InformeListadoVO ultimInforme, InformeFormVO informe) throws GenericBusinessException {
//		InspeccionFormVO instance = new InspeccionFormVO();
//		ultimInforme.getInspeccionId();
//		InspeccionFormVO ultimaInspeccio = inspeccionBO.load(ultimInforme.getInspeccionId());
//
//		InspeccionFormVO inspeccioSubsanacio = new InspeccionFormVO();
////		inspeccioSubsanacio.setDeficiencias(new HashSet<DeficienciaListadoVO>());
////		inspeccioSubsanacio.setValores(null);
////		inspeccioSubsanacio.setFechasVisitas(null);
////		inspeccioSubsanacio.setAcusticaMejorasAcusticas(null);
////		inspeccioSubsanacio.setValoracionesParciales(null);
////		inspeccioSubsanacio.setDocumentacionOtros(null);
////		inspeccioSubsanacio.setHistoricos(null);
//
//		return instance;
//
//		InspeccionFormVO instance = new InspeccionFormVO();
//		String user = "Importador";
//		Date now = new Date();
//
//		this.setDatosEdificio(source, instance);
//		this.setDatosTitular(source, instance);
//		this.setDatosRepresentante(source, instance);
//		this.setDatosTecnico(source, instance);
//
//		instance.setInformeId(claveInforme);
//		setResumenAuditoria(instance, user, now);
//		//instance.setId(claveInforme);
//		instance = this.inspeccionBO.add(instance);
//	}

//	private InspeccionFormVO clonaInspeccio(InspeccionFormVO original) {
//		if (original == null) {
//			return null;
//		}
//
//		InspeccionFormVO clone = new InspeccionFormVO();
//
//		clone.setDeficiencias(cloneSet(original.getDeficiencias()));
//		clone.setValores(cloneSet(original.getValores()));
//		clone.setFechasVisitas(cloneSet(original.getFechasVisitas()));
//		clone.setAcusticaMejorasAcusticas(cloneSet(original.getAcusticaMejorasAcusticas()));
//		clone.setValoracionesParciales(cloneSet(original.getValoracionesParciales()));
//		clone.setDocumentacionOtros(cloneSet(original.getDocumentacionOtros()));
//		clone.setHistoricos(cloneSet(original.getHistoricos()));
//
//
//		return clone;
//	}
//
//	private <T> Set<T> cloneSet(Set<T> originalSet) {
//		if (originalSet == null) {
//			return null;
//		}
//		Set<T> clonedSet = new HashSet<T>();
//		for (T item : originalSet) {
//			if (item instanceof Cloneable) {
//				try {
//					// Si les classes implementen un mètode clone, utilitza-ho per fer un clon profund.
//					clonedSet.add((T) item.getClass().getMethod("clone").invoke(item));
//				} catch (Exception e) {
//					e.printStackTrace();
//					// Pot gestionar errors en la clonació si cal.
//				}
//			}
//		}
//		return clonedSet;
//	}

	private ValidacioEdifici getValidacioEdifici(String user, boolean validarMunicipio, Integer municipioId, String referenciaCatastral, InspeccionType inspeccionImportada) throws GenericBusinessException {
		ConsultaDnp consulta;

		try {
			consulta = datosCatastroBO.getDatosByRef(referenciaCatastral);
		} catch (GenericBusinessException e2) {
			String error = "Error obteniendo datos de SOAP: " + e2.getMessage();
			log.error(error, e2);
			throw new GenericBusinessException(error, e2);
		} catch (CatastroSoapException e1) {
			String error = "Error obteniendo datos de SOAP: " + e1.getMsg();
			log.error(error, e1);
			throw new GenericBusinessException(error, e1);
		}

		EdificioSoapVO edificioSoap = datosCatastroBO.bico2Edificio(consulta.getBico());
		try {
			edificioSoap = datosCatastroBO.updateCoords(edificioSoap);
		} catch (GenericBusinessException e) {
			String error = "Error obteniendo datos de localizacion del SOAP";
			log.error(error, e);
			throw new GenericBusinessException(error, e);
		}

		BigInteger codigoCatastroMunicipio = null;
		String codigoVia = null;

		if (consulta.getBico() != null && consulta.getBico().getBi() != null && consulta.getBico().getBi().getDt() != null) {
			Dtdnp dt = consulta.getBico().getBi().getDt();
			if (dt.getCmc() != null) {
				codigoCatastroMunicipio = consulta.getBico().getBi().getDt().getCmc();
			} else {
				String error = "Error intentando recuperar el codigo catastral del municipio del informe";
				log.error(error);
				throw new GenericBusinessException(error);
			}
			/*
			 * if (dt.getLocs() != null && dt.getLocs().getLous() != null &&
			 * dt.getLocs().getLous().getLourb() != null &&
			 * dt.getLocs().getLous().getLourb().getDir() != null &&
			 * dt.getLocs().getLous().getLourb().getDir().getCv() != null) {
			 * codigoVia = dt.getLocs().getLous().getLourb().getDir().getCv(); }
			 * else { String error =
			 * "Error intentando recuperar el codigo de la via del edifico del informe"
			 * ; log.error(error); throw new GenericBusinessException(error); }
			 */
			try {
				Locs localizacion = dt.getLocs();
				if (localizacion.getLous() != null) {
					codigoVia = localizacion.getLous().getLourb().getDir().getCv();
				} else if (localizacion.getLors() != null) {
					codigoVia = localizacion.getLors().getLourb().getDir().getCv();
				} else {
					throw new GenericBusinessException("Impossible recuperar datos de localizacion del edificio");
				}
			} catch (NullPointerException e) {
				String error = "Impossible recuperar datos de localizacion del edificio";
				log.error(error, e);
				throw new GenericBusinessException(error, e);
			}

		} else {
			String error = "Error intentando recuperar los datos de localizacion del informe";
			log.error(error);
			throw new GenericBusinessException(error);
		}

		ViaFormVO via = null;
		MunicipioFormVO municipio = null;
		boolean enBaleares = false;
		boolean canImport = false;

		if (codigoCatastroMunicipio != null) {
			municipio = municipioBO.findByCodigoCatastro(Integer.parseInt(String.valueOf(codigoCatastroMunicipio)));
		}

		if (municipio != null) {
			via = viaBO.findByCodigoCatastro(Integer.parseInt(codigoVia), municipio.getClave());
			if (via != null) {
				if (via.getMunicipioId() != municipio.getClave()) {
					throw new GenericBusinessException("Error de inconsistencia: Se ha seleccionado una via de un municipio incorrecto");
				}
				enBaleares = true;
				if (validarMunicipio == false || (validarMunicipio == true && municipioId != null && via.getMunicipioId() == municipioId)) {
					canImport = true;
				}
			}
		}

		if (!enBaleares) {
			throw new GenericBusinessException("El edificio no se encuentra en un municipio de baleares. ");
		}
		if (!canImport) {
			throw new GenericBusinessException("No dispones de permisos para realizar una importacion en el municipio que tiene configurado.");
		}

		Collection<FilterConfig> edificioFilters = new ArrayList<FilterConfig>();
		edificioFilters.add(new FilterConfig(FilterConfig.TYPE_STRING, "referenciaCatastral", CriteriaUtils.COMPARISON_EQUAL, edificioSoap.getCodigoCatastroCorto()));
		ResultadoBusqueda<EdificioFormVO> edificiosBDD = edificioBO.getListadoCompleto(edificioFilters, null);
		//EdificioFormVO edificioBD = edificioBO.findByCodigoCatastro(edificioSoap.getCodigoCatastroCorto());
		//TODO: Recuperar la lista de dificios, si no hay, crear edificio, si hay, mostrarsela al usuario para que puede seleccionar el que quiera (label: codCat + [numeroextra])
		boolean existia = true;
		EdificioFormVO[] edificiosDisponibles;

		if (edificiosBDD.getTotalNumRecords() < 1) {
			//no hay edificio, creamos uno nuevo
			existia = false;
			EdificioFormVO edificioRaw = this.generateEdificio(edificioSoap, user, via.getClave());
			if (inspeccionImportada != null && inspeccionImportada.getInspeccionIdentificacionedificioDirecciones() != null && inspeccionImportada.getInspeccionIdentificacionedificioDirecciones().getDireccion() != null) {
				edificioRaw.setNumeroCatastro(String.valueOf(inspeccionImportada.getInspeccionIdentificacionedificioDirecciones().getDireccion().getNumero()));
			} else {
				String error = "Error al recuperar el numero (del catastro) del edificio";
				log.error(error);
				throw new GenericBusinessException(error);
			}

			EdificioFormVO edificioBD = edificioBO.add(edificioRaw);
			edificiosDisponibles = new EdificioFormVO[] { edificioBD };
		} else {
			edificiosDisponibles = edificiosBDD.getResultados().toArray(new EdificioFormVO[0]);
		}
		if (edificiosDisponibles.length > 1) {
			ordena(edificiosDisponibles);
		}
		ValidacioEdifici result = new ValidacioEdifici(existia, edificiosDisponibles);
		return result;
	}

	private void ordena(EdificioFormVO[] edificis) {
		Arrays.sort(edificis, new Comparator<EdificioFormVO>() {
			@Override
			public int compare(EdificioFormVO o1, EdificioFormVO o2) {
				return o2.getClave() - o1.getClave();
			}
		});
	}

	private Date getDataInformeValoracioFinal(InspeccionType inspeccionImportada) {
			final String FORMAT = "dd/MM/yyyy";

			if (inspeccionImportada != null &&
					inspeccionImportada.getConservacionValoracionesfinales() != null &&
					inspeccionImportada.getConservacionValoracionesfinales().getFechaEmisionInformeValoracion() != null) {

				String fechaEmision = inspeccionImportada.getConservacionValoracionesfinales().getFechaEmisionInformeValoracion();
				SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);

				try {
					return sdf.parse(fechaEmision);
				} catch (ParseException e) {
					// Log error or handle exception
					e.printStackTrace();
				}
			}

			// Retorna la data actual si el valor és nul o si hi ha una excepció
			return new Date();
	}

	private EstadoInformeFormVO[] getEstadosDisponibles(InspeccionType inspeccionImportada) throws GenericBusinessException {
		EstadoInformeFormVO[] ret = null;
		//El estado por defecto es 5 "En curso". Mas adelante, desde el asistente se podra modificar el estado
		Integer estado = null;
		if (inspeccionImportada.getConservacionValoracionesfinales() != null && inspeccionImportada.getConservacionValoracionesfinales().getConservacionValoracionesTipoId() > 0 && inspeccionImportada.getConservacionValoracionesfinales().getConservacionValoracionesTipoId() <= 3) {
			estado = inspeccionImportada.getConservacionValoracionesfinales().getConservacionValoracionesTipoId();
		}

		EstadoInformeFormVO defecto = this.estadoInformeBO.load(3);
		if (estado != null) {
			ret = new EstadoInformeFormVO[] { defecto, this.estadoInformeBO.load(estado) };
		} else {
			ret = new EstadoInformeFormVO[] { defecto };
		}

		return ret;
	}

	private EdificioFormVO generateEdificio(EdificioSoapVO edificioSoap, String user, Integer viaId) {
		EdificioFormVO toReturn = new EdificioFormVO();
		Date now = new Date();
		toReturn.setAntiguedad(edificioSoap.getAntiguedad());
		toReturn.setCentroX(edificioSoap.getCentroX());
		toReturn.setCentroY(edificioSoap.getCentroY());
		toReturn.setNumeroCatastro(edificioSoap.getNumeroCatastro());
		toReturn.setViaId(viaId);
		toReturn.setReferenciaCatastral(edificioSoap.getCodigoCatastroCorto());

		toReturn.setCreatorUser(user);
		toReturn.setModUser(user);
		toReturn.setDateCreation(now);
		toReturn.setLastModified(now);
		return toReturn;
	}

	private void comprobarArchivos(ArchivoDTO iee, ArchivoDTO pdf) {
		// TODO Auto-generated method stub

	}

	private static String removeEmptyNodes(String input) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {

		DocumentBuilder builder;
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(input)));

		removeNodes(document);

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StreamResult result = new StreamResult(new StringWriter());
		transformer.transform(new DOMSource(document), result);
		return result.getWriter().toString();
	}

	private static boolean removeNodes(Node node) {
		//System.out.println(node.getNodeName());
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (removeNodes(list.item(i))) {
				//Si se ha eliminado el node, la lista se actualiza dinámicamente
				i--;
			}
		}
		boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE && node.getChildNodes().getLength() == 0;
		boolean emptyText = node.getNodeType() == Node.TEXT_NODE && node.getNodeValue().trim().isEmpty();
		if (emptyElement || emptyText) {
			//System.out.println("REMOVING");
			node.getParentNode().removeChild(node);
			return true;
		} else {
			return false;
		}
	}

	private InspeccionType extractInspeccionfromIee(InputStream zip) throws GenericBusinessException {
		String xmlraw = null;
		boolean archiveFound = false;
		Exception ex = null;
		String error = "El archivo enviado no es un archivo .iee correcto.";

		//TODO: En caso de errores de parseo, hay que dar por pantalla los máximos detalles del error.
		try {
			ZipArchiveInputStream zis = new ZipArchiveInputStream(new BufferedInputStream(zip));
			ArchiveEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				if ("iee.xml".equals(entry.getName())) {
					xmlraw = At4Utilities.inputStreamToString(zis);
					archiveFound = true;
				}
			}
			zis.close();
		} catch (Exception e) {
			error = "Excepcion no controlada al descomponer archivo .iee";
			log.error(error, e);
			throw new GenericBusinessException(error, ex);
		}

		if (!archiveFound) {
			error = "No se han encontrado datos validos en el .iee";
			log.error(error);
			throw new GenericBusinessException(error, ex);
		}

		InspeccionType xmlparsed = new InspeccionType();

		try {
			/*
			 * En el xml vienen muchos datos numéricos vacíos. No es un problema
			 * para jaxb 2.2.7, pero si para la versión que viene con jboss5
			 * (2.1.12)
			 */
			xmlraw = removeEmptyNodes(xmlraw);
			JAXBContext context = JAXBContext.newInstance(InspeccionType.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			unmarshaller.setEventHandler(new ImportadorEventHandler());
			StringReader xmlReader = new StringReader(xmlraw);

			xmlparsed = (InspeccionType) unmarshaller.unmarshal(xmlReader);

		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException("Error en el tratado de los datos de iee: " + e.getMessage(), e);

		} catch (ParserConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (SAXException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e.getException());
		} catch (TransformerException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);

		}
		return xmlparsed;
	}

	/**
	 * Este metodo pretende pasar los edificios de un tipo de soap a un tipo
	 * nuestro VO. Para ello se ha cogido el transformer de InspeccionBean y se
	 * ha adaptado
	 * 
	 * @param source
	 * @param edificioBD
	 * @return
	 * @throws GenericBusinessException
	 */
	private InspeccionFormVO generarInforme(InspeccionType source, int claveInforme) throws GenericBusinessException {
		InspeccionFormVO instance = new InspeccionFormVO();
		String user = "Importador";
		Date now = new Date();
		String[] exclusiones = new String[] { "conservacion", "acusticas", "acusticaDatosGenerales", "acusticaRuidosInterioresHorizontales", "acusticaMejorasAcusticas", "acusticaRuidosExteriores", "eficienciasEnergeticas", "accesibilidadAjustesRazonables", "cimentaciones", "estructura", "acusticaRuidoInstalaciones", "accesibilidadValoracionFinales", "cerramientosCubiertas", "instalaciones", "acusticaComprobaciones", "acusticaRuidosInterioresVerticales", "acusticaValoracionFinal", "acusticaRuidosInterioresUniones", "accesibilidadPublicos", "informe", "historicos", "valores", "deficiencias", "documentacionOtros", "valoracionesParciales", "fechasVisitas" };

		BeanUtils.copyProperties(source, instance, exclusiones);

		this.setDatosEdificio(source, instance);
		this.setDatosTitular(source, instance);
		this.setDatosRepresentante(source, instance);
		this.setDatosTecnico(source, instance);

		instance.setInformeId(claveInforme);
		setResumenAuditoria(instance, user, now);
		//instance.setId(claveInforme);
		instance = this.inspeccionBO.add(instance);

		Set<ValorListadoVO> valores = new HashSet<ValorListadoVO>();

		if (source.getConservacionDescripciones() != null) {
			List<DescripcionType> descripciones = source.getConservacionDescripciones().getDescripcion();
			if (descripciones != null) {
				for (DescripcionType descripcion : descripciones) {
					DeficienciaFormVO deficiencia = this.deficiencia2Form(descripcion);
					deficiencia.setInspeccionId(instance.getId());
					setResumenAuditoria(deficiencia, user, now);
					DeficienciaFormVO devicienciaBD = deficienciaBO.add(deficiencia);
					instance.getDeficiencias().add(devicienciaBD);
				}
			}
		}

		if (source.getConservacionDocumentacionOtros() != null) {
			DocumentacionOtroType documentacion = source.getConservacionDocumentacionOtros().getDocumentacionOtro();

			DocumentacionOtroFormVO docs = new DocumentacionOtroFormVO();
			docs.setTexto(documentacion.getTexto());
			docs.setInspeccionId(instance.getId());
			setResumenAuditoria(docs, user, now);

			DocumentacionOtroFormVO docsbd = documentosBO.add(docs);

			instance.getDocumentacionOtros().add(docsbd);

		}

		if (source.getConservacionValoraciones() != null) {
			List<ValoracionParcialType> valoraciones = source.getConservacionValoraciones().getValoracionParcial();
			if (valoraciones != null) {
				for (ValoracionParcialType valraw : valoraciones) {
					ValoracionParcialFormVO valoracion = this.valoracion2Form(valraw);
					valoracion.setInspeccionId(instance.getId());
					setResumenAuditoria(valoracion, user, now);
					ValoracionParcialFormVO valoracionBD = valoracionParcialBO.add(valoracion);
					instance.getValoracionesParciales().add(valoracionBD);
				}
			}
			//documentaciones.getDocumentacionOtro()
		}

		if (source.getAcusticaMejorasacusticas() != null) {

			List<AcusticaMedidasmejorasType> acusticamejoras = source.getAcusticaMejorasacusticas().getAcusticaMedidasmejoras();
			if (acusticamejoras != null) {
				for (AcusticaMedidasmejorasType mejoraraw : acusticamejoras) {
					AcusticaMejorasAcusticasFormVO mejora = acusticaMejoras2Form(mejoraraw);
					mejora.setInspeccionId(claveInforme);

					AcusticaMejorasAcusticasId mejoraId = new AcusticaMejorasAcusticasId();
					mejoraId.setClaveInforme(claveInforme);
					mejoraId.setMejorasOrden(mejoraraw.getOrden());
					mejora.setId(mejoraId);
					setResumenAuditoria(mejora, user, now);
					mejora = acusticaMejorasAcusticasBO.add(mejora);

				}
			}

		}

		if (source.getConservacionDatosgeneralesHistoricos() != null) {
			HistoricoType historicoraw = source.getConservacionDatosgeneralesHistoricos().getHistorico();
			if (historicoraw != null) {
				HistoricoFormVO historico = this.historico2Form(historicoraw);
				historico.setInspeccionId(instance.getId());
				setResumenAuditoria(historico, user, now);
				HistoricoFormVO historicoBD = historicoBO.add(historico);
				instance.getHistoricos().add(historicoBD);

			}

		}

		if (source.getConservacionDatosgeneralesFechavisitas() != null) {
			List<String> fechaVisitas = source.getConservacionDatosgeneralesFechavisitas().getFechaVisita();
			if (fechaVisitas != null) {
				for (String fechaS : fechaVisitas) {
					FechaVisitaFormVO fecha = new FechaVisitaFormVO();
					fecha.setFecha(fechaS);
					fecha.setInspeccionId(instance.getId());
					setResumenAuditoria(fecha, user, now);
					FechaVisitaFormVO fechabd = this.fechaVisitaBO.add(fecha);
					instance.getFechasVisitas().add(fechabd);
				}
			}
		}

		if (source.getAccesibilidadPublicos() != null) {
			AccesibilidadPublicosType accpubraw = source.getAccesibilidadPublicos();
			AccesibilidadPublicosFormVO accpub = accesibilidadPublicos2Form(accpubraw);
			accpub.setClaveInforme(claveInforme);
			accpub.setInspeccionId(claveInforme);
			setResumenAuditoria(accpub, user, now);
			AccesibilidadPublicosFormVO accpubbd = this.accesibilidadPublicosBO.add(accpub);
			instance.setAccesibilidadPublicosId(accpubbd.getClaveInforme());
			instance.setAccesibilidadPublicosLabel(FormData2Java.toString(accpubbd.getClaveInforme()));
		}

		if (source.getAcusticaRuidointerioruniones() != null) {
			AcusticaRuidointeriorunionesType ruidoInteriorRaw = source.getAcusticaRuidointerioruniones();
			AcusticaRuidosInterioresUnionesFormVO accpub = acustiRuiInteriorUni2Form(ruidoInteriorRaw);
			accpub.setClaveInforme(claveInforme);
			accpub.setInspeccionId(claveInforme);
			setResumenAuditoria(accpub, user, now);
			AcusticaRuidosInterioresUnionesFormVO accpubbd = this.acusticaRuidosInterioresUnionesBO.add(accpub);
			instance.setAcusticaRuidosInterioresUnionesId(accpubbd.getClaveInforme());
			instance.setAcusticaRuidosInterioresUnionesLabel(FormData2Java.toString(accpubbd.getClaveInforme()));
		}

		if (source.getAcusticaValoracionfinal() != null) {
			AcusticaValoracionfinalType acuvalfinraw = source.getAcusticaValoracionfinal();
			AcusticaValoracionFinalFormVO acuvalfin = acuValFin2Form(acuvalfinraw);
			acuvalfin.setClaveInforme(claveInforme);
			acuvalfin.setInspeccionId(claveInforme);
			setResumenAuditoria(acuvalfin, user, now);
			setResumenAuditoria(acuvalfin, user, now);
			AcusticaValoracionFinalFormVO acuvalfinbd = acusticaValoracionFinalBO.add(acuvalfin);
			instance.setAcusticaValoracionFinalId(acuvalfinbd.getClaveInforme());
			instance.setAcusticaValoracionFinalLabel(FormData2Java.toString(acuvalfinbd.getClaveInforme()));
		}
		if (source.getAcusticaRuidointeriorverticales() != null) {

			AcusticaRuidointeriorverticalesType ruidointeriorvertraw = source.getAcusticaRuidointeriorverticales();
			AcusticaRuidosInterioresVerticalesFormVO acuruidintvert = acuRuiIntVert2Form(ruidointeriorvertraw, valores);
			acuruidintvert.setClaveInforme(claveInforme);
			acuruidintvert.setInspeccionId(claveInforme);
			setResumenAuditoria(acuruidintvert, user, now);
			setResumenAuditoria(acuruidintvert, user, now);
			AcusticaRuidosInterioresVerticalesFormVO acuruidintvertbd = this.acusticaRuidosInterioresVerticalesBO.add(acuruidintvert);
			instance.setAcusticaRuidosInterioresVerticalesId(acuruidintvertbd.getClaveInforme());
			instance.setAcusticaRuidosInterioresVerticalesLabel(FormData2Java.toString(acuruidintvertbd.getClaveInforme()));
		}
		if (source.getAcusticaComprobaciones() != null) {
			AcusticaComprobacionesType acusticacomprobacionesraw = source.getAcusticaComprobaciones();
			AcusticaComprobacionesFormVO acusticacomprobaciones = acuComprob2Form(acusticacomprobacionesraw);
			acusticacomprobaciones.setClaveInforme(claveInforme);
			acusticacomprobaciones.setInspeccionId(claveInforme);
			setResumenAuditoria(acusticacomprobaciones, user, now);
			setResumenAuditoria(acusticacomprobaciones, user, now);
			AcusticaComprobacionesFormVO acusticacomprobacionesbd = acusticaComprobacionesBO.add(acusticacomprobaciones);
			instance.setAcusticaComprobacionesId(acusticacomprobacionesbd.getClaveInforme());
			instance.setAcusticaComprobacionesLabel(FormData2Java.toString(acusticacomprobacionesbd.getClaveInforme()));
		}
		if (source.getInstalaciones() != null) {
			InstalacionesType instalacionesraw = source.getInstalaciones();
			InstalacionesFormVO instalaciones = instalaciones2Form(instalacionesraw, valores);
			instalaciones.setClaveInforme(claveInforme);
			instalaciones.setInspeccionId(claveInforme);
			setResumenAuditoria(instalaciones, user, now);
			InstalacionesFormVO instalacionesbd = instalacionesBO.add(instalaciones);
			instance.setInstalacionesId(instalacionesbd.getClaveInforme());
			instance.setInstalacionesLabel(FormData2Java.toString(instalacionesbd.getClaveInforme()));
		}
		if (source.getCerramientoscubiertas() != null) {
			CerramientoscubiertasType cerramientoscubiertasraw = source.getCerramientoscubiertas();
			CerramientosCubiertasFormVO cerramientoscubiertas = cerramientosCubiertas2Form(cerramientoscubiertasraw, valores);
			cerramientoscubiertas.setClaveInforme(claveInforme);
			cerramientoscubiertas.setInspeccionId(claveInforme);
			setResumenAuditoria(cerramientoscubiertas, user, now);
			CerramientosCubiertasFormVO cerramientoscubiertasbd = this.cerramientosCubiertasBO.add(cerramientoscubiertas);
			instance.setCerramientosCubiertasId(cerramientoscubiertasbd.getClaveInforme());
			instance.setCerramientosCubiertasLabel(FormData2Java.toString(cerramientoscubiertasbd.getClaveInforme()));
		}
		if (source.getAccesibilidadValoracionfinales() != null) {
			AccesibilidadValoracionfinalesType accvalfinraw = source.getAccesibilidadValoracionfinales();
			AccesibilidadValoracionFinalesFormVO accvalfin = accValFin2Form(accvalfinraw);
			accvalfin.setClaveInforme(claveInforme);
			accvalfin.setInspeccionId(claveInforme);
			accvalfin.setInspeccionId(claveInforme);
			setResumenAuditoria(accvalfin, user, now);
			AccesibilidadValoracionFinalesFormVO accvalfinbd = accesibilidadValoracionFinalesBO.add(accvalfin);
			instance.setAccesibilidadValoracionFinalesId(accvalfinbd.getClaveInforme());
			instance.setAccesibilidadValoracionFinalesLabel(FormData2Java.toString(accvalfinbd.getClaveInforme()));
		}
		if (source.getAcusticaRuidoinstalaciones() != null) {
			AcusticaRuidoinstalacionesType acuruidinstraw = source.getAcusticaRuidoinstalaciones();
			AcusticaRuidoInstalacionesFormVO acuruidinst = accRuidInst2Form(acuruidinstraw);
			acuruidinst.setClaveInforme(claveInforme);
			acuruidinst.setInspeccionId(claveInforme);
			setResumenAuditoria(acuruidinst, user, now);
			AcusticaRuidoInstalacionesFormVO acuruidinstbd = acusticaRuidoInstalacionesBO.add(acuruidinst);
			instance.setAcusticaRuidoInstalacionesId(acuruidinstbd.getClaveInforme());
			instance.setAcusticaRuidoInstalacionesLabel(FormData2Java.toString(acuruidinstbd.getClaveInforme()));
		}
		if (source.getEstructuras() != null) {
			EstructurasType estructurasraw = source.getEstructuras();
			EstructuraFormVO estructuras = estructuras2Form(estructurasraw, valores);
			estructuras.setClaveInforme(claveInforme);
			estructuras.setInspeccionId(claveInforme);
			setResumenAuditoria(estructuras, user, now);
			EstructuraFormVO estructurasbd = estructuraBO.add(estructuras);
			instance.setEstructuraId(estructurasbd.getClaveInforme());
			instance.setEstructuraLabel(FormData2Java.toString(estructurasbd.getClaveInforme()));
		}
		if (source.getCimentaciones() != null) {
			CimentacionesType cimentacionesraw = source.getCimentaciones();
			CimentacionesFormVO cimentaciones = cimentaciones2Form(cimentacionesraw, valores);
			cimentaciones.setClaveInforme(claveInforme);
			cimentaciones.setInspeccionId(claveInforme);
			setResumenAuditoria(cimentaciones, user, now);
			CimentacionesFormVO cimentacionesbd = cimentacionesBO.add(cimentaciones);
			instance.setCimentacionesId(cimentacionesbd.getClaveInforme());
			instance.setCimentacionesLabel(cimentacionesbd.getCimentacionprofundaTexto());
		}
		if (source.getAccesibilidadAjustesrazonables() != null) {
			AccesibilidadAjustesrazonablesType accajustrazraw = source.getAccesibilidadAjustesrazonables();
			AccesibilidadAjustesRazonablesFormVO accajustraz = accAjust2Form(accajustrazraw);
			accajustraz.setClaveInforme(claveInforme);
			accajustraz.setInspeccionId(claveInforme);
			setResumenAuditoria(accajustraz, user, now);
			AccesibilidadAjustesRazonablesFormVO accajustrazbd = accesibilidadAjustesRazonablesBO.add(accajustraz);
			instance.setAccesibilidadAjustesRazonablesId(accajustrazbd.getClaveInforme());
			instance.setAccesibilidadAjustesRazonablesLabel(FormData2Java.toString(accajustrazbd.getClaveInforme()));
		}
		if (source.getEficienciasenergeticas() != null) {
			EficienciasenergeticasType eficiencianergeticaraw = source.getEficienciasenergeticas();
			EficienciasEnergeticasFormVO eficiencianergetica = eficiencia2Form(eficiencianergeticaraw);
			eficiencianergetica.setClaveInforme(claveInforme);
			eficiencianergetica.setInspeccionId(claveInforme);
			setResumenAuditoria(eficiencianergetica, user, now);
			EficienciasEnergeticasFormVO eficiencianergeticabd = eficienciaEnergeticaBO.add(eficiencianergetica);
			instance.setEficienciasEnergeticasId(eficiencianergeticabd.getClaveInforme());
			instance.setEficienciasEnergeticasLabel(FormData2Java.toString(eficiencianergeticabd.getClaveInforme()));
		}
		if (source.getAcusticaRuidosexteriores() != null) {
			AcusticaRuidosexterioresType acusticaruidosextraw = source.getAcusticaRuidosexteriores();
			AcusticaRuidosExterioresFormVO acusticaruidosext = acusticaRuidoExt2Form(acusticaruidosextraw, valores);
			acusticaruidosext.setClaveInforme(claveInforme);
			acusticaruidosext.setInspeccionId(claveInforme);
			setResumenAuditoria(acusticaruidosext, user, now);
			AcusticaRuidosExterioresFormVO acusticaruidosextbd = acusticaRuidosExterioresBO.add(acusticaruidosext);
			instance.setAcusticaRuidosExterioresId(acusticaruidosextbd.getClaveInforme());
			instance.setAcusticaRuidosExterioresLabel(FormData2Java.toString(acusticaruidosextbd.getClaveInforme()));
		}
		if (source.getAcusticaRuidointeriorhorizontales() != null) {
			AcusticaRuidointeriorhorizontalesType acruidinthorraw = source.getAcusticaRuidointeriorhorizontales();
			AcusticaRuidosInterioresHorizontalesFormVO acruidinthor = acusticaRuidosInterioresHoriz2Form(acruidinthorraw, valores);
			acruidinthor.setClaveInforme(claveInforme);
			acruidinthor.setInspeccionId(claveInforme);
			setResumenAuditoria(acruidinthor, user, now);
			AcusticaRuidosInterioresHorizontalesFormVO acruidinthorbd = acusticaRuidosInterioresHorizontalesBO.add(acruidinthor);
			instance.setAcusticaRuidosInterioresHorizontalesId(acruidinthorbd.getClaveInforme());
			instance.setAcusticaRuidosInterioresHorizontalesLabel(FormData2Java.toString(acruidinthorbd.getClaveInforme()));
		}
		if (source.getAcusticaDatosgenerales() != null) {
			AcusticaDatosgeneralesType acusticageneralesraw = source.getAcusticaDatosgenerales();
			AcusticaDatosGeneralesFormVO acusticagenerales = acusticaGenerales2Form(acusticageneralesraw);
			acusticagenerales.setClaveInforme(claveInforme);
			acusticagenerales.setInspeccionId(claveInforme);
			setResumenAuditoria(acusticagenerales, user, now);
			AcusticaDatosGeneralesFormVO acusticageneralesbd = acusticaDatosGeneralesBO.add(acusticagenerales);
			instance.setAcusticaDatosGeneralesId(acusticageneralesbd.getClaveInforme());
			instance.setAcusticaDatosGeneralesLabel(FormData2Java.toString(acusticageneralesbd.getClaveInforme()));
		}
		if (source.getAcusticas() != null) {
			AcusticasType acusticasraw = source.getAcusticas();
			AcusticasFormVO acusticas = acusticas2Form(acusticasraw);
			acusticas.setClaveInforme(claveInforme);
			acusticas.setInspeccionId(claveInforme);
			setResumenAuditoria(acusticas, user, now);
			AcusticasFormVO acusticasbd = acusticasBO.add(acusticas);
			instance.setAcusticasId(acusticasbd.getClaveInforme());
			instance.setAcusticasLabel(FormData2Java.toString(acusticasbd.getClaveInforme()));
		}
		if (source.getConservacionDatosgenerales() != null) {
			ConservacionDatosgeneralesType conservaciongeneralesraw = source.getConservacionDatosgenerales();
			ConservacionFormVO conservacion = conservacionGeneral2Form(conservaciongeneralesraw);
			conservacion.setClaveInforme(claveInforme);
			conservacion.setInspeccionId(claveInforme);
			setResumenAuditoria(conservacion, user, now);
			ConservacionFormVO conservacionbd = conservacionBO.add(conservacion);
			instance.setConservacionId(conservacionbd.getClaveInforme());
			instance.setConservacionLabel(FormData2Java.toString(conservacionbd.getClaveInforme()));
		}

		instance.setValores(valores);
		InspeccionFormVO ret = this.inspeccionBO.update(instance.getPrimaryKey(), instance);
		return ret;
	}

	private HistoricoFormVO historico2Form(HistoricoType src) {
		HistoricoFormVO ret = new HistoricoFormVO();

		ret.setFechaInspeccion(src.getFechaInspeccion());
		ret.setGradoEjecucionEfectividadObras(src.getGradoEjecucionEfectividadObras());
		ret.setObservaciones(src.getObservaciones());
		ret.setResultado(src.getResultado());
		ret.setTecnico(src.getTecnico());

		return ret;
	}

	private ValoracionParcialFormVO valoracion2Form(ValoracionParcialType src) {
		ValoracionParcialFormVO ret = new ValoracionParcialFormVO();

		ret.setConservacionSistemasconstructivosTipoId(src.getConservacionSistemasconstructivosTipoId());
		ret.setConservacionValoracionesTipoId(src.getConservacionValoracionesTipoId());
		ret.setPlazoFinObras(src.getPlazoFinObras());
		ret.setPlazoInicioObras(src.getPlazoInicioObras());

		return ret;
	}

	private DeficienciaFormVO deficiencia2Form(DescripcionType src) {
		DeficienciaFormVO ret = new DeficienciaFormVO();
		//TODO: Revisar: Creo que estos dos campos deben ir girados, no se xq
		ret.setConservacionSistemasconstructivosTipoId(src.getDeficienciaTipoId().get(0));
		ret.setDeficienciaTipoId(src.getConservacionSistemasconstructivosTipoId());
		//ret.setDeficienciaTipoLabel(deficienciaTipoLabel)
		String descripcion = src.getDescripcionDeficiencia();
		//TODO: Maxlength muy bajo
		//if(descripcion.length() > 255){
		//	descripcion = descripcion.substring(0, 254);
		//}
		ret.setDescripcionDeficiencia(descripcion);
		ret.setEsGrave(src.getEsGrave());
		ret.setLocalizacionDeficiencia(src.getLocalizacionDeficiencia());
		ret.setNombreDeficiencia(src.getNombreDeficiencia());
		ret.setObservaciones(src.getObservaciones());
		ret.setPruebasEnsayosRealizados(src.getPruebasEnsayosRealizados());

		//TODO: Maxlength muy bajo
		if (ret.getDescripcionDeficiencia() != null && ret.getDescripcionDeficiencia().length() > 254) {
			ret.setDescripcionDeficiencia(ret.getDescripcionDeficiencia().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getLocalizacionDeficiencia() != null && ret.getLocalizacionDeficiencia().length() > 254) {
			ret.setLocalizacionDeficiencia(ret.getLocalizacionDeficiencia().substring(0, 254));
		}

		return ret;
	}

	private void setDatosTecnico(InspeccionType source, InspeccionFormVO instance) {
		InspeccionTecnicosType tecnico = source.getInspeccionTecnicos();

		instance.setTecnicoNif(tecnico.getNif());
		instance.setTecnicoTecnico(tecnico.getTecnico());
		instance.setTecnicoTitulacion(tecnico.getTitulacion());
	}

	private void setDatosRepresentante(InspeccionType source, InspeccionFormVO instance) {

		InspeccionRepresentantesType representante = source.getInspeccionRepresentantes();

		instance.setRepresentanteCodigoPostal(representante.getCodigoPostal());
		instance.setRepresentanteCondicion(representante.getCondicion());
		instance.setRepresentanteDireccion(representante.getDireccion());
		instance.setRepresentanteEmail(representante.getEmail());
		instance.setRepresentanteNif(representante.getNif());
		instance.setRepresentanteNif(representante.getNombre());
		instance.setRepresentantePoblacion(representante.getPoblacion());
		instance.setRepresentanteProvincia(representante.getProvincia());
		instance.setRepresentanteTelefonoFijo(representante.getTelefonoFijo());
		instance.setRepresentanteTelefonoMovil(representante.getTelefonoMovil());

	}

	private void setDatosTitular(InspeccionType source, InspeccionFormVO instance) {

		InspeccionPropiedadesType propiedad = source.getInspeccionPropiedades();

		instance.setPropiedadNif(propiedad.getNif());
		instance.setPropiedadTitular(propiedad.getTitular());
	}

	private void setDatosEdificio(InspeccionType source, InspeccionFormVO instance) {

		InspeccionIdentificacionedificiosType propiedadEdificio = source.getInspeccionIdentificacionedificios();
		InspeccionDatosedificiosType superficieEdificio = source.getInspeccionDatosedificios();

		BeanUtils.copyProperties(source.getInspeccionDatosedificios(), instance);

		instance.setEdificioCodigoPostal(propiedadEdificio.getCodigoPostal());
		instance.setEdificioNumeroManual(FormData2Java.toString(source.getInspeccionIdentificacionedificioDirecciones().getDireccion().getNumero()));
		instance.setEdificioPisoLetra(propiedadEdificio.getPisoLetra());
		instance.setEdificioPoblacion(propiedadEdificio.getPoblacion());
		instance.setEdificioProvincia(propiedadEdificio.getProvincia());
		instance.setEdificioProvinciaId(propiedadEdificio.getProvinciaId());
		instance.setEdificioTipoViaManual(source.getInspeccionIdentificacionedificioDirecciones().getDireccion().getTipoVia());
		instance.setEdificioViaManual(source.getInspeccionIdentificacionedificioDirecciones().getDireccion().getVia());
		instance.setEdificioInspeccionIdentificacionedificioComunesTipoId(propiedadEdificio.getInspeccionIdentificacionedificioComunesTipoId());
		instance.setEdificioInspeccionIdentificacionedificioObjetoTipoId(propiedadEdificio.getInspeccionIdentificacionedificioObjetoTipoId());
		instance.setEdificioInspeccionPropiedadRegimenTipoId(propiedadEdificio.getInspeccionPropiedadRegimenTipoId());

		//superficies
		instance.setTotalAscensores(superficieEdificio.getTotalAscensores());
		instance.setTotalEscaleras(superficieEdificio.getTotalEscaleras());
		instance.setTotalViviendasConAccesoVariosNucleos(superficieEdificio.getTotalViviendasConAccesoVariosNucleos());
		instance.setTotalViviendasSinAccesoAscensor(superficieEdificio.getTotalViviendasSinAccesoAscensor());
		instance.setSuperficieConstruida(superficieEdificio.getSuperficieConstruida());
		instance.setSuperficieMediaAparcamientos(superficieEdificio.getSuperficieMediaAparcamientos());
		instance.setSuperficieMediaLocales(superficieEdificio.getSuperficieMediaLocales());
		instance.setSuperficieMediaTrasteros(superficieEdificio.getSuperficieMediaTrasteros());
		instance.setSuperficieMediaViviendas(superficieEdificio.getSuperficieMediaViviendas());
		instance.setSuperficieParcela(superficieEdificio.getSuperficieParcela());

	}

	private ConservacionFormVO conservacionGeneral2Form(ConservacionDatosgeneralesType source) {
		ConservacionFormVO ret = new ConservacionFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getPruebasRealizadas() != null && ret.getPruebasRealizadas().length() > 254) {
			ret.setPruebasRealizadas(ret.getPruebasRealizadas().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getMediosInspeccion() != null && ret.getMediosInspeccion().length() > 254) {
			ret.setMediosInspeccion(ret.getMediosInspeccion().substring(0, 254));
		}

		return ret;
	}

	private AcusticasFormVO acusticas2Form(AcusticasType source) {
		AcusticasFormVO ret = new AcusticasFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaDatosGeneralesFormVO acusticaGenerales2Form(AcusticaDatosgeneralesType source) {
		AcusticaDatosGeneralesFormVO ret = new AcusticaDatosGeneralesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaRuidosInterioresHorizontalesFormVO acusticaRuidosInterioresHoriz2Form(AcusticaRuidointeriorhorizontalesType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		AcusticaRuidosInterioresHorizontalesFormVO ret = new AcusticaRuidosInterioresHorizontalesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		AcusticaRuidointeriorhorizontalesGarajeEstructuraprincipalType garajeEstructuraPrincipal = source.getAcusticaRuidointeriorhorizontalesGarajeEstructuraprincipal();
		if (garajeEstructuraPrincipal != null) {
			for (Integer id : garajeEstructuraPrincipal.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_garaje_estructuraprincipal", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesGarajeForjadoentrevigadoType garajeForjadoEntrevigado = source.getAcusticaRuidointeriorhorizontalesGarajeForjadoentrevigado();
		if (garajeForjadoEntrevigado != null) {
			for (Integer id : garajeForjadoEntrevigado.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_garaje_forjadoentrevigado", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesGarajeForjadosecundarioType garajeForjadoSecundario = source.getAcusticaRuidointeriorhorizontalesGarajeForjadosecundario();
		if (garajeForjadoSecundario != null) {
			for (Integer id : garajeForjadoSecundario.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_garaje_forjadosecundario", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesGarajeOtrosType garajeOtros = source.getAcusticaRuidointeriorhorizontalesGarajeOtros();
		if (garajeOtros != null) {
			for (Integer id : garajeOtros.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_garaje_otros", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicasType sueloFlotanteCaracteristicas = source.getAcusticaRuidointeriorhorizontalesSueloflotanteCaracteristicas();
		if (sueloFlotanteCaracteristicas != null) {
			for (Integer id : sueloFlotanteCaracteristicas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_sueloflotante_caracteristica", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesSueloflotanteTiposType sueloFlotanteTipos = source.getAcusticaRuidointeriorhorizontalesSueloflotanteTipos();
		if (sueloFlotanteTipos != null) {
			for (Integer id : sueloFlotanteTipos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_sueloflotante_tipos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTechoCaracteristicasType techoCaracteristicas = source.getAcusticaRuidointeriorhorizontalesTechoCaracteristicas();
		if (techoCaracteristicas != null) {
			for (Integer id : techoCaracteristicas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_techo_caracteristicas", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTechoTiposType techoTipos = source.getAcusticaRuidointeriorhorizontalesTechoTipos();
		if (techoTipos != null) {
			for (Integer id : techoTipos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_techo_tipos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTipoEstructuraprincipalType tipoEstructuraPrincipal = source.getAcusticaRuidointeriorhorizontalesTipoEstructuraprincipal();
		if (tipoEstructuraPrincipal != null) {
			for (Integer id : tipoEstructuraPrincipal.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_tipo_estructuraprincipal", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTipoForjadoentrevigadoType tipoForjadoEntrevigado = source.getAcusticaRuidointeriorhorizontalesTipoForjadoentrevigado();
		if (tipoForjadoEntrevigado != null) {
			for (Integer id : tipoForjadoEntrevigado.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_tipo_forjadoentrevigado", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTipoForjadosecundarioType tipoForjadoSecundario = source.getAcusticaRuidointeriorhorizontalesTipoForjadosecundario();
		if (tipoForjadoSecundario != null) {
			for (Integer id : tipoForjadoSecundario.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_tipo_forjadosecundario", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorhorizontalesTipoOtrosType tipoOtros = source.getAcusticaRuidointeriorhorizontalesTipoOtros();
		if (tipoOtros != null) {
			for (Integer id : tipoOtros.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorhorizontales_tipo_otros", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getDeficienciasObservaciones() != null && ret.getDeficienciasObservaciones().length() > 254) {
			ret.setDeficienciasObservaciones(ret.getDeficienciasObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getPlantagarajeCantoForjado() != null && ret.getPlantagarajeCantoForjado().length() > 254) {
			ret.setPlantagarajeCantoForjado(ret.getPlantagarajeCantoForjado().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getPlantatipoCantoForjado() != null && ret.getPlantatipoCantoForjado().length() > 254) {
			ret.setPlantatipoCantoForjado(ret.getPlantatipoCantoForjado().substring(0, 254));
		}

		return ret;
	}

	private AcusticaMejorasAcusticasFormVO acusticaMejoras2Form(AcusticaMedidasmejorasType mejoraraw) {
		AcusticaMejorasAcusticasFormVO ret = new AcusticaMejorasAcusticasFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(mejoraraw, ret);

		if (mejoraraw.getAcusticaPotencialmedidas() != null) {
			ret.setProteccionRuidoExteriorTipoId(mejoraraw.getAcusticaPotencialmedidas().getProteccionRuidoExteriorTipoId());
			ret.setProteccionRuidoInstalacionesTipoId(mejoraraw.getAcusticaPotencialmedidas().getProteccionRuidoInstalacionesTipoId());
			ret.setProteccionRuidoInteriorImpactosTipoId(mejoraraw.getAcusticaPotencialmedidas().getProteccionRuidoInteriorImpactosTipoId());
			ret.setProteccionRuidoInteriorAereoTipoId(mejoraraw.getAcusticaPotencialmedidas().getProteccionRuidoInteriorAereoTipoId());
		}

		ret.setMejorasAnalisisTecnico(mejoraraw.getAnalisisTecnico());
		ret.setMejorasValoracionEconomica(mejoraraw.getDescripcion());
		ret.setMejorasObservaciones(mejoraraw.getObservaciones());
		ret.setPotencialObservaciones(mejoraraw.getObservaciones());
		if (mejoraraw.getAcusticaIncidenciamedidas() != null) {
			ret.setIncidenciaTexto(mejoraraw.getAcusticaIncidenciamedidas().getTexto());
			ret.setIncidenciaObservaciones(mejoraraw.getAcusticaIncidenciamedidas().getObservaciones());
		}

		//TODO: Maxlength muy bajo
		if (ret.getMejorasAnalisisTecnico() != null && ret.getMejorasAnalisisTecnico().length() > 254) {
			ret.setMejorasAnalisisTecnico(ret.getMejorasAnalisisTecnico().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getMejorasObservaciones() != null && ret.getMejorasObservaciones().length() > 254) {
			ret.setMejorasObservaciones(ret.getMejorasObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getMejorasValoracionEconomica() != null && ret.getMejorasValoracionEconomica().length() > 254) {
			ret.setMejorasValoracionEconomica(ret.getMejorasValoracionEconomica().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getPotencialObservaciones() != null && ret.getPotencialObservaciones().length() > 254) {
			ret.setPotencialObservaciones(ret.getPotencialObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getIncidenciaObservaciones() != null && ret.getIncidenciaObservaciones().length() > 254) {
			ret.setIncidenciaObservaciones(ret.getIncidenciaObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getIncidenciaTexto() != null && ret.getIncidenciaTexto().length() > 254) {
			ret.setIncidenciaTexto(ret.getIncidenciaTexto().substring(0, 254));
		}

		return ret;
	}

	private AcusticaRuidosExterioresFormVO acusticaRuidoExt2Form(AcusticaRuidosexterioresType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		AcusticaRuidosExterioresFormVO ret = new AcusticaRuidosExterioresFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		AcusticaRuidoexteriorVentanaAperturasType va = source.getAcusticaRuidoexteriorVentanaAperturas();
		if (va != null) {
			for (Integer id : va.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidoexterior_ventana_aperturas", id);
				valores.add(valor);
			}
		}
		AcusticaRuidoexteriorVentanaVidriosType vvi = source.getAcusticaRuidoexteriorVentanaVidrios();
		if (vvi != null) {
			for (Integer id : vvi.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidoexterior_ventana_vidrios", id);
				valores.add(valor);
			}
		}
		AcusticaRuidoexteriorVentanasType v = source.getAcusticaRuidoexteriorVentanas();
		if (v != null) {
			for (Integer id : v.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidoexterior_ventanas", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getDeficienciasObservaciones() != null && ret.getDeficienciasObservaciones().length() > 254) {
			ret.setDeficienciasObservaciones(ret.getDeficienciasObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getVentanasLocalizacionTiposVentanas() != null && ret.getVentanasLocalizacionTiposVentanas().length() > 254) {
			ret.setVentanasLocalizacionTiposVentanas(ret.getVentanasLocalizacionTiposVentanas().substring(0, 254));
		}

		return ret;
	}

	private EficienciasEnergeticasFormVO eficiencia2Form(EficienciasenergeticasType source) {
		EficienciasEnergeticasFormVO ret = new EficienciasEnergeticasFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AccesibilidadAjustesRazonablesFormVO accAjust2Form(AccesibilidadAjustesrazonablesType source) {
		AccesibilidadAjustesRazonablesFormVO ret = new AccesibilidadAjustesRazonablesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getAjustesrazonablesDescripcion() != null && ret.getAjustesrazonablesDescripcion().length() > 254) {
			ret.setAjustesrazonablesDescripcion(ret.getAjustesrazonablesDescripcion().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getObservacionesConsideracionesinmueble() != null && ret.getObservacionesConsideracionesinmueble().length() > 254) {
			ret.setObservacionesConsideracionesinmueble(ret.getObservacionesConsideracionesinmueble().substring(0, 254));
		}
		return ret;
	}

	private CimentacionesFormVO cimentaciones2Form(CimentacionesType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		CimentacionesFormVO ret = new CimentacionesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		CimentacionesCimentacionesprofundasType cimentacionesProfundas = source.getCimentacionesCimentacionesprofundas();
		if (cimentacionesProfundas != null) {
			for (Integer id : cimentacionesProfundas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cimentaciones_cimentacionesprofundas", id);
				valores.add(valor);
			}
		}
		CimentacionesCimentacionessuperficialesType cimentacionesSuperficiales = source.getCimentacionesCimentacionessuperficiales();
		if (cimentacionesSuperficiales != null) {
			for (Integer id : cimentacionesSuperficiales.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cimentaciones_cimentacionessuperficiales", id);
				valores.add(valor);
			}
		}
		CimentacionesSistemascontencionesType sistemasContenciones = source.getCimentacionesSistemascontenciones();
		if (sistemasContenciones != null) {
			for (Integer id : sistemasContenciones.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cimentaciones_sistemascontenciones", id);
				valores.add(valor);
			}
		}

		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private EstructuraFormVO estructuras2Form(EstructurasType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		EstructuraFormVO ret = new EstructuraFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		EstructurasCubiertacerchasporticosType cubiertaCerchasPorticos = source.getEstructurasCubiertacerchasporticos();
		if (cubiertaCerchasPorticos != null) {
			for (Integer id : cubiertaCerchasPorticos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_cubiertacerchasporticos", id);
				valores.add(valor);
			}
		}
		EstructurasCubiertaforjadoshorizontalesType cubiertaForjadosHorizontales = source.getEstructurasCubiertaforjadoshorizontales();
		if (cubiertaForjadosHorizontales != null) {
			for (Integer id : cubiertaForjadosHorizontales.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_cubiertaforjadoshorizontales", id);
				valores.add(valor);
			}
		}
		EstructurasCubiertaforjadosinclinadosType cubiertaForjadosInclinados = source.getEstructurasCubiertaforjadosinclinados();
		if (cubiertaForjadosInclinados != null) {
			for (Integer id : cubiertaForjadosInclinados.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_cubiertaforjadosinclinados", id);
				valores.add(valor);
			}
		}
		EstructurasCubiertaotrosType cubiertaOtros = source.getEstructurasCubiertaotros();
		if (cubiertaOtros != null) {
			for (Integer id : cubiertaOtros.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_cubiertaotros", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalplantatipoestructurasprincipalesType horizontalPlantaTipoEstructurasPrincipales = source.getEstructurasHorizontalplantatipoestructurasprincipales();
		if (horizontalPlantaTipoEstructurasPrincipales != null) {
			for (Integer id : horizontalPlantaTipoEstructurasPrincipales.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalplantatipoestructurasprincipales", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalplantatipoforjadosentrevigadosType horizontalPlantaTipoForjadoEntrevigados = source.getEstructurasHorizontalplantatipoforjadosentrevigados();
		if (horizontalPlantaTipoForjadoEntrevigados != null) {
			for (Integer id : horizontalPlantaTipoForjadoEntrevigados.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalplantatipoforjadosentrevigados", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalplantatipoforjadossecundariosType horizontalPlantaipoForjadosSecundarios = source.getEstructurasHorizontalplantatipoforjadossecundarios();
		if (horizontalPlantaipoForjadosSecundarios != null) {
			for (Integer id : horizontalPlantaipoForjadosSecundarios.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalplantatipoforjadossecundarios", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalplantatipootrosType horizontalPlantaTipoOtros = source.getEstructurasHorizontalplantatipootros();
		if (horizontalPlantaTipoOtros != null) {
			for (Integer id : horizontalPlantaTipoOtros.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalplantatipootros", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalsueloforjadosType horizontalSueloForjado = source.getEstructurasHorizontalsueloforjados();
		if (horizontalSueloForjado != null) {
			for (Integer id : horizontalSueloForjado.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalsueloforjados", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalsueloforjadossanitariosType horizontalSueloForjadosSanitarios = source.getEstructurasHorizontalsueloforjadossanitarios();
		if (horizontalSueloForjadosSanitarios != null) {
			for (Integer id : horizontalSueloForjadosSanitarios.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalsueloforjadossanitarios", id);
				valores.add(valor);
			}
		}
		EstructurasHorizontalsuelootrosType horizontalSueloOtros = source.getEstructurasHorizontalsuelootros();
		if (horizontalSueloOtros != null) {
			for (Integer id : horizontalSueloOtros.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_horizontalsuelootros", id);
				valores.add(valor);
			}
		}
		EstructurasVerticalmuroscargasType verticalMurosCarga = source.getEstructurasVerticalmuroscargas();
		if (verticalMurosCarga != null) {
			for (Integer id : verticalMurosCarga.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_verticalmuroscargas", id);
				valores.add(valor);
			}
		}
		EstructurasVerticalpilaresType verticalPilares = source.getEstructurasVerticalpilares();
		if (verticalPilares != null) {
			for (Integer id : verticalPilares.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("estructuras_verticalpilares", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaRuidoInstalacionesFormVO accRuidInst2Form(AcusticaRuidoinstalacionesType source) {
		AcusticaRuidoInstalacionesFormVO ret = new AcusticaRuidoInstalacionesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AccesibilidadValoracionFinalesFormVO accValFin2Form(AccesibilidadValoracionfinalesType source) {
		AccesibilidadValoracionFinalesFormVO ret = new AccesibilidadValoracionFinalesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		return ret;
	}

	private CerramientosCubiertasFormVO cerramientosCubiertas2Form(CerramientoscubiertasType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		CerramientosCubiertasFormVO ret = new CerramientosCubiertasFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		CerramientoscubiertasCarpinteriavidriocarpinteriaspredominantesType carpinteriaVidruiCarpinteriasPredominantes = source.getCerramientoscubiertasCarpinteriavidriocarpinteriaspredominantes();
		if (carpinteriaVidruiCarpinteriasPredominantes != null) {
			for (Integer id : carpinteriaVidruiCarpinteriasPredominantes.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_carpinteriavidriocarpinteriaspredominante", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasCarpinteriavidriovidriospredominantesType carpinteriaVidriosPredominantes = source.getCerramientoscubiertasCarpinteriavidriovidriospredominantes();
		if (carpinteriaVidriosPredominantes != null) {
			for (Integer id : carpinteriaVidriosPredominantes.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_carpinteriavidriovidriospredominantes_aed", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasCubiertainclinadacoberturasType cubiertaInclinadaCoberturas = source.getCerramientoscubiertasCubiertainclinadacoberturas();
		if (cubiertaInclinadaCoberturas != null) {
			for (Integer id : cubiertaInclinadaCoberturas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_cubiertainclinadacoberturas", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasCubiertaplanatransitablesType cubiertaPlantaTransitables = source.getCerramientoscubiertasCubiertaplanatransitables();
		if (cubiertaPlantaTransitables != null) {
			for (Integer id : cubiertaPlantaTransitables.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_cubiertaplanatransitables", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasFachadaprincipalacabadosrevestidosType fachadaPrincipalAcabadosRevestidos = source.getCerramientoscubiertasFachadaprincipalacabadosrevestidos();
		if (fachadaPrincipalAcabadosRevestidos != null) {
			for (Integer id : fachadaPrincipalAcabadosRevestidos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_fachadaprincipalacabadosrevestidos", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasFachadaprincipalacabadosvistosType fachadaPrincipalAcabadosVistos = source.getCerramientoscubiertasFachadaprincipalacabadosvistos();
		if (fachadaPrincipalAcabadosVistos != null) {
			for (Integer id : fachadaPrincipalAcabadosVistos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_fachadaprincipalacabadosvistos", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasOtrasfachadasacabadosrevestidosType otrasFachadasAcabadosRevestidos = source.getCerramientoscubiertasOtrasfachadasacabadosrevestidos();
		if (otrasFachadasAcabadosRevestidos != null) {
			for (Integer id : otrasFachadasAcabadosRevestidos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_otrasfachadasacabadosrevestidos", id);
				valores.add(valor);
			}
		}
		CerramientoscubiertasOtrasfachadasacabadosvistosType otrasFachadasAcabadosVistos = source.getCerramientoscubiertasOtrasfachadasacabadosvistos();
		if (otrasFachadasAcabadosVistos != null) {
			for (Integer id : otrasFachadasAcabadosVistos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("cerramientoscubiertas_otrasfachadasacabadosvistos", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private InstalacionesFormVO instalaciones2Form(InstalacionesType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		InstalacionesFormVO ret = new InstalacionesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		InstalacionesAbastecimientocontadoresType abastecimientoContadores = source.getInstalacionesAbastecimientocontadores();
		if (abastecimientoContadores != null) {
			for (Integer id : abastecimientoContadores.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_abastecimientocontadores", id);
				valores.add(valor);
			}
		}
		InstalacionesAbastecimientosType abastecimientos = source.getInstalacionesAbastecimientos();
		if (abastecimientos != null) {
			for (Integer id : abastecimientos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_abastecimientos", id);
				valores.add(valor);
			}
		}
		InstalacionesAcscentralcombustiblesType acsCentralCombustibles = source.getInstalacionesAcscentralcombustibles();
		if (acsCentralCombustibles != null) {
			for (Integer id : acsCentralCombustibles.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_acscentralcombustibles", id);
				valores.add(valor);
			}
		}
		InstalacionesCalefaccioncentralcombustiblesType calefaccionCentralCombustibles = source.getInstalacionesCalefaccioncentralcombustibles();
		if (calefaccionCentralCombustibles != null) {
			for (Integer id : calefaccionCentralCombustibles.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_calefaccioncentralcombustibles", id);
				valores.add(valor);
			}
		}
		InstalacionesCalefaccioncentralesType calefaccionCentrales = source.getInstalacionesCalefaccioncentrales();
		if (calefaccionCentrales != null) {
			for (Integer id : calefaccionCentrales.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_calefaccioncentrales", id);
				valores.add(valor);
			}
		}
		InstalacionesComunicacionesictsType comunicacionesIcts = source.getInstalacionesComunicacionesicts();
		if (calefaccionCentrales != null) {
			for (Integer id : comunicacionesIcts.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_comunicacionesicts", id);
				valores.add(valor);
			}
		}
		InstalacionesContraincendiosType contraIncendios = source.getInstalacionesContraincendios();
		if (contraIncendios != null) {
			for (Integer id : contraIncendios.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_contraincendios", id);
				valores.add(valor);
			}
		}
		InstalacionesContrarayosType contraRayo = source.getInstalacionesContrarayos();
		if (contraRayo != null) {
			for (Integer id : contraRayo.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_contrarayos", id);
				valores.add(valor);
			}
		}
		InstalacionesElectricacontadoresType electricaContadores = source.getInstalacionesElectricacontadores();
		if (electricaContadores != null) {
			for (Integer id : electricaContadores.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_electricacontadores", id);
				valores.add(valor);
			}
		}
		InstalacionesElectricasType electricas = source.getInstalacionesElectricas();
		if (electricas != null) {
			for (Integer id : electricas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_electricas", id);
				valores.add(valor);
			}
		}
		InstalacionesGascanalizadocombustiblesType gasCanalizadoCombustibles = source.getInstalacionesGascanalizadocombustibles();
		if (gasCanalizadoCombustibles != null) {
			for (Integer id : gasCanalizadoCombustibles.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_gascanalizadocombustibles", id);
				valores.add(valor);
			}
		}
		InstalacionesGascanalizadocontadoresType gasCanalizadoContadores = source.getInstalacionesGascanalizadocontadores();
		if (gasCanalizadoContadores != null) {
			for (Integer id : gasCanalizadoContadores.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_gascanalizadocontadores", id);
				valores.add(valor);
			}
		}
		InstalacionesRefrigeracioncolectivotorresType refrigerecionColectivoTorres = source.getInstalacionesRefrigeracioncolectivotorres();
		if (refrigerecionColectivoTorres != null) {
			for (Integer id : refrigerecionColectivoTorres.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_refrigeracioncolectivotorres", id);
				valores.add(valor);
			}
		}
		InstalacionesSaneamientobajantesType saneamientoBajantes = source.getInstalacionesSaneamientobajantes();
		if (saneamientoBajantes != null) {
			for (Integer id : saneamientoBajantes.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_saneamientobajantes", id);
				valores.add(valor);
			}
		}
		InstalacionesSaneamientocolectoresType saneamientoColectores = source.getInstalacionesSaneamientocolectores();
		if (saneamientoColectores != null) {
			for (Integer id : saneamientoColectores.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_saneamientocolectores", id);
				valores.add(valor);
			}
		}
		InstalacionesSaneamientosType saneamientos = source.getInstalacionesSaneamientos();
		if (saneamientos != null) {
			for (Integer id : saneamientos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_saneamientos", id);
				valores.add(valor);
			}
		}
		InstalacionesVentilacionaparcamientosType ventilacionAparcamientos = source.getInstalacionesVentilacionaparcamientos();
		if (ventilacionAparcamientos != null) {
			for (Integer id : ventilacionAparcamientos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_ventilacionaparcamientos", id);
				valores.add(valor);
			}
		}
		InstalacionesVentilacioncuartoshumedosType ventilacionCuartosHumedos = source.getInstalacionesVentilacioncuartoshumedos();
		if (ventilacionCuartosHumedos != null) {
			for (Integer id : ventilacionCuartosHumedos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("instalaciones_ventilacioncuartoshumedos", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaComprobacionesFormVO acuComprob2Form(AcusticaComprobacionesType source) {
		AcusticaComprobacionesFormVO ret = new AcusticaComprobacionesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaRuidosInterioresVerticalesFormVO acuRuiIntVert2Form(AcusticaRuidointeriorverticalesType source, Set<ValorListadoVO> valores) throws GenericBusinessException {
		AcusticaRuidosInterioresVerticalesFormVO ret = new AcusticaRuidosInterioresVerticalesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		AcusticaRuidointeriorverticalesSeparacionElementosType separacionElementos = source.getAcusticaRuidointeriorverticalesSeparacionElementos();
		if (separacionElementos != null) {
			for (Integer id : separacionElementos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_separacion_elementos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorverticalesSeparacionGruposType separacionGrupos = source.getAcusticaRuidointeriorverticalesSeparacionGrupos();
		if (separacionGrupos != null) {
			for (Integer id : separacionGrupos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_separacion_grupos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorverticalesSeparacionSubgruposType separacionSubgrupos = source.getAcusticaRuidointeriorverticalesSeparacionSubgrupos();
		if (separacionSubgrupos != null) {
			for (Integer id : separacionSubgrupos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_separacion_subgrupos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorverticalesSeparacionTiposType separacionTipos = source.getAcusticaRuidointeriorverticalesSeparacionTipos();
		if (separacionTipos != null) {
			for (Integer id : separacionTipos.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_separacion_tipos", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorverticalesTabiquesType tabiques = source.getAcusticaRuidointeriorverticalesTabiques();
		if (tabiques != null) {
			for (Integer id : tabiques.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_tabiques", id);
				valores.add(valor);
			}
		}
		AcusticaRuidointeriorverticalesTabiquesCaracteristicasType tabiquesCaracteristicas = source.getAcusticaRuidointeriorverticalesTabiquesCaracteristicas();
		if (tabiquesCaracteristicas != null) {
			for (Integer id : tabiquesCaracteristicas.getId()) {
				ValorFormVO valor = this.valorBO.findByCarId("acustica_ruidointeriorverticales_tabiques_caracteristicas", id);
				valores.add(valor);
			}
		}
		BeanUtils.copyProperties(source, ret);

		ret.setRuiiIntVertSepTipoTex(source.getAcusticaRuidointeriorverticalesSeparacionTipoTexto());
		ret.setRuiIntVertTabTipoTex(source.getAcusticaRuidointeriorverticalesTabiquesTipoTexto());

		//TODO: Maxlength muy bajo
		if (ret.getDeficienciasObservaciones() != null && ret.getDeficienciasObservaciones().length() > 254) {
			ret.setDeficienciasObservaciones(ret.getDeficienciasObservaciones().substring(0, 254));
		}
		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}
		return ret;
	}

	private AcusticaValoracionFinalFormVO acuValFin2Form(AcusticaValoracionfinalType source) {
		AcusticaValoracionFinalFormVO ret = new AcusticaValoracionFinalFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}

		return ret;
	}

	private AcusticaRuidosInterioresUnionesFormVO acustiRuiInteriorUni2Form(AcusticaRuidointeriorunionesType source) {
		AcusticaRuidosInterioresUnionesFormVO ret = new AcusticaRuidosInterioresUnionesFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//TODO: Maxlength muy bajo
		if (ret.getObservaciones() != null && ret.getObservaciones().length() > 254) {
			ret.setObservaciones(ret.getObservaciones().substring(0, 254));
		}
		return ret;
	}

	private AccesibilidadPublicosFormVO accesibilidadPublicos2Form(AccesibilidadPublicosType source) {
		AccesibilidadPublicosFormVO ret = new AccesibilidadPublicosFormVO();
		//Copiamos las propiedades simples, excluyendo relaciones
		BeanUtils.copyProperties(source, ret);

		//datos generales
		ret.setAlojamientosaccesibles1porcada50(source.getAlojamientosaccesibles1Porcada50());
		ret.setAlojamientosaccesiblesMinimo1(source.getAlojamientosaccesiblesMinimo1());
		ret.setAlojamientosaccesiblesMinimo2(source.getAlojamientosaccesiblesMinimo2());
		ret.setAlojamientosaccesiblesMinimo4(source.getAlojamientosaccesiblesMinimo4());
		ret.setAlojamientosaccesiblesMinimo6(source.getAlojamientosaccesiblesMinimo6());
		ret.setAlojamientosaccesiblesMinimo8(source.getAlojamientosaccesiblesMinimo8());
		ret.setAlojamientosaccesiblesObservaciones(source.getAlojamientosaccesiblesObservaciones());
		ret.setAparcamientoComercialPorfraccion(source.getAparcamientoComercialPorfraccion());
		ret.setAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion(source.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion());
		ret.setAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion(source.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion());
		ret.setAparcamientoResidencialpublicoPoralojamiento(source.getAparcamientoResidencialpublicoPoralojamiento());
		ret.setAparcamientoSillaruedas(source.getAparcamientoSillaruedas());
		ret.setAparcamientoObservaciones(source.getAparcamientoObservaciones());

		//informacion señalizacion
		ret.setInformacionsenalizacionAscensores(source.getInformacionsenalizacionAscensores());
		ret.setInformacionsenalizacionAscensoresBrailearabigo(source.getInformacionsenalizacionAscensoresBrailearabigo());
		ret.setInformacionsenalizacionAscensoresNumeroplanta(source.getInformacionsenalizacionAscensoresNumeroplanta());
		ret.setInformacionsenalizacionBandasvisualestactiles(source.getInformacionsenalizacionBandasvisualestactiles());
		ret.setInformacionsenalizacionBandasvisualestactilesArranqueescalera(source.getInformacionsenalizacionBandasvisualestactilesArranqueescaleras());
		ret.setInformacionsenalizacionBandasvisualestactilesColorcontrastado(source.getInformacionsenalizacionBandasvisualestactilesColorcontrastado());
		ret.setInformacionsenalizacionBandasvisualestactilesItinerarioaccesi(source.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesib());
		ret.setInformacionsenalizacionBandasvisualestactilesRelieveexterior(source.getInformacionsenalizacionBandasvisualestactilesRelieveexterior());
		ret.setInformacionsenalizacionBandasvisualestactilesRelieveinterior(source.getInformacionsenalizacionBandasvisualestactilesRelieveinterior());
		ret.setInformacionsenalizacionPrivadoSiaAparcamiento(source.getInformacionsenalizacionPrivadoSiaAparcamiento());
		ret.setInformacionsenalizacionPrivadoSiaAscensores(source.getInformacionsenalizacionPrivadoSiaAscensores());
		ret.setInformacionsenalizacionPrivadoSiaEntradas(source.getInformacionsenalizacionPrivadoSiaEntradas());
		ret.setInformacionsenalizacionPrivadoSiaItinerarios(source.getInformacionsenalizacionPrivadoSiaItinerarios());
		ret.setInformacionsenalizacionPrivadoSiaPlazasreservadas(source.getInformacionsenalizacionPrivadoSiaPlazasreservadas());
		ret.setInformacionsenalizacionPublicoSiaAparcamiento(source.getInformacionsenalizacionPrivadoSiaAparcamiento());
		ret.setInformacionsenalizacionPublicoSiaAscensores(source.getInformacionsenalizacionPrivadoSiaAscensores());
		ret.setInformacionsenalizacionPublicoSiaEntradas(source.getInformacionsenalizacionPrivadoSiaEntradas());
		ret.setInformacionsenalizacionPublicoSiaItinerarios(source.getInformacionsenalizacionPrivadoSiaItinerarios());
		ret.setInformacionsenalizacionPublicoSiaPlazasreservadas(source.getInformacionsenalizacionPrivadoSiaPlazasreservadas());
		ret.setInformacionsenalizacionBuclemagnetico(source.getInformacionsenalizacionBuclemagnetico());
		ret.setInformacionsenalizacionBuclemagneticoSenalizado(source.getInformacionsenalizacionBuclemagneticoSenalizado());
		ret.setInformacionsenalizacionServicioshigienicossenalizados(source.getInformacionsenalizacionPublicoSiaServicioshigienicos());
		ret.setInformacionsenalizacionSianorma(source.getInformacionsenalizacionSianorma());
		ret.setInformacionsenalizacionTodosusosObservaciones(source.getInformacionsenalizacionTodosusosObservaciones());
		ret.setInformacionsenalizacionObservaciones(source.getInformacionsenalizacionObservaciones());

		return ret;
	}

	private void setResumenAuditoria(FormVO obj, String user, Date fecha) {
		obj.setModUser(user);
		obj.setLastModified(fecha);
		obj.setDateCreation(fecha);
		obj.setCreatorUser(user);
	}

	@Override
	public ResultadoImportacionListadoVO saveImport(Integer claveInforme, Integer estadoInformeId, String numeroExtra, Integer claveEdificio) throws GenericBusinessException {

		if (claveInforme == null) {
			throw new GenericBusinessException("No se ha especificado clave del informe");
		}

		InformeFormVO informe = this.informeBO.load(claveInforme);
		boolean updateInforme = false;
		EdificioFormVO edificio;
		if (claveEdificio != null && claveEdificio == -1) {
			edificio = this.edificioBO.load(informe.getEdificioId());
			edificio.setClave(0);
			edificio = this.edificioBO.add(edificio);
			informe.setEdificioId(edificio.getClave());
			updateInforme = true;
		} else {
			edificio = this.edificioBO.load(informe.getEdificioId());
		}

		edificio.setNumeroExtra(numeroExtra);

		if (StringUtils.isEmpty(numeroExtra)) {
			edificio.setNumeroExtra(null); //Si es "", queremos que quede a null
		}

		if (estadoInformeId != null) {
			informe.setEstadoInformeId(estadoInformeId);
			updateInforme = true;
		}

		edificio = this.edificioBO.update(edificio.getClave(), edificio);

		if (updateInforme) {
			informe = this.informeBO.update(informe.getClave(), informe);
		}

		EdificioFormVO[] edificioResult = new EdificioFormVO[] { edificio };
		EstadoInformeFormVO[] estadosInforme = new EstadoInformeFormVO[] { this.estadoInformeBO.load(informe.getEstadoInformeId()) };
		ResultadoImportacionListadoVO ret = new ResultadoImportacionListadoVO(edificioResult, estadosInforme, informe, true);
		ret.setCorrecto(true);

		return ret;
	}

	@Override
	public boolean cancelImport(Long informeId, boolean municipioUnico, Integer municipioPermitido) throws GenericBusinessException {
		if (informeId == null || informeId < 1) {
			throw new GenericBusinessException("ID informe especificado inválido");
		}

		InformeFormVO informe = this.informeBO.load(informeId.intValue());
		EdificioFormVO edificio = this.edificioBO.load(informe.getEdificioId());
		Integer edificioId = null;
		if(edificio.getInformes().size()<2){
			edificioId = edificio.getClave();
		}

		boolean canDelete = false;
		if (municipioUnico) {
			if (informe.getMunicipioId() == municipioPermitido) {
				canDelete = true;
			}
		} else {
			canDelete = true;
		}

		if (canDelete) {
			return this.deleteInforme(informeId, edificioId) > 0;
		} else {
			throw new GenericBusinessException("Su usuario no dispone de permisos para cancelar la importación.");
		}
	}

	public int deleteInforme(Long idL, Integer idEdificio) throws GenericBusinessException {
		Integer idI = idL.intValue();
		//Nota creo que las relaciones no 1-1 se borran en casacada

		int result = 0;

		//AED_ACC_AJUSTESRAZONABLES
		if (this.doDelete(this.accesibilidadAjustesRazonablesBO, idI)) {
			result++;
		}
		//AED_ACC_PUBLICOS
		if (this.doDelete(this.accesibilidadPublicosBO, idI)) {
			result++;
		}
		//AED_ACC_VALORACIONFINALES
		if (this.doDelete(this.accesibilidadValoracionFinalesBO, idI)) {
			result++;
		}
		//AED_ACUSTICAS
		if (this.doDelete(this.acusticasBO, idI)) {
			result++;
		}
		//AED_ACU_COMPROBACIONES
		if (this.doDelete(this.acusticaComprobacionesBO, idI)) {
			result++;
		}
		//AED_ACU_DATGEN
		if (this.doDelete(this.acusticaDatosGeneralesBO, idI)) {
			result++;
		}
		//AED_ACU_MEJORASACUSTICAS
		//TODO:
		/*
		 * if(this.doDelete(this.acusticaMejorasAcusticasBO, id)){ result++; }
		 */
		//AED_ACU_RUIDOINSTALACIONES
		if (this.doDelete(this.acusticaRuidoInstalacionesBO, idI)) {
			result++;
		}
		//AED_ACU_RUIDOSEXTERIORES
		if (this.doDelete(this.acusticaRuidosExterioresBO, idI)) {
			result++;
		}
		//AED_ACU_RUIINTHOR
		if (this.doDelete(this.acusticaRuidosInterioresHorizontalesBO, idI)) {
			result++;
		}
		//AED_ACU_RUIINTUNIONES
		if (this.doDelete(this.acusticaRuidosInterioresUnionesBO, idI)) {
			result++;
		}
		//AED_ACU_RUIINTVERT
		if (this.doDelete(this.acusticaRuidosInterioresVerticalesBO, idI)) {
			result++;
		}
		//AED_ACU_VALORACIONFINAL
		if (this.doDelete(this.acusticaValoracionFinalBO, idI)) {
			result++;
		}
		//AED_CERRAMI_CUBIER
		if (this.doDelete(this.cerramientosCubiertasBO, idI)) {
			result++;
		}
		//AED_CIMENTACIONES
		if (this.doDelete(this.cimentacionesBO, idI)) {
			result++;
		}
		//AED_CONSERVACION
		if (this.doDelete(this.conservacionBO, idI)) {
			result++;
		}
		//AED_CONS_FECHA_VISITA
		//TODO:
		/*
		 * if(this.doDelete(this.conservacion, id)){ result++; }
		 */
		//AED_DEFICIENCIA
		//TODO:
		/*
		 * if(this.doDelete(this.deficienciaBO, idL)){ result++; }
		 */
		//AED_DOC_OTRO
		//TODO:
		/*
		 * if(this.doDelete(this.documentosBO, idL)){ result++; }
		 */
		//AED_EFICIENCIASENERGETICAS
		if (this.doDelete(this.eficienciaEnergeticaBO, idI)) {
			result++;
		}
		//AED_ESTRUCTURA
		if (this.doDelete(this.estructuraBO, idI)) {
			result++;
		}
		//AED_HISTORICO
		//TODO:
		/*
		 * if(this.doDelete(this.historicoBO, idL)){ result++; }
		 */
		//AED_INSPECCION
		if (this.doDelete(this.inspeccionBO, idI)) {
			result++;
		}
		//AED_INSTALACIONES
		if (this.doDelete(this.instalacionesBO, idI)) {
			result++;
		}
		//AED_INS_VAL
		//TODO:
		//AED_VALORACION_PARCIAL
		//TODO:

		try {
			if (this.doDelete(this.informeBO, idI)) {
				result++;
			}
		} catch (GenericBusinessException e) {
			throw new GenericBusinessException("Error al eliminar el informe, rolling back", e);
		}
		if(idEdificio != null){
			if(this.doDelete(this.edificioBO, idEdificio)){
				result++;
			}
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	private boolean doDelete(BaseBO bean, Serializable id) throws GenericBusinessException {
		if (id == null) {
			return false;
		}
		FormVO item = bean.load(id);
		if (item == null) {
			return false;
		}
		return bean.delete(id);
	}

	private static class ValidacioEdifici {
		public final boolean existia;
		public final EdificioFormVO[] edificiosDisponibles;

		public ValidacioEdifici(boolean existia, EdificioFormVO[] edificiosDisponibles) {
			this.existia = existia;
			this.edificiosDisponibles = edificiosDisponibles;
		}
	}

}
