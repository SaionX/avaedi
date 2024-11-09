package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.model.ValorId;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.front.service.general.InspeccionBaseService;
import es.caib.avaedi.logic.bo.AccesibilidadAjustesRazonablesBO;
import es.caib.avaedi.logic.bo.AccesibilidadPublicosBO;
import es.caib.avaedi.logic.bo.AccesibilidadValoracionFinalesBO;
import es.caib.avaedi.logic.bo.AcusticaComprobacionesBO;
import es.caib.avaedi.logic.bo.AcusticaDatosGeneralesBO;
import es.caib.avaedi.logic.bo.AcusticaMejorasAcusticasBO;
import es.caib.avaedi.logic.bo.AcusticaRuidoInstalacionesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosExterioresBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresHorizontalesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresUnionesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresVerticalesBO;
import es.caib.avaedi.logic.bo.AcusticaValoracionFinalBO;
import es.caib.avaedi.logic.bo.AcusticasBO;
import es.caib.avaedi.logic.bo.CerramientosCubiertasBO;
import es.caib.avaedi.logic.bo.CimentacionesBO;
import es.caib.avaedi.logic.bo.ConservacionBO;
import es.caib.avaedi.logic.bo.DeficienciaBO;
import es.caib.avaedi.logic.bo.DocumentacionOtroBO;
import es.caib.avaedi.logic.bo.EficienciasEnergeticasBO;
import es.caib.avaedi.logic.bo.EstructuraBO;
import es.caib.avaedi.logic.bo.FechaVisitaBO;
import es.caib.avaedi.logic.bo.HistoricoBO;
import es.caib.avaedi.logic.bo.InformeBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.bo.InstalacionesBO;
import es.caib.avaedi.logic.bo.ValorBO;
import es.caib.avaedi.logic.bo.ValoracionParcialBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.DeficienciaFormVO;
import es.caib.avaedi.logic.vo.DocumentacionOtroFormVO;
import es.caib.avaedi.logic.vo.FechaVisitaFormVO;
import es.caib.avaedi.logic.vo.HistoricoFormVO;
import es.caib.avaedi.logic.vo.InspeccionFormVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;
import es.caib.avaedi.logic.vo.ValorListadoVO;
import es.caib.avaedi.logic.vo.ValoracionParcialFormVO;

/**
 * Servicio para tratar el formulario: Inspeccion
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("inspeccion")
public class InspeccionService extends BaseService<InspeccionBO, InspeccionListadoVO, InspeccionFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(InspeccionService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Inspeccion
	 */
	@Autowired
	@Qualifier("InspeccionBean")
	protected InspeccionBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Inspeccion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected InspeccionBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Informe
	 */
	@Autowired
	@Qualifier("InformeBean")
	private InformeBO informeBO;

	/**
	 * Bean para acceder a los metodos de negocio: Informe
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setInformeBO(InformeBO bean) {
		this.informeBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AccesibilidadPublicos
	 */
	@Autowired
	@Qualifier("AccesibilidadPublicosBean")
	private AccesibilidadPublicosBO accesibilidadPublicosBO;

	/**
	 * Bean para acceder a los metodos de negocio: AccesibilidadPublicos
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAccesibilidadPublicosBO(AccesibilidadPublicosBO bean) {
		this.accesibilidadPublicosBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresUniones
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresUnionesBean")
	private AcusticaRuidosInterioresUnionesBO acusticaRuidosInterioresUnionesBO;

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresUniones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaRuidosInterioresUnionesBO(AcusticaRuidosInterioresUnionesBO bean) {
		this.acusticaRuidosInterioresUnionesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: FechaVisita
	 */
	@Autowired
	@Qualifier("FechaVisitaBean")
	private FechaVisitaBO fechaVisitaBO;

	/**
	 * Bean para acceder a los metodos de negocio: FechaVisita
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setFechaVisitaBO(FechaVisitaBO bean) {
		this.fechaVisitaBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaValoracionFinal
	 */
	@Autowired
	@Qualifier("AcusticaValoracionFinalBean")
	private AcusticaValoracionFinalBO acusticaValoracionFinalBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaValoracionFinal
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaValoracionFinalBO(AcusticaValoracionFinalBO bean) {
		this.acusticaValoracionFinalBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresVerticales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresVerticalesBean")
	private AcusticaRuidosInterioresVerticalesBO acusticaRuidosInterioresVerticalesBO;

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresVerticales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaRuidosInterioresVerticalesBO(AcusticaRuidosInterioresVerticalesBO bean) {
		this.acusticaRuidosInterioresVerticalesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaComprobaciones
	 */
	@Autowired
	@Qualifier("AcusticaComprobacionesBean")
	private AcusticaComprobacionesBO acusticaComprobacionesBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaComprobaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaComprobacionesBO(AcusticaComprobacionesBO bean) {
		this.acusticaComprobacionesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Instalaciones
	 */
	@Autowired
	@Qualifier("InstalacionesBean")
	private InstalacionesBO instalacionesBO;

	/**
	 * Bean para acceder a los metodos de negocio: Instalaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setInstalacionesBO(InstalacionesBO bean) {
		this.instalacionesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: CerramientosCubiertas
	 */
	@Autowired
	@Qualifier("CerramientosCubiertasBean")
	private CerramientosCubiertasBO cerramientosCubiertasBO;

	/**
	 * Bean para acceder a los metodos de negocio: CerramientosCubiertas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setCerramientosCubiertasBO(CerramientosCubiertasBO bean) {
		this.cerramientosCubiertasBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: ValoracionParcial
	 */
	@Autowired
	@Qualifier("ValoracionParcialBean")
	private ValoracionParcialBO valoracionParcialBO;

	/**
	 * Bean para acceder a los metodos de negocio: ValoracionParcial
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setValoracionParcialBO(ValoracionParcialBO bean) {
		this.valoracionParcialBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AccesibilidadValoracionFinales
	 */
	@Autowired
	@Qualifier("AccesibilidadValoracionFinalesBean")
	private AccesibilidadValoracionFinalesBO accesibilidadValoracionFinalesBO;

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AccesibilidadValoracionFinales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAccesibilidadValoracionFinalesBO(AccesibilidadValoracionFinalesBO bean) {
		this.accesibilidadValoracionFinalesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaRuidoInstalaciones
	 */
	@Autowired
	@Qualifier("AcusticaRuidoInstalacionesBean")
	private AcusticaRuidoInstalacionesBO acusticaRuidoInstalacionesBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaRuidoInstalaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaRuidoInstalacionesBO(AcusticaRuidoInstalacionesBO bean) {
		this.acusticaRuidoInstalacionesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Estructura
	 */
	@Autowired
	@Qualifier("EstructuraBean")
	private EstructuraBO estructuraBO;

	/**
	 * Bean para acceder a los metodos de negocio: Estructura
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setEstructuraBO(EstructuraBO bean) {
		this.estructuraBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Cimentaciones
	 */
	@Autowired
	@Qualifier("CimentacionesBean")
	private CimentacionesBO cimentacionesBO;

	/**
	 * Bean para acceder a los metodos de negocio: Cimentaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setCimentacionesBO(CimentacionesBO bean) {
		this.cimentacionesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AccesibilidadAjustesRazonables
	 */
	@Autowired
	@Qualifier("AccesibilidadAjustesRazonablesBean")
	private AccesibilidadAjustesRazonablesBO accesibilidadAjustesRazonablesBO;

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AccesibilidadAjustesRazonables
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAccesibilidadAjustesRazonablesBO(AccesibilidadAjustesRazonablesBO bean) {
		this.accesibilidadAjustesRazonablesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: EficienciasEnergeticas
	 */
	@Autowired
	@Qualifier("EficienciasEnergeticasBean")
	private EficienciasEnergeticasBO eficienciasEnergeticasBO;

	/**
	 * Bean para acceder a los metodos de negocio: EficienciasEnergeticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setEficienciasEnergeticasBO(EficienciasEnergeticasBO bean) {
		this.eficienciasEnergeticasBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: DocumentacionOtro
	 */
	@Autowired
	@Qualifier("DocumentacionOtroBean")
	private DocumentacionOtroBO documentacionOtroBO;

	/**
	 * Bean para acceder a los metodos de negocio: DocumentacionOtro
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setDocumentacionOtroBO(DocumentacionOtroBO bean) {
		this.documentacionOtroBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaRuidosExteriores
	 */
	@Autowired
	@Qualifier("AcusticaRuidosExterioresBean")
	private AcusticaRuidosExterioresBO acusticaRuidosExterioresBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaRuidosExteriores
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaRuidosExterioresBO(AcusticaRuidosExterioresBO bean) {
		this.acusticaRuidosExterioresBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaMejorasAcusticas
	 */
	@Autowired
	@Qualifier("AcusticaMejorasAcusticasBean")
	private AcusticaMejorasAcusticasBO acusticaMejorasAcusticasBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaMejorasAcusticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaMejorasAcusticasBO(AcusticaMejorasAcusticasBO bean) {
		this.acusticaMejorasAcusticasBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresHorizontales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresHorizontalesBean")
	private AcusticaRuidosInterioresHorizontalesBO acusticaRuidosInterioresHorizontalesBO;

	/**
	 * Bean para acceder a los metodos de negocio:
	 * AcusticaRuidosInterioresHorizontales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaRuidosInterioresHorizontalesBO(AcusticaRuidosInterioresHorizontalesBO bean) {
		this.acusticaRuidosInterioresHorizontalesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaDatosGenerales
	 */
	@Autowired
	@Qualifier("AcusticaDatosGeneralesBean")
	private AcusticaDatosGeneralesBO acusticaDatosGeneralesBO;

	/**
	 * Bean para acceder a los metodos de negocio: AcusticaDatosGenerales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticaDatosGeneralesBO(AcusticaDatosGeneralesBO bean) {
		this.acusticaDatosGeneralesBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Acusticas
	 */
	@Autowired
	@Qualifier("AcusticasBean")
	private AcusticasBO acusticasBO;

	/**
	 * Bean para acceder a los metodos de negocio: Acusticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setAcusticasBO(AcusticasBO bean) {
		this.acusticasBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Deficiencia
	 */
	@Autowired
	@Qualifier("DeficienciaBean")
	private DeficienciaBO deficienciaBO;

	/**
	 * Bean para acceder a los metodos de negocio: Deficiencia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setDeficienciaBO(DeficienciaBO bean) {
		this.deficienciaBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Valor
	 */
	@Autowired
	@Qualifier("ValorBean")
	private ValorBO valorBO;

	/**
	 * Bean para acceder a los metodos de negocio: Valor
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setValorBO(ValorBO bean) {
		this.valorBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Conservacion
	 */
	@Autowired
	@Qualifier("ConservacionBean")
	private ConservacionBO conservacionBO;

	/**
	 * Bean para acceder a los metodos de negocio: Conservacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setConservacionBO(ConservacionBO bean) {
		this.conservacionBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Historico
	 */
	@Autowired
	@Qualifier("HistoricoBean")
	private HistoricoBO historicoBO;

	/**
	 * Bean para acceder a los metodos de negocio: Historico
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setHistoricoBO(HistoricoBO bean) {
		this.historicoBO = bean;
	}

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, InspeccionFormVO instance) {

		if (instance != null) {
			//Estamos actuando sobre una instancia en concreto, aquí comprobamos que el usuario tenga acceso al municipio 
			if (!AuthUtils.hasAccess(usuari, instance.getMunicipioId())) {
				return false;
			}
		}

		if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.CONSULTA, Constants.MUNICIPI);
		}

		return false;
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "informe.edificio.via.municipio.clave", municipioId));

		}

	}

	/*
	 * ************************** Métodos del interfaz FormService
	 * ************************************
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.caib.avaedi.front.service.FormService#getListMetadata(es.caib.avaedi
	 * .front.items.FormItem, es.caib.avaedi.common.realm.BaseFrontPrincipal,
	 * java.util.Locale)
	 */
	public GridMetaData getListMetadata(FormItem formItem, BaseFrontPrincipal usuari, Locale locale) {

		if ((formItem.getText() == null) || formItem.getText().equals("")) {
			formItem.setText(this.getMessage("forms.inspeccion.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("InspeccionForm");

		//Nombre de la clase js de listado
		metaData.setListClassName("InspeccionGrid");

		//Configurar las acciones posibles según los permisos
		metaData.setShowNewButton(this.hasPerms(usuari, PERMS_ADD));
		metaData.setShowDeleteButton(this.hasPerms(usuari, PERMS_DELETE));
		metaData.setShowUpdateButton(this.hasPerms(usuari, PERMS_UPDATE));
		metaData.setShowExportControls(this.hasPerms(usuari, PERMS_EXPORT));

		//TODO: desactivar si no se quiere hacer grid editable
		metaData.setEditable(this.hasPerms(usuari, PERMS_UPDATE));

		//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "id", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("id", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("id", this.getMessage("forms.inspeccion.columns.id.header", locale)));
		metaData.getColumn("id").setGroupable(false);
		metaData.getColumn("id").setSortable(true);
		metaData.getColumn("id").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.addRecordField(new GridRecordFieldMetaData("edificioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificio", "edificioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna

		//this.getMessage("forms.baseinspeccion.edificio.title", locale) 
		metaData.addColumn(new GridColumnMetaData("edificio", this.getMessage("forms.baseinspeccion.edificio.title", locale)));
		metaData.getColumn("edificio").setGroupable(true);
		metaData.getColumn("edificio").setSortable(true);
		metaData.getColumn("edificio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("edificio").setRelatedForm("Edificio");

		metaData.getColumn("edificio").setEditable(false);
		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		//this.getMessage("forms.conservacion.columns.inspeccion.header", locale) 
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.baseinspeccion.municipio.title", locale)));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setEditable(false);

		/*
		 * Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("informeId",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("informeLabel",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("informe", "informeLabel",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn(new
		 * GridColumnMetaData("informe",
		 * this.getMessage("forms.inspeccion.columns.informe.header", locale)));
		 * metaData.getColumn("informe").setGroupable(true);
		 * metaData.getColumn("informe").setSortable(true);
		 * metaData.getColumn("informe"
		 * ).setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("informe").setRelatedForm("Informe");
		 * 
		 * metaData.getColumn("informe").setEditable(true);
		 * metaData.getColumn("informe").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadAjustesrazonablesCostes", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("accesibilidadAjustesrazonablesCostes", this.getMessage("forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.header", locale)));
		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setTooltip(this.getMessage("forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.description", locale));
		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setGroupable(false);
		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setSortable(true);
		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setEditable(true);
		metaData.getColumn("accesibilidadAjustesrazonablesCostes").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("conservacionDatosgeneralesArchivos", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("conservacionDatosgeneralesArchivos", this.getMessage("forms.inspeccion.columns.conservacionDatosgeneralesArchivos.header", locale)));
		metaData.getColumn("conservacionDatosgeneralesArchivos").setTooltip(this.getMessage("forms.inspeccion.columns.conservacionDatosgeneralesArchivos.description", locale));
		metaData.getColumn("conservacionDatosgeneralesArchivos").setGroupable(false);
		metaData.getColumn("conservacionDatosgeneralesArchivos").setSortable(true);
		metaData.getColumn("conservacionDatosgeneralesArchivos").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("conservacionDatosgeneralesArchivos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("conservacionDatosgeneralesArchivos").setEditable(true);
		metaData.getColumn("conservacionDatosgeneralesArchivos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ieeCompleta", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("ieeCompleta", this.getMessage("forms.inspeccion.columns.ieeCompleta.header", locale)));
		metaData.getColumn("ieeCompleta").setGroupable(false);
		metaData.getColumn("ieeCompleta").setSortable(true);
		metaData.getColumn("ieeCompleta").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("ieeCompleta").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] ieeStore = new String[][] { { String.valueOf(Keys.INSPECCION_IEE_COMPLETA_COMPLETO), this.getMessage("forms.inspeccion.columns.ieeCompleta." + Keys.INSPECCION_IEE_COMPLETA_COMPLETO, locale) }, { String.valueOf(Keys.INSPECCION_IEE_COMPLETA_CON_ITE_REALIZADA), this.getMessage("forms.inspeccion.columns.ieeCompleta." + Keys.INSPECCION_IEE_COMPLETA_CON_ITE_REALIZADA, locale) }, };

		metaData.getColumn("ieeCompleta").setSofaStoreValues(ieeStore);

		metaData.getColumn("ieeCompleta").setEditable(true);
		//metaData.getColumn("ieeCompleta").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alturaSobreRasante", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("alturaSobreRasante", this.getMessage("forms.inspeccion.columns.alturaSobreRasante.header", locale)));
		metaData.getColumn("alturaSobreRasante").setGroupable(true);
		metaData.getColumn("alturaSobreRasante").setSortable(true);
		metaData.getColumn("alturaSobreRasante").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("alturaSobreRasante").setEditable(true);
		metaData.getColumn("alturaSobreRasante").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("anoConstruccion", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("anoConstruccion", this.getMessage("forms.inspeccion.columns.anoConstruccion.header", locale)));
		metaData.getColumn("anoConstruccion").setGroupable(false);
		metaData.getColumn("anoConstruccion").setSortable(true);
		metaData.getColumn("anoConstruccion").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("anoConstruccion").setEditable(true);
		//metaData.getColumn("anoConstruccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("anoConstruccionReferencia", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("anoConstruccionReferencia", this.getMessage("forms.inspeccion.columns.anoConstruccionReferencia.header", locale)));
		metaData.getColumn("anoConstruccionReferencia").setGroupable(false);
		metaData.getColumn("anoConstruccionReferencia").setSortable(true);
		metaData.getColumn("anoConstruccionReferencia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("anoConstruccionReferencia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("anoConstruccionReferencia").setEditable(true);
		//metaData.getColumn("anoConstruccionReferencia").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("anoRehabilitacion", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("anoRehabilitacion", this.getMessage("forms.inspeccion.columns.anoRehabilitacion.header", locale)));
		metaData.getColumn("anoRehabilitacion").setGroupable(false);
		metaData.getColumn("anoRehabilitacion").setSortable(true);
		metaData.getColumn("anoRehabilitacion").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("anoRehabilitacion").setEditable(true);
		//metaData.getColumn("anoRehabilitacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("anoRehabilitacionReferencia", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("anoRehabilitacionReferencia", this.getMessage("forms.inspeccion.columns.anoRehabilitacionReferencia.header", locale)));
		metaData.getColumn("anoRehabilitacionReferencia").setGroupable(false);
		metaData.getColumn("anoRehabilitacionReferencia").setSortable(true);
		metaData.getColumn("anoRehabilitacionReferencia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("anoRehabilitacionReferencia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("anoRehabilitacionReferencia").setEditable(true);
		//metaData.getColumn("anoRehabilitacionReferencia").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionDatosedificioNucleosescalerasTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("inspeccionDatosedificioNucleosescalerasTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.header", locale)));
		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.description", locale));
		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setGroupable(false);
		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setSortable(true);
		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		String[][] nucleoEscalerasStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICACION_UN_SOLO_NUCLEO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId." + Keys.INSPECCION_EDIFICACION_UN_SOLO_NUCLEO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_DOS_O_MAS_NUCLEOS), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId." + Keys.INSPECCION_EDIFICACION_DOS_O_MAS_NUCLEOS, locale) }, };

		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setSofaStoreValues(nucleoEscalerasStore);

		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setEditable(true);
		metaData.getColumn("inspeccionDatosedificioNucleosescalerasTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionDatosedificioParcelaTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("inspeccionDatosedificioParcelaTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.header", locale)));
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.description", locale));
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setGroupable(false);
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setSortable(true);
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		String[][] parcelaTipoIdStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICACION_EXENTA_AISLADA_O__PAREADA_EN_PARCELA_BLOQUE_ABIERTO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId." + Keys.INSPECCION_EDIFICACION_EXENTA_AISLADA_O__PAREADA_EN_PARCELA_BLOQUE_ABIERTO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_ENTRE_MEDIANERAS_ADOSADA_EDIFICACION_EN_MANZANA_CERRADA), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId." + Keys.INSPECCION_EDIFICACION_ENTRE_MEDIANERAS_ADOSADA_EDIFICACION_EN_MANZANA_CERRADA, locale) }, };
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setSofaStoreValues(parcelaTipoIdStore);
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setEditable(true);
		metaData.getColumn("inspeccionDatosedificioParcelaTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionDatosedificioUnnucleoescalerasTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("inspeccionDatosedificioUnnucleoescalerasTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.header", locale)));
		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.description", locale));
		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setGroupable(false);
		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setSortable(true);
		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		String[][] unnucleoEscalerasStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICACION_SIN_ASCENSOR), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId." + Keys.INSPECCION_EDIFICACION_SIN_ASCENSOR, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_CON_UN_ASCENSOR), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId." + Keys.INSPECCION_EDIFICACION_CON_UN_ASCENSOR, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_CON_DOS_O_MAS_ASCENSORES), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId." + Keys.INSPECCION_EDIFICACION_CON_DOS_O_MAS_ASCENSORES, locale) }, };

		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setSofaStoreValues(unnucleoEscalerasStore);

		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setEditable(true);
		metaData.getColumn("inspeccionDatosedificioUnnucleoescalerasTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionDatosedificioUsoTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("inspeccionDatosedificioUsoTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.header", locale)));
		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.description", locale));
		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setGroupable(false);
		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setSortable(true);
		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] usoStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICACION_RESIDENCIAL_PUBLICO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_RESIDENCIAL_PUBLICO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_RESIDENCIAL_PRIVADO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_RESIDENCIAL_PRIVADO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_ADMINISTRATIVO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_ADMINISTRATIVO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_DOCENTE), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_DOCENTE, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_COMERCIAL), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_COMERCIAL, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_INDUSTRIAL), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_INDUSTRIAL, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_SANITARIO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_SANITARIO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICACION_OTRO), this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + Keys.INSPECCION_EDIFICACION_OTRO, locale) }, };

		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setSofaStoreValues(usoStore);

		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setEditable(true);
		metaData.getColumn("inspeccionDatosedificioUsoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mediaViviendasPorPlanta", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("mediaViviendasPorPlanta", this.getMessage("forms.inspeccion.columns.mediaViviendasPorPlanta.header", locale)));
		metaData.getColumn("mediaViviendasPorPlanta").setGroupable(false);
		metaData.getColumn("mediaViviendasPorPlanta").setSortable(true);
		metaData.getColumn("mediaViviendasPorPlanta").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("mediaViviendasPorPlanta").setEditable(true);
		metaData.getColumn("mediaViviendasPorPlanta").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numAparcamientos", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("numAparcamientos", this.getMessage("forms.inspeccion.columns.numAparcamientos.header", locale)));
		metaData.getColumn("numAparcamientos").setGroupable(false);
		metaData.getColumn("numAparcamientos").setSortable(true);
		metaData.getColumn("numAparcamientos").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numAparcamientos").setEditable(true);
		metaData.getColumn("numAparcamientos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numLocales", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("numLocales", this.getMessage("forms.inspeccion.columns.numLocales.header", locale)));
		metaData.getColumn("numLocales").setGroupable(false);
		metaData.getColumn("numLocales").setSortable(true);
		metaData.getColumn("numLocales").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numLocales").setEditable(true);
		metaData.getColumn("numLocales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numTrasteros", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("numTrasteros", this.getMessage("forms.inspeccion.columns.numTrasteros.header", locale)));
		metaData.getColumn("numTrasteros").setGroupable(false);
		metaData.getColumn("numTrasteros").setSortable(true);
		metaData.getColumn("numTrasteros").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numTrasteros").setEditable(true);
		metaData.getColumn("numTrasteros").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numViviendas", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("numViviendas", this.getMessage("forms.inspeccion.columns.numViviendas.header", locale)));
		metaData.getColumn("numViviendas").setGroupable(false);
		metaData.getColumn("numViviendas").setSortable(true);
		metaData.getColumn("numViviendas").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numViviendas").setEditable(true);
		metaData.getColumn("numViviendas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasBajoRasanteUsoPrincipal", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasBajoRasanteUsoPrincipal", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.header", locale)));
		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setTooltip(this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.description", locale));
		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setGroupable(false);
		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setSortable(true);
		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setEditable(true);
		metaData.getColumn("plantasBajoRasanteUsoPrincipal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasBajoRasanteUsosSecundarios", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasBajoRasanteUsosSecundarios", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.header", locale)));
		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setTooltip(this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.description", locale));
		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setGroupable(false);
		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setSortable(true);
		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setEditable(true);
		metaData.getColumn("plantasBajoRasanteUsosSecundarios").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasBajoRasanteUsosSecundariosTipo", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasBajoRasanteUsosSecundariosTipo", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.header", locale)));
		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setTooltip(this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.description", locale));
		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setGroupable(false);
		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setSortable(true);
		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setEditable(true);
		metaData.getColumn("plantasBajoRasanteUsosSecundariosTipo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasSobreRasanteUsoPrincipal", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasSobreRasanteUsoPrincipal", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.header", locale)));
		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setTooltip(this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.description", locale));
		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setGroupable(false);
		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setSortable(true);
		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setEditable(true);
		metaData.getColumn("plantasSobreRasanteUsoPrincipal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasSobreRasanteUsosSecundarios", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasSobreRasanteUsosSecundarios", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.header", locale)));
		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setTooltip(this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.description", locale));
		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setGroupable(false);
		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setSortable(true);
		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setEditable(true);
		metaData.getColumn("plantasSobreRasanteUsosSecundarios").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasSobreRasanteUsosSecundariosTipo", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("plantasSobreRasanteUsosSecundariosTipo", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.header", locale)));
		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setTooltip(this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.description", locale));
		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setGroupable(false);
		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setSortable(true);
		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setEditable(true);
		metaData.getColumn("plantasSobreRasanteUsosSecundariosTipo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieConstruida", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieConstruida", this.getMessage("forms.inspeccion.columns.superficieConstruida.header", locale)));
		metaData.getColumn("superficieConstruida").setGroupable(true);
		metaData.getColumn("superficieConstruida").setSortable(true);
		metaData.getColumn("superficieConstruida").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieConstruida").setEditable(true);
		metaData.getColumn("superficieConstruida").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieMediaAparcamientos", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieMediaAparcamientos", this.getMessage("forms.inspeccion.columns.superficieMediaAparcamientos.header", locale)));
		metaData.getColumn("superficieMediaAparcamientos").setGroupable(true);
		metaData.getColumn("superficieMediaAparcamientos").setSortable(true);
		metaData.getColumn("superficieMediaAparcamientos").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieMediaAparcamientos").setEditable(true);
		metaData.getColumn("superficieMediaAparcamientos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieMediaLocales", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieMediaLocales", this.getMessage("forms.inspeccion.columns.superficieMediaLocales.header", locale)));
		metaData.getColumn("superficieMediaLocales").setGroupable(true);
		metaData.getColumn("superficieMediaLocales").setSortable(true);
		metaData.getColumn("superficieMediaLocales").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieMediaLocales").setEditable(true);
		metaData.getColumn("superficieMediaLocales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieMediaTrasteros", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieMediaTrasteros", this.getMessage("forms.inspeccion.columns.superficieMediaTrasteros.header", locale)));
		metaData.getColumn("superficieMediaTrasteros").setGroupable(true);
		metaData.getColumn("superficieMediaTrasteros").setSortable(true);
		metaData.getColumn("superficieMediaTrasteros").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieMediaTrasteros").setEditable(true);
		metaData.getColumn("superficieMediaTrasteros").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieMediaViviendas", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieMediaViviendas", this.getMessage("forms.inspeccion.columns.superficieMediaViviendas.header", locale)));
		metaData.getColumn("superficieMediaViviendas").setGroupable(true);
		metaData.getColumn("superficieMediaViviendas").setSortable(true);
		metaData.getColumn("superficieMediaViviendas").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieMediaViviendas").setEditable(true);
		metaData.getColumn("superficieMediaViviendas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("superficieParcela", GridRecordFieldMetaData.AUTO_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("superficieParcela", this.getMessage("forms.inspeccion.columns.superficieParcela.header", locale)));
		metaData.getColumn("superficieParcela").setGroupable(true);
		metaData.getColumn("superficieParcela").setSortable(true);
		metaData.getColumn("superficieParcela").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("superficieParcela").setEditable(true);
		metaData.getColumn("superficieParcela").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("totalAscensores", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("totalAscensores", this.getMessage("forms.inspeccion.columns.totalAscensores.header", locale)));
		metaData.getColumn("totalAscensores").setGroupable(false);
		metaData.getColumn("totalAscensores").setSortable(true);
		metaData.getColumn("totalAscensores").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("totalAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("totalAscensores").setEditable(true);
		metaData.getColumn("totalAscensores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("totalEscaleras", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("totalEscaleras", this.getMessage("forms.inspeccion.columns.totalEscaleras.header", locale)));
		metaData.getColumn("totalEscaleras").setGroupable(false);
		metaData.getColumn("totalEscaleras").setSortable(true);
		metaData.getColumn("totalEscaleras").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("totalEscaleras").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("totalEscaleras").setEditable(true);
		metaData.getColumn("totalEscaleras").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("totalViviendasConAccesoVariosNucleos", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("totalViviendasConAccesoVariosNucleos", this.getMessage("forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.header", locale)));
		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setTooltip(this.getMessage("forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.description", locale));
		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setGroupable(false);
		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setSortable(true);
		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setEditable(true);
		metaData.getColumn("totalViviendasConAccesoVariosNucleos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("totalViviendasSinAccesoAscensor", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("totalViviendasSinAccesoAscensor", this.getMessage("forms.inspeccion.columns.totalViviendasSinAccesoAscensor.header", locale)));
		metaData.getColumn("totalViviendasSinAccesoAscensor").setTooltip(this.getMessage("forms.inspeccion.columns.totalViviendasSinAccesoAscensor.description", locale));
		metaData.getColumn("totalViviendasSinAccesoAscensor").setGroupable(false);
		metaData.getColumn("totalViviendasSinAccesoAscensor").setSortable(true);
		metaData.getColumn("totalViviendasSinAccesoAscensor").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("totalViviendasSinAccesoAscensor").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("totalViviendasSinAccesoAscensor").setEditable(true);
		metaData.getColumn("totalViviendasSinAccesoAscensor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("usoTexto", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("usoTexto", this.getMessage("forms.inspeccion.columns.usoTexto.header", locale)));
		metaData.getColumn("usoTexto").setGroupable(false);
		metaData.getColumn("usoTexto").setSortable(true);
		metaData.getColumn("usoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("usoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("usoTexto").setEditable(true);
		metaData.getColumn("usoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numero", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("numero", this.getMessage("forms.inspeccion.columns.numero.header", locale)));
		metaData.getColumn("numero").setGroupable(false);
		metaData.getColumn("numero").setSortable(true);
		metaData.getColumn("numero").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numero").setEditable(true);
		metaData.getColumn("numero").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tipoVia", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("tipoVia", this.getMessage("forms.inspeccion.columns.tipoVia.header", locale)));
		metaData.getColumn("tipoVia").setGroupable(false);
		metaData.getColumn("tipoVia").setSortable(true);
		metaData.getColumn("tipoVia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tipoVia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tipoVia").setEditable(true);
		metaData.getColumn("tipoVia").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("via", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("via", this.getMessage("forms.inspeccion.columns.via.header", locale)));
		metaData.getColumn("via").setGroupable(false);
		metaData.getColumn("via").setSortable(true);
		metaData.getColumn("via").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("via").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("via").setEditable(true);
		metaData.getColumn("via").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("principal", GridRecordFieldMetaData.BOOLEAN_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("principal", this.getMessage("forms.inspeccion.columns.principal.header", locale)));
		metaData.getColumn("principal").setGroupable(false);
		metaData.getColumn("principal").setSortable(true);
		metaData.getColumn("principal").setSofaFilter(GridColumnFilter.TYPE_BOOLEAN);

		metaData.getColumn("principal").setSofaRenderer(GridColumnMetaData.RENDERER_BOOLEAN);

		metaData.getColumn("principal").setEditable(true);
		metaData.getColumn("principal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("referenciaCatastral", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("referenciaCatastral", this.getMessage("forms.inspeccion.columns.referenciaCatastral.header", locale)));
		metaData.getColumn("referenciaCatastral").setGroupable(false);
		metaData.getColumn("referenciaCatastral").setSortable(true);
		metaData.getColumn("referenciaCatastral").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("referenciaCatastral").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("referenciaCatastral").setEditable(true);
		metaData.getColumn("referenciaCatastral").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioCodigoPostal", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioCodigoPostal", this.getMessage("forms.inspeccion.columns.edificioCodigoPostal.header", locale)));
		metaData.getColumn("edificioCodigoPostal").setGroupable(false);
		metaData.getColumn("edificioCodigoPostal").setSortable(true);
		metaData.getColumn("edificioCodigoPostal").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioCodigoPostal").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioCodigoPostal").setEditable(true);
		metaData.getColumn("edificioCodigoPostal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioComunTexto", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioComunTexto", this.getMessage("forms.inspeccion.columns.edificioComunTexto.header", locale)));
		metaData.getColumn("edificioComunTexto").setGroupable(false);
		metaData.getColumn("edificioComunTexto").setSortable(true);
		metaData.getColumn("edificioComunTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioComunTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioComunTexto").setEditable(true);
		metaData.getColumn("edificioComunTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioInspeccionIdentificacionedificioComunesTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioInspeccionIdentificacionedificioComunesTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.header", locale)));
		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.description", locale));
		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setGroupable(false);
		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setSortable(true);
		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] edificioComunesStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICIO_NO), this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId." + Keys.INSPECCION_EDIFICIO_NO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_SI), this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId." + Keys.INSPECCION_EDIFICIO_SI, locale) }, };

		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setSofaStoreValues(edificioComunesStore);

		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setEditable(true);
		metaData.getColumn("edificioInspeccionIdentificacionedificioComunesTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioInspeccionIdentificacionedificioObjetoTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioInspeccionIdentificacionedificioObjetoTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.header", locale)));
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.description", locale));
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setGroupable(false);
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setSortable(true);
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] edificioObjetoStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICIO_UNICO_EDIFICIO), this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId." + Keys.INSPECCION_EDIFICIO_UNICO_EDIFICIO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_PARTE_EDIFICIO_FUNCIONALMENTE_INDEPENDIENTE_DEL_RESTO), this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId." + Keys.INSPECCION_EDIFICIO_PARTE_EDIFICIO_FUNCIONALMENTE_INDEPENDIENTE_DEL_RESTO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_OTRO_CASO), this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId." + Keys.INSPECCION_EDIFICIO_OTRO_CASO, locale) }, };

		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setSofaStoreValues(edificioObjetoStore);

		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setEditable(true);
		metaData.getColumn("edificioInspeccionIdentificacionedificioObjetoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioInspeccionPropiedadRegimenTipoId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioInspeccionPropiedadRegimenTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.header", locale)));
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setTooltip(this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.description", locale));
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setGroupable(false);
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setSortable(true);
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] porpiedadRegimenStore = new String[][] { { String.valueOf(Keys.INSPECCION_EDIFICIO_COMUNIDAD_PROPIETARIOS), this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId." + Keys.INSPECCION_EDIFICIO_COMUNIDAD_PROPIETARIOS, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_PROPIETARIO_UNICO), this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId." + Keys.INSPECCION_EDIFICIO_PROPIETARIO_UNICO, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_VARIOS_PROPIETARIOS), this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId." + Keys.INSPECCION_EDIFICIO_VARIOS_PROPIETARIOS, locale) }, { String.valueOf(Keys.INSPECCION_EDIFICIO_OTROS), this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId." + Keys.INSPECCION_EDIFICIO_OTROS, locale) }, };

		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setSofaStoreValues(porpiedadRegimenStore);

		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setEditable(true);
		metaData.getColumn("edificioInspeccionPropiedadRegimenTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioNumeroManual", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioNumeroManual", this.getMessage("forms.inspeccion.columns.edificioNumeroManual.header", locale)));
		metaData.getColumn("edificioNumeroManual").setGroupable(false);
		metaData.getColumn("edificioNumeroManual").setSortable(true);
		metaData.getColumn("edificioNumeroManual").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioNumeroManual").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioNumeroManual").setEditable(true);
		metaData.getColumn("edificioNumeroManual").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioObjetoTexto", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioObjetoTexto", this.getMessage("forms.inspeccion.columns.edificioObjetoTexto.header", locale)));
		metaData.getColumn("edificioObjetoTexto").setGroupable(false);
		metaData.getColumn("edificioObjetoTexto").setSortable(true);
		metaData.getColumn("edificioObjetoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioObjetoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioObjetoTexto").setEditable(true);
		metaData.getColumn("edificioObjetoTexto").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("edificioObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		/*
		 * metaData.addColumn( new GridColumnMetaData( "edificioObservaciones",
		 * this
		 * .getMessage("forms.inspeccion.columns.edificioObservaciones.header",
		 * locale) ) );
		 * metaData.getColumn("edificioObservaciones").setGroupable( false );
		 * metaData.getColumn("edificioObservaciones").setSortable( true );
		 * metaData.getColumn("edificioObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("edificioObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("edificioObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioPisoLetra", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioPisoLetra", this.getMessage("forms.inspeccion.columns.edificioPisoLetra.header", locale)));
		metaData.getColumn("edificioPisoLetra").setGroupable(false);
		metaData.getColumn("edificioPisoLetra").setSortable(true);
		metaData.getColumn("edificioPisoLetra").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioPisoLetra").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioPisoLetra").setEditable(true);
		metaData.getColumn("edificioPisoLetra").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioPoblacion", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioPoblacion", this.getMessage("forms.inspeccion.columns.edificioPoblacion.header", locale)));
		metaData.getColumn("edificioPoblacion").setGroupable(false);
		metaData.getColumn("edificioPoblacion").setSortable(true);
		metaData.getColumn("edificioPoblacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioPoblacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioPoblacion").setEditable(true);
		metaData.getColumn("edificioPoblacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioProvincia", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioProvincia", this.getMessage("forms.inspeccion.columns.edificioProvincia.header", locale)));
		metaData.getColumn("edificioProvincia").setGroupable(false);
		metaData.getColumn("edificioProvincia").setSortable(true);
		metaData.getColumn("edificioProvincia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioProvincia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioProvincia").setEditable(true);
		metaData.getColumn("edificioProvincia").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioProvinciaId", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioProvinciaId", this.getMessage("forms.inspeccion.columns.edificioProvinciaId.header", locale)));
		metaData.getColumn("edificioProvinciaId").setGroupable(false);
		metaData.getColumn("edificioProvinciaId").setSortable(true);
		metaData.getColumn("edificioProvinciaId").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("edificioProvinciaId").setEditable(true);
		metaData.getColumn("edificioProvinciaId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioRegimenTexto", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioRegimenTexto", this.getMessage("forms.inspeccion.columns.edificioRegimenTexto.header", locale)));
		metaData.getColumn("edificioRegimenTexto").setGroupable(false);
		metaData.getColumn("edificioRegimenTexto").setSortable(true);
		metaData.getColumn("edificioRegimenTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioRegimenTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioRegimenTexto").setEditable(true);
		metaData.getColumn("edificioRegimenTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioTipoViaManual", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioTipoViaManual", this.getMessage("forms.inspeccion.columns.edificioTipoViaManual.header", locale)));
		metaData.getColumn("edificioTipoViaManual").setGroupable(false);
		metaData.getColumn("edificioTipoViaManual").setSortable(true);
		metaData.getColumn("edificioTipoViaManual").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioTipoViaManual").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioTipoViaManual").setEditable(true);
		metaData.getColumn("edificioTipoViaManual").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioViaManual", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("edificioViaManual", this.getMessage("forms.inspeccion.columns.edificioViaManual.header", locale)));
		metaData.getColumn("edificioViaManual").setGroupable(false);
		metaData.getColumn("edificioViaManual").setSortable(true);
		metaData.getColumn("edificioViaManual").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("edificioViaManual").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("edificioViaManual").setEditable(true);
		metaData.getColumn("edificioViaManual").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("propiedadNif", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("propiedadNif", this.getMessage("forms.inspeccion.columns.propiedadNif.header", locale)));
		metaData.getColumn("propiedadNif").setGroupable(false);
		metaData.getColumn("propiedadNif").setSortable(true);
		metaData.getColumn("propiedadNif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("propiedadNif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("propiedadNif").setEditable(true);
		metaData.getColumn("propiedadNif").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("propiedadTitular", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("propiedadTitular", this.getMessage("forms.inspeccion.columns.propiedadTitular.header", locale)));
		metaData.getColumn("propiedadTitular").setGroupable(false);
		metaData.getColumn("propiedadTitular").setSortable(true);
		metaData.getColumn("propiedadTitular").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("propiedadTitular").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("propiedadTitular").setEditable(true);
		metaData.getColumn("propiedadTitular").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteCodigoPostal", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteCodigoPostal", this.getMessage("forms.inspeccion.columns.representanteCodigoPostal.header", locale)));
		metaData.getColumn("representanteCodigoPostal").setGroupable(false);
		metaData.getColumn("representanteCodigoPostal").setSortable(true);
		metaData.getColumn("representanteCodigoPostal").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteCodigoPostal").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteCodigoPostal").setEditable(true);
		metaData.getColumn("representanteCodigoPostal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteCondicion", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteCondicion", this.getMessage("forms.inspeccion.columns.representanteCondicion.header", locale)));
		metaData.getColumn("representanteCondicion").setGroupable(false);
		metaData.getColumn("representanteCondicion").setSortable(true);
		metaData.getColumn("representanteCondicion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteCondicion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteCondicion").setEditable(true);
		metaData.getColumn("representanteCondicion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteDireccion", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteDireccion", this.getMessage("forms.inspeccion.columns.representanteDireccion.header", locale)));
		metaData.getColumn("representanteDireccion").setGroupable(false);
		metaData.getColumn("representanteDireccion").setSortable(true);
		metaData.getColumn("representanteDireccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteDireccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteDireccion").setEditable(true);
		metaData.getColumn("representanteDireccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteEmail", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteEmail", this.getMessage("forms.inspeccion.columns.representanteEmail.header", locale)));
		metaData.getColumn("representanteEmail").setGroupable(false);
		metaData.getColumn("representanteEmail").setSortable(true);
		metaData.getColumn("representanteEmail").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteEmail").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteEmail").setEditable(true);
		metaData.getColumn("representanteEmail").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteNif", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteNif", this.getMessage("forms.inspeccion.columns.representanteNif.header", locale)));
		metaData.getColumn("representanteNif").setGroupable(false);
		metaData.getColumn("representanteNif").setSortable(true);
		metaData.getColumn("representanteNif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteNif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteNif").setEditable(true);
		metaData.getColumn("representanteNif").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteNombre", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteNombre", this.getMessage("forms.inspeccion.columns.representanteNombre.header", locale)));
		metaData.getColumn("representanteNombre").setGroupable(false);
		metaData.getColumn("representanteNombre").setSortable(true);
		metaData.getColumn("representanteNombre").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteNombre").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteNombre").setEditable(true);
		metaData.getColumn("representanteNombre").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representantePoblacion", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representantePoblacion", this.getMessage("forms.inspeccion.columns.representantePoblacion.header", locale)));
		metaData.getColumn("representantePoblacion").setGroupable(false);
		metaData.getColumn("representantePoblacion").setSortable(true);
		metaData.getColumn("representantePoblacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representantePoblacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representantePoblacion").setEditable(true);
		metaData.getColumn("representantePoblacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteProvincia", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteProvincia", this.getMessage("forms.inspeccion.columns.representanteProvincia.header", locale)));
		metaData.getColumn("representanteProvincia").setGroupable(false);
		metaData.getColumn("representanteProvincia").setSortable(true);
		metaData.getColumn("representanteProvincia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteProvincia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteProvincia").setEditable(true);
		metaData.getColumn("representanteProvincia").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteTelefonoFijo", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteTelefonoFijo", this.getMessage("forms.inspeccion.columns.representanteTelefonoFijo.header", locale)));
		metaData.getColumn("representanteTelefonoFijo").setGroupable(false);
		metaData.getColumn("representanteTelefonoFijo").setSortable(true);
		metaData.getColumn("representanteTelefonoFijo").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteTelefonoFijo").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteTelefonoFijo").setEditable(true);
		metaData.getColumn("representanteTelefonoFijo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("representanteTelefonoMovil", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("representanteTelefonoMovil", this.getMessage("forms.inspeccion.columns.representanteTelefonoMovil.header", locale)));
		metaData.getColumn("representanteTelefonoMovil").setGroupable(false);
		metaData.getColumn("representanteTelefonoMovil").setSortable(true);
		metaData.getColumn("representanteTelefonoMovil").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("representanteTelefonoMovil").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("representanteTelefonoMovil").setEditable(true);
		metaData.getColumn("representanteTelefonoMovil").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnicoNif", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("tecnicoNif", this.getMessage("forms.inspeccion.columns.tecnicoNif.header", locale)));
		metaData.getColumn("tecnicoNif").setGroupable(false);
		metaData.getColumn("tecnicoNif").setSortable(true);
		metaData.getColumn("tecnicoNif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnicoNif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnicoNif").setEditable(true);
		metaData.getColumn("tecnicoNif").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnicoTecnico", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("tecnicoTecnico", this.getMessage("forms.inspeccion.columns.tecnicoTecnico.header", locale)));
		metaData.getColumn("tecnicoTecnico").setGroupable(false);
		metaData.getColumn("tecnicoTecnico").setSortable(true);
		metaData.getColumn("tecnicoTecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnicoTecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnicoTecnico").setEditable(true);
		metaData.getColumn("tecnicoTecnico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnicoTitulacion", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("tecnicoTitulacion", this.getMessage("forms.inspeccion.columns.tecnicoTitulacion.header", locale)));
		metaData.getColumn("tecnicoTitulacion").setGroupable(false);
		metaData.getColumn("tecnicoTitulacion").setSortable(true);
		metaData.getColumn("tecnicoTitulacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnicoTitulacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnicoTitulacion").setEditable(true);
		metaData.getColumn("tecnicoTitulacion").setHidden(true);

		/*//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadPublicosId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadPublicosLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadPublicos", "accesibilidadPublicosLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("accesibilidadPublicos", this.getMessage("forms.inspeccion.columns.accesibilidadPublicos.header", locale)));
		metaData.getColumn("accesibilidadPublicos").setGroupable(true);
		metaData.getColumn("accesibilidadPublicos").setSortable(true);
		metaData.getColumn("accesibilidadPublicos").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("accesibilidadPublicos").setRelatedForm("AccesibilidadPublicos");

		metaData.getColumn("accesibilidadPublicos").setEditable(true);
		metaData.getColumn("accesibilidadPublicos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresUnionesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresUnionesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresUniones", "acusticaRuidosInterioresUnionesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaRuidosInterioresUniones", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresUniones.header", locale)));
		metaData.getColumn("acusticaRuidosInterioresUniones").setGroupable(true);
		metaData.getColumn("acusticaRuidosInterioresUniones").setSortable(true);
		metaData.getColumn("acusticaRuidosInterioresUniones").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaRuidosInterioresUniones").setRelatedForm("AcusticaRuidosInterioresUniones");

		metaData.getColumn("acusticaRuidosInterioresUniones").setEditable(true);
		metaData.getColumn("acusticaRuidosInterioresUniones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaValoracionFinalId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaValoracionFinalLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaValoracionFinal", "acusticaValoracionFinalLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaValoracionFinal", this.getMessage("forms.inspeccion.columns.acusticaValoracionFinal.header", locale)));
		metaData.getColumn("acusticaValoracionFinal").setGroupable(true);
		metaData.getColumn("acusticaValoracionFinal").setSortable(true);
		metaData.getColumn("acusticaValoracionFinal").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaValoracionFinal").setRelatedForm("AcusticaValoracionFinal");

		metaData.getColumn("acusticaValoracionFinal").setEditable(true);
		metaData.getColumn("acusticaValoracionFinal").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresVerticalesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresVerticalesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresVerticales", "acusticaRuidosInterioresVerticalesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaRuidosInterioresVerticales", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresVerticales.header", locale)));
		metaData.getColumn("acusticaRuidosInterioresVerticales").setGroupable(true);
		metaData.getColumn("acusticaRuidosInterioresVerticales").setSortable(true);
		metaData.getColumn("acusticaRuidosInterioresVerticales").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaRuidosInterioresVerticales").setRelatedForm("AcusticaRuidosInterioresVerticales");

		metaData.getColumn("acusticaRuidosInterioresVerticales").setEditable(true);
		metaData.getColumn("acusticaRuidosInterioresVerticales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaComprobacionesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaComprobacionesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaComprobaciones", "acusticaComprobacionesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaComprobaciones", this.getMessage("forms.inspeccion.columns.acusticaComprobaciones.header", locale)));
		metaData.getColumn("acusticaComprobaciones").setGroupable(true);
		metaData.getColumn("acusticaComprobaciones").setSortable(true);
		metaData.getColumn("acusticaComprobaciones").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaComprobaciones").setRelatedForm("AcusticaComprobaciones");

		metaData.getColumn("acusticaComprobaciones").setEditable(true);
		metaData.getColumn("acusticaComprobaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("instalaciones", "instalacionesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("instalaciones", this.getMessage("forms.inspeccion.columns.instalaciones.header", locale)));
		metaData.getColumn("instalaciones").setGroupable(true);
		metaData.getColumn("instalaciones").setSortable(true);
		metaData.getColumn("instalaciones").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("instalaciones").setRelatedForm("Instalaciones");

		metaData.getColumn("instalaciones").setEditable(true);
		metaData.getColumn("instalaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cerramientosCubiertasId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("cerramientosCubiertasLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("cerramientosCubiertas", "cerramientosCubiertasLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("cerramientosCubiertas", this.getMessage("forms.inspeccion.columns.cerramientosCubiertas.header", locale)));
		metaData.getColumn("cerramientosCubiertas").setGroupable(true);
		metaData.getColumn("cerramientosCubiertas").setSortable(true);
		metaData.getColumn("cerramientosCubiertas").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("cerramientosCubiertas").setRelatedForm("CerramientosCubiertas");

		metaData.getColumn("cerramientosCubiertas").setEditable(true);
		metaData.getColumn("cerramientosCubiertas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadValoracionFinalesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadValoracionFinalesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadValoracionFinales", "accesibilidadValoracionFinalesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("accesibilidadValoracionFinales", this.getMessage("forms.inspeccion.columns.accesibilidadValoracionFinales.header", locale)));
		metaData.getColumn("accesibilidadValoracionFinales").setGroupable(true);
		metaData.getColumn("accesibilidadValoracionFinales").setSortable(true);
		metaData.getColumn("accesibilidadValoracionFinales").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("accesibilidadValoracionFinales").setRelatedForm("AccesibilidadValoracionFinales");

		metaData.getColumn("accesibilidadValoracionFinales").setEditable(true);
		metaData.getColumn("accesibilidadValoracionFinales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidoInstalacionesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidoInstalacionesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidoInstalaciones", "acusticaRuidoInstalacionesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaRuidoInstalaciones", this.getMessage("forms.inspeccion.columns.acusticaRuidoInstalaciones.header", locale)));
		metaData.getColumn("acusticaRuidoInstalaciones").setGroupable(true);
		metaData.getColumn("acusticaRuidoInstalaciones").setSortable(true);
		metaData.getColumn("acusticaRuidoInstalaciones").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaRuidoInstalaciones").setRelatedForm("AcusticaRuidoInstalaciones");

		metaData.getColumn("acusticaRuidoInstalaciones").setEditable(true);
		metaData.getColumn("acusticaRuidoInstalaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estructuraId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("estructuraLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("estructura", "estructuraLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("estructura", this.getMessage("forms.inspeccion.columns.estructura.header", locale)));
		metaData.getColumn("estructura").setGroupable(true);
		metaData.getColumn("estructura").setSortable(true);
		metaData.getColumn("estructura").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("estructura").setRelatedForm("Estructura");

		metaData.getColumn("estructura").setEditable(true);
		metaData.getColumn("estructura").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cimentacionesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("cimentacionesLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("cimentaciones", "cimentacionesLabel", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("cimentaciones", this.getMessage("forms.inspeccion.columns.cimentaciones.header", locale)));
		metaData.getColumn("cimentaciones").setGroupable(true);
		metaData.getColumn("cimentaciones").setSortable(true);
		metaData.getColumn("cimentaciones").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("cimentaciones").setRelatedForm("Cimentaciones");

		metaData.getColumn("cimentaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cimentaciones").setEditable(true);
		metaData.getColumn("cimentaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadAjustesRazonablesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadAjustesRazonablesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("accesibilidadAjustesRazonables", "accesibilidadAjustesRazonablesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("accesibilidadAjustesRazonables", this.getMessage("forms.inspeccion.columns.accesibilidadAjustesRazonables.header", locale)));
		metaData.getColumn("accesibilidadAjustesRazonables").setGroupable(true);
		metaData.getColumn("accesibilidadAjustesRazonables").setSortable(true);
		metaData.getColumn("accesibilidadAjustesRazonables").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("accesibilidadAjustesRazonables").setRelatedForm("AccesibilidadAjustesRazonables");

		metaData.getColumn("accesibilidadAjustesRazonables").setEditable(true);
		metaData.getColumn("accesibilidadAjustesRazonables").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("eficienciasEnergeticasId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("eficienciasEnergeticasLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("eficienciasEnergeticas", "eficienciasEnergeticasLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("eficienciasEnergeticas", this.getMessage("forms.inspeccion.columns.eficienciasEnergeticas.header", locale)));
		metaData.getColumn("eficienciasEnergeticas").setGroupable(true);
		metaData.getColumn("eficienciasEnergeticas").setSortable(true);
		metaData.getColumn("eficienciasEnergeticas").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("eficienciasEnergeticas").setRelatedForm("EficienciasEnergeticas");

		metaData.getColumn("eficienciasEnergeticas").setEditable(true);
		metaData.getColumn("eficienciasEnergeticas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosExterioresId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosExterioresLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosExteriores", "acusticaRuidosExterioresLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaRuidosExteriores", this.getMessage("forms.inspeccion.columns.acusticaRuidosExteriores.header", locale)));
		metaData.getColumn("acusticaRuidosExteriores").setGroupable(true);
		metaData.getColumn("acusticaRuidosExteriores").setSortable(true);
		metaData.getColumn("acusticaRuidosExteriores").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaRuidosExteriores").setRelatedForm("AcusticaRuidosExteriores");

		metaData.getColumn("acusticaRuidosExteriores").setEditable(true);
		metaData.getColumn("acusticaRuidosExteriores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresHorizontalesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresHorizontalesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaRuidosInterioresHorizontales", "acusticaRuidosInterioresHorizontalesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaRuidosInterioresHorizontales", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresHorizontales.header", locale)));
		metaData.getColumn("acusticaRuidosInterioresHorizontales").setGroupable(true);
		metaData.getColumn("acusticaRuidosInterioresHorizontales").setSortable(true);
		metaData.getColumn("acusticaRuidosInterioresHorizontales").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaRuidosInterioresHorizontales").setRelatedForm("AcusticaRuidosInterioresHorizontales");

		metaData.getColumn("acusticaRuidosInterioresHorizontales").setEditable(true);
		metaData.getColumn("acusticaRuidosInterioresHorizontales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaDatosGeneralesId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaDatosGeneralesLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticaDatosGenerales", "acusticaDatosGeneralesLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticaDatosGenerales", this.getMessage("forms.inspeccion.columns.acusticaDatosGenerales.header", locale)));
		metaData.getColumn("acusticaDatosGenerales").setGroupable(true);
		metaData.getColumn("acusticaDatosGenerales").setSortable(true);
		metaData.getColumn("acusticaDatosGenerales").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticaDatosGenerales").setRelatedForm("AcusticaDatosGenerales");

		metaData.getColumn("acusticaDatosGenerales").setEditable(true);
		metaData.getColumn("acusticaDatosGenerales").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acusticasId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticasLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("acusticas", "acusticasLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("acusticas", this.getMessage("forms.inspeccion.columns.acusticas.header", locale)));
		metaData.getColumn("acusticas").setGroupable(true);
		metaData.getColumn("acusticas").setSortable(true);
		metaData.getColumn("acusticas").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("acusticas").setRelatedForm("Acusticas");

		metaData.getColumn("acusticas").setEditable(true);
		metaData.getColumn("acusticas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("conservacionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("conservacionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("conservacion", "conservacionLabel", GridRecordFieldMetaData.INT_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("conservacion", this.getMessage("forms.inspeccion.columns.conservacion.header", locale)));
		metaData.getColumn("conservacion").setGroupable(true);
		metaData.getColumn("conservacion").setSortable(true);
		metaData.getColumn("conservacion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("conservacion").setRelatedForm("Conservacion");

		metaData.getColumn("conservacion").setEditable(true);
		metaData.getColumn("conservacion").setHidden(true);*/

		return metaData;
	}

	/**
	 * Devuelve los datos disponibles para la exportación
	 * 
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	public DatosExportacion getDatosExportacion(Locale locale) throws GenericBusinessException {

		DatosExportacion datosExportacion = new DatosExportacion();

		/* Configuramos el header */
		/* Informamos de los tipos de campo */

		datosExportacion.add("id", this.getMessage("forms.inspeccion.columns.id.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("informe", this.getMessage("forms.inspeccion.columns.informe.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("accesibilidadAjustesrazonablesCostes", this.getMessage("forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("conservacionDatosgeneralesArchivos", this.getMessage("forms.inspeccion.columns.conservacionDatosgeneralesArchivos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ieeCompleta", this.getMessage("forms.inspeccion.columns.ieeCompleta.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alturaSobreRasante", this.getMessage("forms.inspeccion.columns.alturaSobreRasante.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("anoConstruccion", this.getMessage("forms.inspeccion.columns.anoConstruccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("anoConstruccionReferencia", this.getMessage("forms.inspeccion.columns.anoConstruccionReferencia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("anoRehabilitacion", this.getMessage("forms.inspeccion.columns.anoRehabilitacion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("anoRehabilitacionReferencia", this.getMessage("forms.inspeccion.columns.anoRehabilitacionReferencia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("inspeccionDatosedificioNucleosescalerasTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("inspeccionDatosedificioParcelaTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("inspeccionDatosedificioUnnucleoescalerasTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("inspeccionDatosedificioUsoTipoId", this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mediaViviendasPorPlanta", this.getMessage("forms.inspeccion.columns.mediaViviendasPorPlanta.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("numAparcamientos", this.getMessage("forms.inspeccion.columns.numAparcamientos.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("numLocales", this.getMessage("forms.inspeccion.columns.numLocales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("numTrasteros", this.getMessage("forms.inspeccion.columns.numTrasteros.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("numViviendas", this.getMessage("forms.inspeccion.columns.numViviendas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("plantasBajoRasanteUsoPrincipal", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("plantasBajoRasanteUsosSecundarios", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("plantasBajoRasanteUsosSecundariosTipo", this.getMessage("forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasSobreRasanteUsoPrincipal", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("plantasSobreRasanteUsosSecundarios", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("plantasSobreRasanteUsosSecundariosTipo", this.getMessage("forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("superficieConstruida", this.getMessage("forms.inspeccion.columns.superficieConstruida.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("superficieMediaAparcamientos", this.getMessage("forms.inspeccion.columns.superficieMediaAparcamientos.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("superficieMediaLocales", this.getMessage("forms.inspeccion.columns.superficieMediaLocales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("superficieMediaTrasteros", this.getMessage("forms.inspeccion.columns.superficieMediaTrasteros.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("superficieMediaViviendas", this.getMessage("forms.inspeccion.columns.superficieMediaViviendas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("superficieParcela", this.getMessage("forms.inspeccion.columns.superficieParcela.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("totalAscensores", this.getMessage("forms.inspeccion.columns.totalAscensores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("totalEscaleras", this.getMessage("forms.inspeccion.columns.totalEscaleras.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("totalViviendasConAccesoVariosNucleos", this.getMessage("forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("totalViviendasSinAccesoAscensor", this.getMessage("forms.inspeccion.columns.totalViviendasSinAccesoAscensor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("usoTexto", this.getMessage("forms.inspeccion.columns.usoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("numero", this.getMessage("forms.inspeccion.columns.numero.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("tipoVia", this.getMessage("forms.inspeccion.columns.tipoVia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("via", this.getMessage("forms.inspeccion.columns.via.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("principal", this.getMessage("forms.inspeccion.columns.principal.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("referenciaCatastral", this.getMessage("forms.inspeccion.columns.referenciaCatastral.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioCodigoPostal", this.getMessage("forms.inspeccion.columns.edificioCodigoPostal.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioComunTexto", this.getMessage("forms.inspeccion.columns.edificioComunTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioInspeccionIdentificacionedificioComunesTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioInspeccionIdentificacionedificioObjetoTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioInspeccionPropiedadRegimenTipoId", this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioNumeroManual", this.getMessage("forms.inspeccion.columns.edificioNumeroManual.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioObjetoTexto", this.getMessage("forms.inspeccion.columns.edificioObjetoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioObservaciones", this.getMessage("forms.inspeccion.columns.edificioObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioPisoLetra", this.getMessage("forms.inspeccion.columns.edificioPisoLetra.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioPoblacion", this.getMessage("forms.inspeccion.columns.edificioPoblacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioProvincia", this.getMessage("forms.inspeccion.columns.edificioProvincia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioProvinciaId", this.getMessage("forms.inspeccion.columns.edificioProvinciaId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("edificioRegimenTexto", this.getMessage("forms.inspeccion.columns.edificioRegimenTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioTipoViaManual", this.getMessage("forms.inspeccion.columns.edificioTipoViaManual.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificioViaManual", this.getMessage("forms.inspeccion.columns.edificioViaManual.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("propiedadNif", this.getMessage("forms.inspeccion.columns.propiedadNif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("propiedadTitular", this.getMessage("forms.inspeccion.columns.propiedadTitular.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteCodigoPostal", this.getMessage("forms.inspeccion.columns.representanteCodigoPostal.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteCondicion", this.getMessage("forms.inspeccion.columns.representanteCondicion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteDireccion", this.getMessage("forms.inspeccion.columns.representanteDireccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteEmail", this.getMessage("forms.inspeccion.columns.representanteEmail.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteNif", this.getMessage("forms.inspeccion.columns.representanteNif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteNombre", this.getMessage("forms.inspeccion.columns.representanteNombre.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representantePoblacion", this.getMessage("forms.inspeccion.columns.representantePoblacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteProvincia", this.getMessage("forms.inspeccion.columns.representanteProvincia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteTelefonoFijo", this.getMessage("forms.inspeccion.columns.representanteTelefonoFijo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("representanteTelefonoMovil", this.getMessage("forms.inspeccion.columns.representanteTelefonoMovil.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnicoNif", this.getMessage("forms.inspeccion.columns.tecnicoNif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnicoTecnico", this.getMessage("forms.inspeccion.columns.tecnicoTecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnicoTitulacion", this.getMessage("forms.inspeccion.columns.tecnicoTitulacion.header", locale), TipoCampoExportacion.STRING);
		/*datosExportacion.add("accesibilidadPublicos", this.getMessage("forms.inspeccion.columns.accesibilidadPublicos.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaRuidosInterioresUniones", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresUniones.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaValoracionFinal", this.getMessage("forms.inspeccion.columns.acusticaValoracionFinal.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaRuidosInterioresVerticales", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresVerticales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaComprobaciones", this.getMessage("forms.inspeccion.columns.acusticaComprobaciones.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("instalaciones", this.getMessage("forms.inspeccion.columns.instalaciones.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("cerramientosCubiertas", this.getMessage("forms.inspeccion.columns.cerramientosCubiertas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("accesibilidadValoracionFinales", this.getMessage("forms.inspeccion.columns.accesibilidadValoracionFinales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaRuidoInstalaciones", this.getMessage("forms.inspeccion.columns.acusticaRuidoInstalaciones.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("estructura", this.getMessage("forms.inspeccion.columns.estructura.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("cimentaciones", this.getMessage("forms.inspeccion.columns.cimentaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("accesibilidadAjustesRazonables", this.getMessage("forms.inspeccion.columns.accesibilidadAjustesRazonables.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("eficienciasEnergeticas", this.getMessage("forms.inspeccion.columns.eficienciasEnergeticas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaRuidosExteriores", this.getMessage("forms.inspeccion.columns.acusticaRuidosExteriores.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaMejorasAcusticas", this.getMessage("forms.inspeccion.columns.acusticaMejorasAcusticas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaRuidosInterioresHorizontales", this.getMessage("forms.inspeccion.columns.acusticaRuidosInterioresHorizontales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticaDatosGenerales", this.getMessage("forms.inspeccion.columns.acusticaDatosGenerales.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acusticas", this.getMessage("forms.inspeccion.columns.acusticas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("conservacion", this.getMessage("forms.inspeccion.columns.conservacion.header", locale), TipoCampoExportacion.NUMBER);*/

		datosExportacion.add("dateCreation", this.getMessage("forms.general.columns.dateCreation.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("lastModified", this.getMessage("forms.general.columns.lastModified.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("creatorUser", this.getMessage("forms.general.columns.creatorUser.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("modUser", this.getMessage("forms.general.columns.modUser.header", locale), TipoCampoExportacion.STRING);

		return datosExportacion;
	}

	/**
	 * Convierte a un registro de exportación
	 **/
	@Override
	public List<String> listadoToExportRow(ListadoVO rawInstance, Locale locale) {
		InspeccionListadoVO instance = (InspeccionListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getId()));
		excelRow.add(FormData2Java.toString(instance.getInformeLabel()));
		excelRow.add(instance.getAccesibilidadAjustesrazonablesCostes());
		excelRow.add(instance.getConservacionDatosgeneralesArchivos());

		//excelRow.add(FormData2Java.toString(instance.getIeeCompleta()));

		if (instance.getIeeCompleta() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.ieeCompleta." + instance.getIeeCompleta(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(String.valueOf(instance.getAlturaSobreRasante()));
		excelRow.add(FormData2Java.toString(instance.getAnoConstruccion()));
		excelRow.add(instance.getAnoConstruccionReferencia());
		excelRow.add(FormData2Java.toString(instance.getAnoRehabilitacion()));
		excelRow.add(instance.getAnoRehabilitacionReferencia());

		//excelRow.add(FormData2Java.toString(instance.getInspeccionDatosedificioNucleosescalerasTipoId()));
		if (instance.getInspeccionDatosedificioNucleosescalerasTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId." + instance.getInspeccionDatosedificioNucleosescalerasTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getInspeccionDatosedificioParcelaTipoId()));
		if (instance.getInspeccionDatosedificioParcelaTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId." + instance.getInspeccionDatosedificioParcelaTipoId(), locale));
		} else {
			excelRow.add("null");
		}
		if (instance.getInspeccionDatosedificioUnnucleoescalerasTipoId() != null) {
			//excelRow.add(FormData2Java.toString(instance.getInspeccionDatosedificioUnnucleoescalerasTipoId()));
			excelRow.add(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId." + instance.getInspeccionDatosedificioUnnucleoescalerasTipoId(), locale));
		} else {
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getInspeccionDatosedificioUsoTipoId()));
		if (instance.getInspeccionDatosedificioUsoTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId." + instance.getInspeccionDatosedificioUsoTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(FormData2Java.toString(instance.getMediaViviendasPorPlanta()));
		excelRow.add(FormData2Java.toString(instance.getNumAparcamientos()));
		excelRow.add(FormData2Java.toString(instance.getNumLocales()));
		excelRow.add(FormData2Java.toString(instance.getNumTrasteros()));
		excelRow.add(FormData2Java.toString(instance.getNumViviendas()));
		excelRow.add(FormData2Java.toString(instance.getPlantasBajoRasanteUsoPrincipal()));
		excelRow.add(FormData2Java.toString(instance.getPlantasBajoRasanteUsosSecundarios()));
		excelRow.add(instance.getPlantasBajoRasanteUsosSecundariosTipo());
		excelRow.add(FormData2Java.toString(instance.getPlantasSobreRasanteUsoPrincipal()));
		excelRow.add(FormData2Java.toString(instance.getPlantasSobreRasanteUsosSecundarios()));
		excelRow.add(instance.getPlantasSobreRasanteUsosSecundariosTipo());
		excelRow.add(String.valueOf(instance.getSuperficieConstruida()));
		excelRow.add(String.valueOf(instance.getSuperficieMediaAparcamientos()));
		excelRow.add(String.valueOf(instance.getSuperficieMediaLocales()));
		excelRow.add(String.valueOf(instance.getSuperficieMediaTrasteros()));
		excelRow.add(String.valueOf(instance.getSuperficieMediaViviendas()));
		excelRow.add(String.valueOf(instance.getSuperficieParcela()));
		excelRow.add(instance.getTotalAscensores());
		excelRow.add(instance.getTotalEscaleras());
		excelRow.add(instance.getTotalViviendasConAccesoVariosNucleos());
		excelRow.add(instance.getTotalViviendasSinAccesoAscensor());
		excelRow.add(instance.getUsoTexto());
		excelRow.add(FormData2Java.toString(instance.getNumero()));
		excelRow.add(instance.getTipoVia());
		excelRow.add(instance.getVia());
		if (instance.getPrincipal() != null) {
			excelRow.add(instance.getPrincipal() ? "1" : "0");
		} else {
			excelRow.add("");
		}
		excelRow.add(instance.getReferenciaCatastral());
		excelRow.add(instance.getEdificioCodigoPostal());
		excelRow.add(instance.getEdificioComunTexto());
		//excelRow.add(FormData2Java.toString(instance.getEdificioInspeccionIdentificacionedificioComunesTipoId()));
		if (instance.getEdificioInspeccionIdentificacionedificioComunesTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId." + instance.getEdificioInspeccionIdentificacionedificioComunesTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEdificioInspeccionIdentificacionedificioObjetoTipoId()));
		if (instance.getEdificioInspeccionIdentificacionedificioObjetoTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId." + instance.getEdificioInspeccionIdentificacionedificioObjetoTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEdificioInspeccionPropiedadRegimenTipoId()));
		if (instance.getEdificioInspeccionPropiedadRegimenTipoId() != null) {
			excelRow.add(this.getMessage("forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId." + instance.getEdificioInspeccionPropiedadRegimenTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getEdificioNumeroManual());
		excelRow.add(instance.getEdificioObjetoTexto());
		excelRow.add(instance.getEdificioObservaciones());
		excelRow.add(instance.getEdificioPisoLetra());
		excelRow.add(instance.getEdificioPoblacion());
		excelRow.add(instance.getEdificioProvincia());
		excelRow.add(FormData2Java.toString(instance.getEdificioProvinciaId()));
		excelRow.add(instance.getEdificioRegimenTexto());
		excelRow.add(instance.getEdificioTipoViaManual());
		excelRow.add(instance.getEdificioViaManual());
		excelRow.add(instance.getPropiedadNif());
		excelRow.add(instance.getPropiedadTitular());
		excelRow.add(instance.getRepresentanteCodigoPostal());
		excelRow.add(instance.getRepresentanteCondicion());
		excelRow.add(instance.getRepresentanteDireccion());
		excelRow.add(instance.getRepresentanteEmail());
		excelRow.add(instance.getRepresentanteNif());
		excelRow.add(instance.getRepresentanteNombre());
		excelRow.add(instance.getRepresentantePoblacion());
		excelRow.add(instance.getRepresentanteProvincia());
		excelRow.add(instance.getRepresentanteTelefonoFijo());
		excelRow.add(instance.getRepresentanteTelefonoMovil());
		excelRow.add(instance.getTecnicoNif());
		excelRow.add(instance.getTecnicoTecnico());
		excelRow.add(instance.getTecnicoTitulacion());
		/*excelRow.add(FormData2Java.toString(instance.getAccesibilidadPublicosLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaRuidosInterioresUnionesLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaValoracionFinalLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaRuidosInterioresVerticalesLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaComprobacionesLabel()));
		excelRow.add(FormData2Java.toString(instance.getInstalacionesLabel()));
		excelRow.add(FormData2Java.toString(instance.getCerramientosCubiertasLabel()));
		excelRow.add(FormData2Java.toString(instance.getAccesibilidadValoracionFinalesLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaRuidoInstalacionesLabel()));
		excelRow.add(FormData2Java.toString(instance.getEstructuraLabel()));
		excelRow.add(instance.getCimentacionesLabel());
		excelRow.add(FormData2Java.toString(instance.getAccesibilidadAjustesRazonablesLabel()));
		excelRow.add(FormData2Java.toString(instance.getEficienciasEnergeticasLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaRuidosExterioresLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaMejorasAcusticasLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaRuidosInterioresHorizontalesLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticaDatosGeneralesLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcusticasLabel()));
		excelRow.add(FormData2Java.toString(instance.getConservacionLabel()));*/
		excelRow.add(FormData2Java.toString(instance.getDateCreation()));
		excelRow.add(FormData2Java.toString(instance.getLastModified()));
		excelRow.add(instance.getCreatorUser());
		excelRow.add(instance.getModUser());

		return excelRow;

	}

	@Override
	public Serializable toSerializableId(String id) {

		return FormData2Java.toInteger(id);

	}

	@Override
	public String fromSerializableId(Serializable id) {

		return FormData2Java.toString(id);

	}

	/**
	 * Rellena una instancia de InspeccionFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(InspeccionFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "informeId")) {
			formDataStr = (String) formData.get("informeId");
			record.setInformeId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("accesibilidadAjustesrazonablesCostes")) {
			formDataStr = (String) formData.get("accesibilidadAjustesrazonablesCostes");
			record.setAccesibilidadAjustesrazonablesCostes(formDataStr);
		}
		if (formData.containsKey("conservacionDatosgeneralesArchivos")) {
			formDataStr = (String) formData.get("conservacionDatosgeneralesArchivos");
			record.setConservacionDatosgeneralesArchivos(formDataStr);
		}
		if (formData.containsKey("ieeCompleta")) {
			formDataStr = (String) formData.get("ieeCompleta");
			record.setIeeCompleta(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("alturaSobreRasante")) {
			formDataStr = (String) formData.get("alturaSobreRasante");

			formDataStr = formDataStr.replace(",", ".");
			record.setAlturaSobreRasante(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("anoConstruccion")) {
			formDataStr = (String) formData.get("anoConstruccion");
			record.setAnoConstruccion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("anoConstruccionReferencia")) {
			formDataStr = (String) formData.get("anoConstruccionReferencia");
			record.setAnoConstruccionReferencia(formDataStr);
		}
		if (formData.containsKey("anoRehabilitacion")) {
			formDataStr = (String) formData.get("anoRehabilitacion");
			record.setAnoRehabilitacion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("anoRehabilitacionReferencia")) {
			formDataStr = (String) formData.get("anoRehabilitacionReferencia");
			record.setAnoRehabilitacionReferencia(formDataStr);
		}
		if (formData.containsKey("inspeccionDatosedificioNucleosescalerasTipoId")) {
			formDataStr = (String) formData.get("inspeccionDatosedificioNucleosescalerasTipoId");
			record.setInspeccionDatosedificioNucleosescalerasTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("inspeccionDatosedificioParcelaTipoId")) {
			formDataStr = (String) formData.get("inspeccionDatosedificioParcelaTipoId");
			record.setInspeccionDatosedificioParcelaTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("inspeccionDatosedificioUnnucleoescalerasTipoId")) {
			formDataStr = (String) formData.get("inspeccionDatosedificioUnnucleoescalerasTipoId");
			record.setInspeccionDatosedificioUnnucleoescalerasTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("inspeccionDatosedificioUsoTipoId")) {
			formDataStr = (String) formData.get("inspeccionDatosedificioUsoTipoId");
			record.setInspeccionDatosedificioUsoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("mediaViviendasPorPlanta")) {
			formDataStr = (String) formData.get("mediaViviendasPorPlanta");
			record.setMediaViviendasPorPlanta(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("numAparcamientos")) {
			formDataStr = (String) formData.get("numAparcamientos");
			record.setNumAparcamientos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("numLocales")) {
			formDataStr = (String) formData.get("numLocales");
			record.setNumLocales(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("numTrasteros")) {
			formDataStr = (String) formData.get("numTrasteros");
			record.setNumTrasteros(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("numViviendas")) {
			formDataStr = (String) formData.get("numViviendas");
			record.setNumViviendas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasBajoRasanteUsoPrincipal")) {
			formDataStr = (String) formData.get("plantasBajoRasanteUsoPrincipal");
			record.setPlantasBajoRasanteUsoPrincipal(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasBajoRasanteUsosSecundarios")) {
			formDataStr = (String) formData.get("plantasBajoRasanteUsosSecundarios");
			record.setPlantasBajoRasanteUsosSecundarios(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasBajoRasanteUsosSecundariosTipo")) {
			formDataStr = (String) formData.get("plantasBajoRasanteUsosSecundariosTipo");
			record.setPlantasBajoRasanteUsosSecundariosTipo(formDataStr);
		}
		if (formData.containsKey("plantasSobreRasanteUsoPrincipal")) {
			formDataStr = (String) formData.get("plantasSobreRasanteUsoPrincipal");
			record.setPlantasSobreRasanteUsoPrincipal(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasSobreRasanteUsosSecundarios")) {
			formDataStr = (String) formData.get("plantasSobreRasanteUsosSecundarios");
			record.setPlantasSobreRasanteUsosSecundarios(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasSobreRasanteUsosSecundariosTipo")) {
			formDataStr = (String) formData.get("plantasSobreRasanteUsosSecundariosTipo");
			record.setPlantasSobreRasanteUsosSecundariosTipo(formDataStr);
		}
		if (formData.containsKey("superficieConstruida")) {
			formDataStr = (String) formData.get("superficieConstruida");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieConstruida(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("superficieMediaAparcamientos")) {
			formDataStr = (String) formData.get("superficieMediaAparcamientos");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieMediaAparcamientos(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("superficieMediaLocales")) {
			formDataStr = (String) formData.get("superficieMediaLocales");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieMediaLocales(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("superficieMediaTrasteros")) {
			formDataStr = (String) formData.get("superficieMediaTrasteros");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieMediaTrasteros(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("superficieMediaViviendas")) {
			formDataStr = (String) formData.get("superficieMediaViviendas");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieMediaViviendas(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("superficieParcela")) {
			formDataStr = (String) formData.get("superficieParcela");
			formDataStr = formDataStr.replace(",", ".");
			record.setSuperficieParcela(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("totalAscensores")) {
			formDataStr = (String) formData.get("totalAscensores");
			record.setTotalAscensores(formDataStr);
		}
		if (formData.containsKey("totalEscaleras")) {
			formDataStr = (String) formData.get("totalEscaleras");
			record.setTotalEscaleras(formDataStr);
		}
		if (formData.containsKey("totalViviendasConAccesoVariosNucleos")) {
			formDataStr = (String) formData.get("totalViviendasConAccesoVariosNucleos");
			record.setTotalViviendasConAccesoVariosNucleos(formDataStr);
		}
		if (formData.containsKey("totalViviendasSinAccesoAscensor")) {
			formDataStr = (String) formData.get("totalViviendasSinAccesoAscensor");
			record.setTotalViviendasSinAccesoAscensor(formDataStr);
		}
		if (formData.containsKey("usoTexto")) {
			formDataStr = (String) formData.get("usoTexto");
			record.setUsoTexto(formDataStr);
		}
		if (formData.containsKey("numero")) {
			formDataStr = (String) formData.get("numero");
			record.setNumero(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("tipoVia")) {
			formDataStr = (String) formData.get("tipoVia");
			record.setTipoVia(formDataStr);
		}
		if (formData.containsKey("via")) {
			formDataStr = (String) formData.get("via");
			record.setVia(formDataStr);
		}
		if (formData.containsKey("principal")) {
			formDataStr = (String) formData.get("principal");
			record.setPrincipal(FormData2Java.toBoolean(formDataStr));
		}
		if (formData.containsKey("referenciaCatastral")) {
			formDataStr = (String) formData.get("referenciaCatastral");
			record.setReferenciaCatastral(formDataStr);
		}
		if (formData.containsKey("edificioCodigoPostal")) {
			formDataStr = (String) formData.get("edificioCodigoPostal");
			record.setEdificioCodigoPostal(formDataStr);
		}
		if (formData.containsKey("edificioComunTexto")) {
			formDataStr = (String) formData.get("edificioComunTexto");
			record.setEdificioComunTexto(formDataStr);
		}
		if (formData.containsKey("edificioInspeccionIdentificacionedificioComunesTipoId")) {
			formDataStr = (String) formData.get("edificioInspeccionIdentificacionedificioComunesTipoId");
			record.setEdificioInspeccionIdentificacionedificioComunesTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("edificioInspeccionIdentificacionedificioObjetoTipoId")) {
			formDataStr = (String) formData.get("edificioInspeccionIdentificacionedificioObjetoTipoId");
			record.setEdificioInspeccionIdentificacionedificioObjetoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("edificioInspeccionPropiedadRegimenTipoId")) {
			formDataStr = (String) formData.get("edificioInspeccionPropiedadRegimenTipoId");
			record.setEdificioInspeccionPropiedadRegimenTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("edificioNumeroManual")) {
			formDataStr = (String) formData.get("edificioNumeroManual");
			record.setEdificioNumeroManual(formDataStr);
		}
		if (formData.containsKey("edificioObjetoTexto")) {
			formDataStr = (String) formData.get("edificioObjetoTexto");
			record.setEdificioObjetoTexto(formDataStr);
		}
		if (formData.containsKey("edificioObservaciones")) {
			formDataStr = (String) formData.get("edificioObservaciones");
			record.setEdificioObservaciones(formDataStr);
		}
		if (formData.containsKey("edificioPisoLetra")) {
			formDataStr = (String) formData.get("edificioPisoLetra");
			record.setEdificioPisoLetra(formDataStr);
		}
		if (formData.containsKey("edificioPoblacion")) {
			formDataStr = (String) formData.get("edificioPoblacion");
			record.setEdificioPoblacion(formDataStr);
		}
		if (formData.containsKey("edificioProvincia")) {
			formDataStr = (String) formData.get("edificioProvincia");
			record.setEdificioProvincia(formDataStr);
		}
		if (formData.containsKey("edificioProvinciaId")) {
			formDataStr = (String) formData.get("edificioProvinciaId");
			record.setEdificioProvinciaId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("edificioRegimenTexto")) {
			formDataStr = (String) formData.get("edificioRegimenTexto");
			record.setEdificioRegimenTexto(formDataStr);
		}
		if (formData.containsKey("edificioTipoViaManual")) {
			formDataStr = (String) formData.get("edificioTipoViaManual");
			record.setEdificioTipoViaManual(formDataStr);
		}
		if (formData.containsKey("edificioViaManual")) {
			formDataStr = (String) formData.get("edificioViaManual");
			record.setEdificioViaManual(formDataStr);
		}
		if (formData.containsKey("propiedadNif")) {
			formDataStr = (String) formData.get("propiedadNif");
			record.setPropiedadNif(formDataStr);
		}
		if (formData.containsKey("propiedadTitular")) {
			formDataStr = (String) formData.get("propiedadTitular");
			record.setPropiedadTitular(formDataStr);
		}
		if (formData.containsKey("representanteCodigoPostal")) {
			formDataStr = (String) formData.get("representanteCodigoPostal");
			record.setRepresentanteCodigoPostal(formDataStr);
		}
		if (formData.containsKey("representanteCondicion")) {
			formDataStr = (String) formData.get("representanteCondicion");
			record.setRepresentanteCondicion(formDataStr);
		}
		if (formData.containsKey("representanteDireccion")) {
			formDataStr = (String) formData.get("representanteDireccion");
			record.setRepresentanteDireccion(formDataStr);
		}
		if (formData.containsKey("representanteEmail")) {
			formDataStr = (String) formData.get("representanteEmail");
			record.setRepresentanteEmail(formDataStr);
		}
		if (formData.containsKey("representanteNif")) {
			formDataStr = (String) formData.get("representanteNif");
			record.setRepresentanteNif(formDataStr);
		}
		if (formData.containsKey("representanteNombre")) {
			formDataStr = (String) formData.get("representanteNombre");
			record.setRepresentanteNombre(formDataStr);
		}
		if (formData.containsKey("representantePoblacion")) {
			formDataStr = (String) formData.get("representantePoblacion");
			record.setRepresentantePoblacion(formDataStr);
		}
		if (formData.containsKey("representanteProvincia")) {
			formDataStr = (String) formData.get("representanteProvincia");
			record.setRepresentanteProvincia(formDataStr);
		}
		if (formData.containsKey("representanteTelefonoFijo")) {
			formDataStr = (String) formData.get("representanteTelefonoFijo");
			record.setRepresentanteTelefonoFijo(formDataStr);
		}
		if (formData.containsKey("representanteTelefonoMovil")) {
			formDataStr = (String) formData.get("representanteTelefonoMovil");
			record.setRepresentanteTelefonoMovil(formDataStr);
		}
		if (formData.containsKey("tecnicoNif")) {
			formDataStr = (String) formData.get("tecnicoNif");
			record.setTecnicoNif(formDataStr);
		}
		if (formData.containsKey("tecnicoTecnico")) {
			formDataStr = (String) formData.get("tecnicoTecnico");
			record.setTecnicoTecnico(formDataStr);
		}
		if (formData.containsKey("tecnicoTitulacion")) {
			formDataStr = (String) formData.get("tecnicoTitulacion");
			record.setTecnicoTitulacion(formDataStr);
		}
		if (!StringUtils.isEmpty(formData, "accesibilidadPublicosId")) {
			formDataStr = (String) formData.get("accesibilidadPublicosId");
			record.setAccesibilidadPublicosId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaRuidosInterioresUnionesId")) {
			formDataStr = (String) formData.get("acusticaRuidosInterioresUnionesId");
			record.setAcusticaRuidosInterioresUnionesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaValoracionFinalId")) {
			formDataStr = (String) formData.get("acusticaValoracionFinalId");
			record.setAcusticaValoracionFinalId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaRuidosInterioresVerticalesId")) {
			formDataStr = (String) formData.get("acusticaRuidosInterioresVerticalesId");
			record.setAcusticaRuidosInterioresVerticalesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaComprobacionesId")) {
			formDataStr = (String) formData.get("acusticaComprobacionesId");
			record.setAcusticaComprobacionesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "instalacionesId")) {
			formDataStr = (String) formData.get("instalacionesId");
			record.setInstalacionesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "cerramientosCubiertasId")) {
			formDataStr = (String) formData.get("cerramientosCubiertasId");
			record.setCerramientosCubiertasId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "accesibilidadValoracionFinalesId")) {
			formDataStr = (String) formData.get("accesibilidadValoracionFinalesId");
			record.setAccesibilidadValoracionFinalesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaRuidoInstalacionesId")) {
			formDataStr = (String) formData.get("acusticaRuidoInstalacionesId");
			record.setAcusticaRuidoInstalacionesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "estructuraId")) {
			formDataStr = (String) formData.get("estructuraId");
			record.setEstructuraId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "cimentacionesId")) {
			formDataStr = (String) formData.get("cimentacionesId");
			record.setCimentacionesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "accesibilidadAjustesRazonablesId")) {
			formDataStr = (String) formData.get("accesibilidadAjustesRazonablesId");
			record.setAccesibilidadAjustesRazonablesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "eficienciasEnergeticasId")) {
			formDataStr = (String) formData.get("eficienciasEnergeticasId");
			record.setEficienciasEnergeticasId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaRuidosExterioresId")) {
			formDataStr = (String) formData.get("acusticaRuidosExterioresId");
			record.setAcusticaRuidosExterioresId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaRuidosInterioresHorizontalesId")) {
			formDataStr = (String) formData.get("acusticaRuidosInterioresHorizontalesId");
			record.setAcusticaRuidosInterioresHorizontalesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticaDatosGeneralesId")) {
			formDataStr = (String) formData.get("acusticaDatosGeneralesId");
			record.setAcusticaDatosGeneralesId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "acusticasId")) {
			formDataStr = (String) formData.get("acusticasId");
			record.setAcusticasId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("valores")) {
			formDataStr = (String) formData.get("valores");
			if (!StringUtils.isEmpty(formDataStr)) {
				String[] ids = formDataStr.split(",");
				Set<ValorListadoVO> elements = new HashSet<ValorListadoVO>();
				ValorListadoVO element = null;
				for (String id : ids) {
					element = new ValorListadoVO();
					element.setId(ValorId.fromString(id));
					elements.add(element);
				}
				record.setValores(elements);
			} else {
				record.setValores(new HashSet<ValorListadoVO>());
			}

		}
		if (!StringUtils.isEmpty(formData, "conservacionId")) {
			formDataStr = (String) formData.get("conservacionId");
			record.setConservacionId(FormData2Java.toInteger(formDataStr));

		}
	}

	/**
	 * Rellena una instancia de FechaVisitaFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(FechaVisitaFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("fecha")) {
			formDataStr = (String) formData.get("fecha");
			record.setFecha(formDataStr);
		}
	}

	/**
	 * Rellena una instancia de ValoracionParcialFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(ValoracionParcialFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("conservacionSistemasconstructivosTipoId")) {
			formDataStr = (String) formData.get("conservacionSistemasconstructivosTipoId");
			record.setConservacionSistemasconstructivosTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("conservacionValoracionesTipoId")) {
			formDataStr = (String) formData.get("conservacionValoracionesTipoId");
			record.setConservacionValoracionesTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plazoFinObras")) {
			formDataStr = (String) formData.get("plazoFinObras");
			record.setPlazoFinObras(formDataStr);
		}
		if (formData.containsKey("plazoInicioObras")) {
			formDataStr = (String) formData.get("plazoInicioObras");
			record.setPlazoInicioObras(formDataStr);
		}
	}

	/**
	 * Rellena una instancia de DocumentacionOtroFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(DocumentacionOtroFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("texto")) {
			formDataStr = (String) formData.get("texto");
			record.setTexto(formDataStr);
		}
	}

	/**
	 * Rellena una instancia de DeficienciaFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(DeficienciaFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "deficienciaTipoId")) {
			formDataStr = (String) formData.get("deficienciaTipoId");
			record.setDeficienciaTipoId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("conservacionSistemasconstructivosTipoId")) {
			formDataStr = (String) formData.get("conservacionSistemasconstructivosTipoId");
			record.setConservacionSistemasconstructivosTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("descripcionDeficiencia")) {
			formDataStr = (String) formData.get("descripcionDeficiencia");
			record.setDescripcionDeficiencia(formDataStr);
		}
		if (formData.containsKey("esGrave")) {
			formDataStr = (String) formData.get("esGrave");
			record.setEsGrave(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("localizacionDeficiencia")) {
			formDataStr = (String) formData.get("localizacionDeficiencia");
			record.setLocalizacionDeficiencia(formDataStr);
		}
		if (formData.containsKey("nombreDeficiencia")) {
			formDataStr = (String) formData.get("nombreDeficiencia");
			record.setNombreDeficiencia(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("pruebasEnsayosRealizados")) {
			formDataStr = (String) formData.get("pruebasEnsayosRealizados");
			record.setPruebasEnsayosRealizados(formDataStr);
		}
	}

	/**
	 * Rellena una instancia de HistoricoFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(HistoricoFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("fechaInspeccion")) {
			formDataStr = (String) formData.get("fechaInspeccion");
			record.setFechaInspeccion(formDataStr);
		}
		if (formData.containsKey("gradoEjecucionEfectividadObras")) {
			formDataStr = (String) formData.get("gradoEjecucionEfectividadObras");
			record.setGradoEjecucionEfectividadObras(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("resultado")) {
			formDataStr = (String) formData.get("resultado");
			record.setResultado(formDataStr);
		}
		if (formData.containsKey("tecnico")) {
			formDataStr = (String) formData.get("tecnico");
			record.setTecnico(formDataStr);
		}
	}

	@Override
	public ResultadoActualizacion addSubForm(Map<String, ?> formData, String id, String subFormName, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		InspeccionFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		//Comprueba permisos de alta
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("fechasVisitas")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			FechaVisitaFormVO newRecord = new FechaVisitaFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setInspeccionId(instance.getId());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.fechaVisitaBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getId()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		if (subFormName.equals("valoracionesParciales")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ValoracionParcialFormVO newRecord = new ValoracionParcialFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setInspeccionId(instance.getId());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.valoracionParcialBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getId()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		if (subFormName.equals("documentacionOtros")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			DocumentacionOtroFormVO newRecord = new DocumentacionOtroFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setInspeccionId(instance.getId());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.documentacionOtroBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getId()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		if (subFormName.equals("deficiencias")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			DeficienciaFormVO newRecord = new DeficienciaFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setInspeccionId(instance.getId());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.deficienciaBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getId()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		if (subFormName.equals("historicos")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			HistoricoFormVO newRecord = new HistoricoFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setInspeccionId(instance.getId());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.historicoBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getId()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		return super.addSubForm(formData, id, subFormName, usuari, locale);

	}

	@Override
	public ResultadoActualizacion deleteSubForm(String id, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		InspeccionFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("fechasVisitas")) {
			FechaVisitaFormVO recordToDelete = this.fechaVisitaBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToDelete.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.fechaVisitaBO.delete(recordToDelete.getId());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		if (subFormName.equals("valoracionesParciales")) {
			ValoracionParcialFormVO recordToDelete = this.valoracionParcialBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToDelete.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.valoracionParcialBO.delete(recordToDelete.getId());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		if (subFormName.equals("documentacionOtros")) {
			DocumentacionOtroFormVO recordToDelete = this.documentacionOtroBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToDelete.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.documentacionOtroBO.delete(recordToDelete.getId());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		if (subFormName.equals("deficiencias")) {
			DeficienciaFormVO recordToDelete = this.deficienciaBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToDelete.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.deficienciaBO.delete(recordToDelete.getId());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		if (subFormName.equals("historicos")) {
			HistoricoFormVO recordToDelete = this.historicoBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToDelete.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.historicoBO.delete(recordToDelete.getId());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		return super.deleteSubForm(id, subFormName, subId, usuari, locale);

	}

	@Override
	public ResultadoActualizacion updateSubForm(String id, Map<String, ?> formData, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		InspeccionFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		//Comprueba permisos de actualización
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("fechasVisitas")) {
			FechaVisitaFormVO recordToUpdate = this.fechaVisitaBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToUpdate.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = fechaVisitaBO.update(recordToUpdate.getId(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		if (subFormName.equals("valoracionesParciales")) {
			ValoracionParcialFormVO recordToUpdate = this.valoracionParcialBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToUpdate.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = valoracionParcialBO.update(recordToUpdate.getId(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		if (subFormName.equals("documentacionOtros")) {
			DocumentacionOtroFormVO recordToUpdate = this.documentacionOtroBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToUpdate.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = documentacionOtroBO.update(recordToUpdate.getId(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		if (subFormName.equals("deficiencias")) {
			DeficienciaFormVO recordToUpdate = this.deficienciaBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToUpdate.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = deficienciaBO.update(recordToUpdate.getId(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		if (subFormName.equals("historicos")) {
			HistoricoFormVO recordToUpdate = this.historicoBO.load(FormData2Java.toLong(subId));
			if (!((Serializable) recordToUpdate.getInspeccionId()).equals(instance.getId())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = historicoBO.update(recordToUpdate.getId(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		return super.updateSubForm(id, formData, subFormName, subId, usuari, locale);

	}
}
