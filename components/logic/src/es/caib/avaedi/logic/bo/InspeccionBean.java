package es.caib.avaedi.logic.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.TransferObjectCreateException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.common.model.Edificio;
import es.caib.avaedi.common.model.Inspeccion;
import es.caib.avaedi.common.persistence.AccesibilidadAjustesRazonablesDao;
import es.caib.avaedi.common.persistence.AccesibilidadPublicosDao;
import es.caib.avaedi.common.persistence.AccesibilidadValoracionFinalesDao;
import es.caib.avaedi.common.persistence.AcusticaComprobacionesDao;
import es.caib.avaedi.common.persistence.AcusticaDatosGeneralesDao;
import es.caib.avaedi.common.persistence.AcusticaMejorasAcusticasDao;
import es.caib.avaedi.common.persistence.AcusticaRuidoInstalacionesDao;
import es.caib.avaedi.common.persistence.AcusticaRuidosExterioresDao;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresHorizontalesDao;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresUnionesDao;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresVerticalesDao;
import es.caib.avaedi.common.persistence.AcusticaValoracionFinalDao;
import es.caib.avaedi.common.persistence.AcusticasDao;
import es.caib.avaedi.common.persistence.CerramientosCubiertasDao;
import es.caib.avaedi.common.persistence.CimentacionesDao;
import es.caib.avaedi.common.persistence.ConservacionDao;
import es.caib.avaedi.common.persistence.EficienciasEnergeticasDao;
import es.caib.avaedi.common.persistence.EstructuraDao;
import es.caib.avaedi.common.persistence.InformeDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.common.persistence.InstalacionesDao;
import es.caib.avaedi.common.persistence.ValorDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.DeficienciaListadoVO;
import es.caib.avaedi.logic.vo.DocumentacionOtroListadoVO;
import es.caib.avaedi.logic.vo.FechaVisitaListadoVO;
import es.caib.avaedi.logic.vo.HistoricoListadoVO;
import es.caib.avaedi.logic.vo.InspeccionFormVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;
import es.caib.avaedi.logic.vo.ValorListadoVO;
import es.caib.avaedi.logic.vo.ValoracionParcialListadoVO;

/**
 * Bean negocio para tratar el formulario: Inspeccion
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("InspeccionBean")
public class InspeccionBean extends BaseBean<Inspeccion, InspeccionListadoVO, InspeccionFormVO> implements InspeccionBO {

	public InspeccionBean() { 
		super(Inspeccion.class, InspeccionListadoVO.class, InspeccionFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Inspeccion
	 */
	@Autowired
	@Qualifier("InspeccionDao")
	protected InspeccionDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Inspeccion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected InspeccionDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Informe
	 */
	@Autowired
	@Qualifier("InformeDao")
	protected InformeDao informeDao;

	/**
	 * DAO para acceder al modelo: Informe
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setInformeDao(InformeDao dao) {
		this.informeDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AccesibilidadPublicos
	 */
	@Autowired
	@Qualifier("AccesibilidadPublicosDao")
	protected AccesibilidadPublicosDao accesibilidadPublicosDao;

	/**
	 * DAO para acceder al modelo: AccesibilidadPublicos
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAccesibilidadPublicosDao(AccesibilidadPublicosDao dao) {
		this.accesibilidadPublicosDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresUniones
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresUnionesDao")
	protected AcusticaRuidosInterioresUnionesDao acusticaRuidosInterioresUnionesDao;

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresUniones
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaRuidosInterioresUnionesDao(AcusticaRuidosInterioresUnionesDao dao) {
		this.acusticaRuidosInterioresUnionesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaValoracionFinal
	 */
	@Autowired
	@Qualifier("AcusticaValoracionFinalDao")
	protected AcusticaValoracionFinalDao acusticaValoracionFinalDao;

	/**
	 * DAO para acceder al modelo: AcusticaValoracionFinal
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaValoracionFinalDao(AcusticaValoracionFinalDao dao) {
		this.acusticaValoracionFinalDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresVerticales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresVerticalesDao")
	protected AcusticaRuidosInterioresVerticalesDao acusticaRuidosInterioresVerticalesDao;

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresVerticales
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaRuidosInterioresVerticalesDao(AcusticaRuidosInterioresVerticalesDao dao) {
		this.acusticaRuidosInterioresVerticalesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaComprobaciones
	 */
	@Autowired
	@Qualifier("AcusticaComprobacionesDao")
	protected AcusticaComprobacionesDao acusticaComprobacionesDao;

	/**
	 * DAO para acceder al modelo: AcusticaComprobaciones
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaComprobacionesDao(AcusticaComprobacionesDao dao) {
		this.acusticaComprobacionesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Instalaciones
	 */
	@Autowired
	@Qualifier("InstalacionesDao")
	protected InstalacionesDao instalacionesDao;

	/**
	 * DAO para acceder al modelo: Instalaciones
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setInstalacionesDao(InstalacionesDao dao) {
		this.instalacionesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: CerramientosCubiertas
	 */
	@Autowired
	@Qualifier("CerramientosCubiertasDao")
	protected CerramientosCubiertasDao cerramientosCubiertasDao;

	/**
	 * DAO para acceder al modelo: CerramientosCubiertas
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setCerramientosCubiertasDao(CerramientosCubiertasDao dao) {
		this.cerramientosCubiertasDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AccesibilidadValoracionFinales
	 */
	@Autowired
	@Qualifier("AccesibilidadValoracionFinalesDao")
	protected AccesibilidadValoracionFinalesDao accesibilidadValoracionFinalesDao;

	/**
	 * DAO para acceder al modelo: AccesibilidadValoracionFinales
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAccesibilidadValoracionFinalesDao(AccesibilidadValoracionFinalesDao dao) {
		this.accesibilidadValoracionFinalesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaRuidoInstalaciones
	 */
	@Autowired
	@Qualifier("AcusticaRuidoInstalacionesDao")
	protected AcusticaRuidoInstalacionesDao acusticaRuidoInstalacionesDao;

	/**
	 * DAO para acceder al modelo: AcusticaRuidoInstalaciones
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaRuidoInstalacionesDao(AcusticaRuidoInstalacionesDao dao) {
		this.acusticaRuidoInstalacionesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Estructura
	 */
	@Autowired
	@Qualifier("EstructuraDao")
	protected EstructuraDao estructuraDao;

	/**
	 * DAO para acceder al modelo: Estructura
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setEstructuraDao(EstructuraDao dao) {
		this.estructuraDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Cimentaciones
	 */
	@Autowired
	@Qualifier("CimentacionesDao")
	protected CimentacionesDao cimentacionesDao;

	/**
	 * DAO para acceder al modelo: Cimentaciones
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setCimentacionesDao(CimentacionesDao dao) {
		this.cimentacionesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AccesibilidadAjustesRazonables
	 */
	@Autowired
	@Qualifier("AccesibilidadAjustesRazonablesDao")
	protected AccesibilidadAjustesRazonablesDao accesibilidadAjustesRazonablesDao;

	/**
	 * DAO para acceder al modelo: AccesibilidadAjustesRazonables
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAccesibilidadAjustesRazonablesDao(AccesibilidadAjustesRazonablesDao dao) {
		this.accesibilidadAjustesRazonablesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: EficienciasEnergeticas
	 */
	@Autowired
	@Qualifier("EficienciasEnergeticasDao")
	protected EficienciasEnergeticasDao eficienciasEnergeticasDao;

	/**
	 * DAO para acceder al modelo: EficienciasEnergeticas
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setEficienciasEnergeticasDao(EficienciasEnergeticasDao dao) {
		this.eficienciasEnergeticasDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaRuidosExteriores
	 */
	@Autowired
	@Qualifier("AcusticaRuidosExterioresDao")
	protected AcusticaRuidosExterioresDao acusticaRuidosExterioresDao;

	/**
	 * DAO para acceder al modelo: AcusticaRuidosExteriores
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaRuidosExterioresDao(AcusticaRuidosExterioresDao dao) {
		this.acusticaRuidosExterioresDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaMejorasAcusticas
	 */
	@Autowired
	@Qualifier("AcusticaMejorasAcusticasDao")
	protected AcusticaMejorasAcusticasDao acusticaMejorasAcusticasDao;

	/**
	 * DAO para acceder al modelo: AcusticaMejorasAcusticas
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaMejorasAcusticasDao(AcusticaMejorasAcusticasDao dao) {
		this.acusticaMejorasAcusticasDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresHorizontales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresHorizontalesDao")
	protected AcusticaRuidosInterioresHorizontalesDao acusticaRuidosInterioresHorizontalesDao;

	/**
	 * DAO para acceder al modelo: AcusticaRuidosInterioresHorizontales
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaRuidosInterioresHorizontalesDao(AcusticaRuidosInterioresHorizontalesDao dao) {
		this.acusticaRuidosInterioresHorizontalesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: AcusticaDatosGenerales
	 */
	@Autowired
	@Qualifier("AcusticaDatosGeneralesDao")
	protected AcusticaDatosGeneralesDao acusticaDatosGeneralesDao;

	/**
	 * DAO para acceder al modelo: AcusticaDatosGenerales
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticaDatosGeneralesDao(AcusticaDatosGeneralesDao dao) {
		this.acusticaDatosGeneralesDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Acusticas
	 */
	@Autowired
	@Qualifier("AcusticasDao")
	protected AcusticasDao acusticasDao;

	/**
	 * DAO para acceder al modelo: Acusticas
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setAcusticasDao(AcusticasDao dao) {
		this.acusticasDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Valor
	 */
	@Autowired
	@Qualifier("ValorDao")
	protected ValorDao valorDao;

	/**
	 * DAO para acceder al modelo: Valor
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setValorDao(ValorDao dao) {
		this.valorDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Conservacion
	 */
	@Autowired
	@Qualifier("ConservacionDao")
	protected ConservacionDao conservacionDao;

	/**
	 * DAO para acceder al modelo: Conservacion
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setConservacionDao(ConservacionDao dao) {
		this.conservacionDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId) throws GenericBusinessException {
		return this.findByInforme(informeId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInforme(informeId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "informe.clave", FormData2Java.toString(informeId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId) throws GenericBusinessException {
		return this.findByAccesibilidadPublicos(accesibilidadPublicosId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAccesibilidadPublicos(accesibilidadPublicosId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "accesibilidadPublicos.claveInforme", FormData2Java.toString(accesibilidadPublicosId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresUniones(acusticaRuidosInterioresUnionesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresUniones(acusticaRuidosInterioresUnionesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaRuidosInterioresUniones.claveInforme", FormData2Java.toString(acusticaRuidosInterioresUnionesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId) throws GenericBusinessException {
		return this.findByAcusticaValoracionFinal(acusticaValoracionFinalId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaValoracionFinal(acusticaValoracionFinalId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaValoracionFinal.claveInforme", FormData2Java.toString(acusticaValoracionFinalId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresVerticales(acusticaRuidosInterioresVerticalesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresVerticales(acusticaRuidosInterioresVerticalesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaRuidosInterioresVerticales.claveInforme", FormData2Java.toString(acusticaRuidosInterioresVerticalesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId) throws GenericBusinessException {
		return this.findByAcusticaComprobaciones(acusticaComprobacionesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaComprobaciones(acusticaComprobacionesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaComprobaciones.claveInforme", FormData2Java.toString(acusticaComprobacionesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId) throws GenericBusinessException {
		return this.findByInstalaciones(instalacionesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInstalaciones(instalacionesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "instalaciones.claveInforme", FormData2Java.toString(instalacionesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId) throws GenericBusinessException {
		return this.findByCerramientosCubiertas(cerramientosCubiertasId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByCerramientosCubiertas(cerramientosCubiertasId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "cerramientosCubiertas.claveInforme", FormData2Java.toString(cerramientosCubiertasId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId) throws GenericBusinessException {
		return this.findByAccesibilidadValoracionFinales(accesibilidadValoracionFinalesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAccesibilidadValoracionFinales(accesibilidadValoracionFinalesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "accesibilidadValoracionFinales.claveInforme", FormData2Java.toString(accesibilidadValoracionFinalesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId) throws GenericBusinessException {
		return this.findByAcusticaRuidoInstalaciones(acusticaRuidoInstalacionesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaRuidoInstalaciones(acusticaRuidoInstalacionesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaRuidoInstalaciones.claveInforme", FormData2Java.toString(acusticaRuidoInstalacionesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId) throws GenericBusinessException {
		return this.findByEstructura(estructuraId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByEstructura(estructuraId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "estructura.claveInforme", FormData2Java.toString(estructuraId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId) throws GenericBusinessException {
		return this.findByCimentaciones(cimentacionesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByCimentaciones(cimentacionesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "cimentaciones.claveInforme", FormData2Java.toString(cimentacionesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId) throws GenericBusinessException {
		return this.findByAccesibilidadAjustesRazonables(accesibilidadAjustesRazonablesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAccesibilidadAjustesRazonables(accesibilidadAjustesRazonablesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "accesibilidadAjustesRazonables.claveInforme", FormData2Java.toString(accesibilidadAjustesRazonablesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId) throws GenericBusinessException {
		return this.findByEficienciasEnergeticas(eficienciasEnergeticasId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByEficienciasEnergeticas(eficienciasEnergeticasId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "eficienciasEnergeticas.claveInforme", FormData2Java.toString(eficienciasEnergeticasId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId) throws GenericBusinessException {
		return this.findByAcusticaRuidosExteriores(acusticaRuidosExterioresId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaRuidosExteriores(acusticaRuidosExterioresId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaRuidosExteriores.claveInforme", FormData2Java.toString(acusticaRuidosExterioresId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId) throws GenericBusinessException {
		return this.findByAcusticaMejorasAcusticas(acusticaMejorasAcusticasId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaMejorasAcusticas(acusticaMejorasAcusticasId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaMejorasAcusticas.claveInforme", FormData2Java.toString(acusticaMejorasAcusticasId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresHorizontales(acusticaRuidosInterioresHorizontalesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaRuidosInterioresHorizontales(acusticaRuidosInterioresHorizontalesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaRuidosInterioresHorizontales.claveInforme", FormData2Java.toString(acusticaRuidosInterioresHorizontalesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId) throws GenericBusinessException {
		return this.findByAcusticaDatosGenerales(acusticaDatosGeneralesId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticaDatosGenerales(acusticaDatosGeneralesId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticaDatosGenerales.claveInforme", FormData2Java.toString(acusticaDatosGeneralesId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId) throws GenericBusinessException {
		return this.findByAcusticas(acusticasId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByAcusticas(acusticasId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "acusticas.claveInforme", FormData2Java.toString(acusticasId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId) throws GenericBusinessException {
		return this.findByConservacion(conservacionId, null, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByConservacion(conservacionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "conservacion.claveInforme", FormData2Java.toString(conservacionId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de Inspeccion con los datos recibidos de la capa de
	 * servicio
	 */
	protected Inspeccion setFormData(InspeccionFormVO formData, Inspeccion record) throws GenericBusinessException {

		if (record == null) {
			record = new Inspeccion();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "historicos", "conservacion", "valores", "deficiencias", "acusticas", "acusticaDatosGenerales", "acusticaRuidosInterioresHorizontales", "acusticaMejorasAcusticas", "acusticaRuidosExteriores", "documentacionOtros", "eficienciasEnergeticas", "accesibilidadAjustesRazonables", "cimentaciones", "estructura", "acusticaRuidoInstalaciones", "accesibilidadValoracionFinales", "valoracionesParciales", "cerramientosCubiertas", "instalaciones", "acusticaComprobaciones", "acusticaRuidosInterioresVerticales", "acusticaValoracionFinal", "fechasVisitas", "acusticaRuidosInterioresUniones", "accesibilidadPublicos", "informe" });

			//----- Relacion Informe
			record.setInforme(this.informeDao.findById(formData.getInformeId()));

			//----- Relacion AccesibilidadPublicos
			record.setAccesibilidadPublicos(this.accesibilidadPublicosDao.findById(formData.getAccesibilidadPublicosId()));

			//----- Relacion AcusticaRuidosInterioresUniones
			record.setAcusticaRuidosInterioresUniones(this.acusticaRuidosInterioresUnionesDao.findById(formData.getAcusticaRuidosInterioresUnionesId()));

			//----- Relacion AcusticaValoracionFinal
			record.setAcusticaValoracionFinal(this.acusticaValoracionFinalDao.findById(formData.getAcusticaValoracionFinalId()));

			//----- Relacion AcusticaRuidosInterioresVerticales
			record.setAcusticaRuidosInterioresVerticales(this.acusticaRuidosInterioresVerticalesDao.findById(formData.getAcusticaRuidosInterioresVerticalesId()));

			//----- Relacion AcusticaComprobaciones
			record.setAcusticaComprobaciones(this.acusticaComprobacionesDao.findById(formData.getAcusticaComprobacionesId()));

			//----- Relacion Instalaciones
			record.setInstalaciones(this.instalacionesDao.findById(formData.getInstalacionesId()));

			//----- Relacion CerramientosCubiertas
			record.setCerramientosCubiertas(this.cerramientosCubiertasDao.findById(formData.getCerramientosCubiertasId()));

			//----- Relacion AccesibilidadValoracionFinales
			record.setAccesibilidadValoracionFinales(this.accesibilidadValoracionFinalesDao.findById(formData.getAccesibilidadValoracionFinalesId()));

			//----- Relacion AcusticaRuidoInstalaciones
			record.setAcusticaRuidoInstalaciones(this.acusticaRuidoInstalacionesDao.findById(formData.getAcusticaRuidoInstalacionesId()));

			//----- Relacion Estructura
			record.setEstructura(this.estructuraDao.findById(formData.getEstructuraId()));

			//----- Relacion Cimentaciones
			record.setCimentaciones(this.cimentacionesDao.findById(formData.getCimentacionesId()));

			//----- Relacion AccesibilidadAjustesRazonables
			record.setAccesibilidadAjustesRazonables(this.accesibilidadAjustesRazonablesDao.findById(formData.getAccesibilidadAjustesRazonablesId()));

			//----- Relacion EficienciasEnergeticas
			record.setEficienciasEnergeticas(this.eficienciasEnergeticasDao.findById(formData.getEficienciasEnergeticasId()));

			//----- Relacion AcusticaRuidosExteriores
			record.setAcusticaRuidosExteriores(this.acusticaRuidosExterioresDao.findById(formData.getAcusticaRuidosExterioresId()));

			//----- Relacion AcusticaRuidosInterioresHorizontales
			record.setAcusticaRuidosInterioresHorizontales(this.acusticaRuidosInterioresHorizontalesDao.findById(formData.getAcusticaRuidosInterioresHorizontalesId()));

			//----- Relacion AcusticaDatosGenerales
			record.setAcusticaDatosGenerales(this.acusticaDatosGeneralesDao.findById(formData.getAcusticaDatosGeneralesId()));

			//----- Relacion Acusticas
			record.setAcusticas(this.acusticasDao.findById(formData.getAcusticasId()));

			//----- Relacion Valores
			//Eliminamos todos los relacionados
			if (formData.getValores() != null) {
				record.getValores().clear();
				for (ValorListadoVO instanceVO : formData.getValores()) {
					record.getValores().add(this.valorDao.findById(instanceVO.getId()));
				}
			}

			//----- Relacion Conservacion
			record.setConservacion(this.conservacionDao.findById(formData.getConservacionId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Inspeccion, InspeccionListadoVO> {

		@Override
		public InspeccionListadoVO transform(Inspeccion instance, InspeccionListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "conservacion", "acusticas", "acusticaDatosGenerales", "acusticaRuidosInterioresHorizontales", "acusticaMejorasAcusticas", "acusticaRuidosExteriores", "eficienciasEnergeticas", "accesibilidadAjustesRazonables", "cimentaciones", "estructura", "acusticaRuidoInstalaciones", "accesibilidadValoracionFinales", "cerramientosCubiertas", "instalaciones", "acusticaComprobaciones", "acusticaRuidosInterioresVerticales", "acusticaValoracionFinal", "acusticaRuidosInterioresUniones", "accesibilidadPublicos", "informe", "historicos", "valores", "deficiencias", "documentacionOtros", "valoracionesParciales", "fechasVisitas" });

				if (instance.getInforme() != null) {
					ret.setInformeId(instance.getInforme().getClave());
					ret.setInformeLabel(FormData2Java.toString(instance.getInforme().getClave()));
					ret.setMunicipioId(instance.getInforme().getEdificio().getVia().getMunicipio().getClave());
					ret.setMunicipioLabel(instance.getInforme().getEdificio().getVia().getMunicipio().getNombre());
				}
				if (instance.getAccesibilidadPublicos() != null) {
					ret.setAccesibilidadPublicosId(instance.getAccesibilidadPublicos().getClaveInforme());
					ret.setAccesibilidadPublicosLabel(FormData2Java.toString(instance.getAccesibilidadPublicos().getClaveInforme()));
				}
				if (instance.getAcusticaRuidosInterioresUniones() != null) {
					ret.setAcusticaRuidosInterioresUnionesId(instance.getAcusticaRuidosInterioresUniones().getClaveInforme());
					ret.setAcusticaRuidosInterioresUnionesLabel(FormData2Java.toString(instance.getAcusticaRuidosInterioresUniones().getClaveInforme()));
				}
				if (instance.getAcusticaValoracionFinal() != null) {
					ret.setAcusticaValoracionFinalId(instance.getAcusticaValoracionFinal().getClaveInforme());
					ret.setAcusticaValoracionFinalLabel(FormData2Java.toString(instance.getAcusticaValoracionFinal().getClaveInforme()));
				}
				if (instance.getAcusticaRuidosInterioresVerticales() != null) {
					ret.setAcusticaRuidosInterioresVerticalesId(instance.getAcusticaRuidosInterioresVerticales().getClaveInforme());
					ret.setAcusticaRuidosInterioresVerticalesLabel(FormData2Java.toString(instance.getAcusticaRuidosInterioresVerticales().getClaveInforme()));
				}
				if (instance.getAcusticaComprobaciones() != null) {
					ret.setAcusticaComprobacionesId(instance.getAcusticaComprobaciones().getClaveInforme());
					ret.setAcusticaComprobacionesLabel(FormData2Java.toString(instance.getAcusticaComprobaciones().getClaveInforme()));
				}
				if (instance.getInstalaciones() != null) {
					ret.setInstalacionesId(instance.getInstalaciones().getClaveInforme());
					ret.setInstalacionesLabel(FormData2Java.toString(instance.getInstalaciones().getClaveInforme()));
				}
				if (instance.getCerramientosCubiertas() != null) {
					ret.setCerramientosCubiertasId(instance.getCerramientosCubiertas().getClaveInforme());
					ret.setCerramientosCubiertasLabel(FormData2Java.toString(instance.getCerramientosCubiertas().getClaveInforme()));
				}
				if (instance.getAccesibilidadValoracionFinales() != null) {
					ret.setAccesibilidadValoracionFinalesId(instance.getAccesibilidadValoracionFinales().getClaveInforme());
					ret.setAccesibilidadValoracionFinalesLabel(FormData2Java.toString(instance.getAccesibilidadValoracionFinales().getClaveInforme()));
				}
				if (instance.getAcusticaRuidoInstalaciones() != null) {
					ret.setAcusticaRuidoInstalacionesId(instance.getAcusticaRuidoInstalaciones().getClaveInforme());
					ret.setAcusticaRuidoInstalacionesLabel(FormData2Java.toString(instance.getAcusticaRuidoInstalaciones().getClaveInforme()));
				}
				if (instance.getEstructura() != null) {
					ret.setEstructuraId(instance.getEstructura().getClaveInforme());
					ret.setEstructuraLabel(FormData2Java.toString(instance.getEstructura().getClaveInforme()));
				}
				if (instance.getCimentaciones() != null) {
					ret.setCimentacionesId(instance.getCimentaciones().getClaveInforme());
					ret.setCimentacionesLabel(instance.getCimentaciones().getCimentacionprofundaTexto());
				}
				if (instance.getAccesibilidadAjustesRazonables() != null) {
					ret.setAccesibilidadAjustesRazonablesId(instance.getAccesibilidadAjustesRazonables().getClaveInforme());
					ret.setAccesibilidadAjustesRazonablesLabel(FormData2Java.toString(instance.getAccesibilidadAjustesRazonables().getClaveInforme()));
				}
				if (instance.getEficienciasEnergeticas() != null) {
					ret.setEficienciasEnergeticasId(instance.getEficienciasEnergeticas().getClaveInforme());
					ret.setEficienciasEnergeticasLabel(FormData2Java.toString(instance.getEficienciasEnergeticas().getClaveInforme()));
				}
				if (instance.getAcusticaRuidosExteriores() != null) {
					ret.setAcusticaRuidosExterioresId(instance.getAcusticaRuidosExteriores().getClaveInforme());
					ret.setAcusticaRuidosExterioresLabel(FormData2Java.toString(instance.getAcusticaRuidosExteriores().getClaveInforme()));
				}
				if (instance.getAcusticaRuidosInterioresHorizontales() != null) {
					ret.setAcusticaRuidosInterioresHorizontalesId(instance.getAcusticaRuidosInterioresHorizontales().getClaveInforme());
					ret.setAcusticaRuidosInterioresHorizontalesLabel(FormData2Java.toString(instance.getAcusticaRuidosInterioresHorizontales().getClaveInforme()));
				}
				if (instance.getAcusticaDatosGenerales() != null) {
					ret.setAcusticaDatosGeneralesId(instance.getAcusticaDatosGenerales().getClaveInforme());
					ret.setAcusticaDatosGeneralesLabel(FormData2Java.toString(instance.getAcusticaDatosGenerales().getClaveInforme()));
				}
				if (instance.getAcusticas() != null) {
					ret.setAcusticasId(instance.getAcusticas().getClaveInforme());
					ret.setAcusticasLabel(FormData2Java.toString(instance.getAcusticas().getClaveInforme()));
				}
				if (instance.getConservacion() != null) {
					ret.setConservacionId(instance.getConservacion().getClaveInforme());
					ret.setConservacionLabel(FormData2Java.toString(instance.getConservacion().getClaveInforme()));
				}
				
				Edificio edificio = instance.getInforme().getEdificio();

				ret.setEdificioId(edificio.getClave());
				String edificioLabel = EdificioBean.composeLabel(edificio);
				ret.setEdificioLabel(edificioLabel);

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);				throw new FunctorException(e);
			}

		}

		@Override
		public InspeccionListadoVO transform(Inspeccion instance) {
			if (instance == null) {
				return null;
			}
			InspeccionListadoVO ret = new InspeccionListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Inspeccion, InspeccionFormVO> {

		@Override
		public InspeccionFormVO transform(Inspeccion instance) {
			if (instance == null) {
				return null;
			}
			InspeccionFormVO ret = new InspeccionFormVO();
			listadoTransformer().transform(instance, ret);

			ret.setFechasVisitas(new HashSet<FechaVisitaListadoVO>(CollectionUtils.collect(instance.getFechasVisitas(), new FechaVisitaBean().listadoTransformer())));
			ret.setValoracionesParciales(new HashSet<ValoracionParcialListadoVO>(CollectionUtils.collect(instance.getValoracionesParciales(), new ValoracionParcialBean().listadoTransformer())));
			ret.setDocumentacionOtros(new HashSet<DocumentacionOtroListadoVO>(CollectionUtils.collect(instance.getDocumentacionOtros(), new DocumentacionOtroBean().listadoTransformer())));
			/* Descomentar para pasar el valor de esta colección al formulario
			ret.setAcusticaMejorasAcusticas( new HashSet<AcusticaMejorasAcusticasListadoVO>(CollectionUtils.collect(instance.getAcusticaMejorasAcusticas(), new AcusticaMejorasAcusticasBean().listadoTransformer() )) );
			*/
			ret.setDeficiencias(new HashSet<DeficienciaListadoVO>(CollectionUtils.collect(instance.getDeficiencias(), new DeficienciaBean().listadoTransformer())));
			ret.setValores(new LinkedHashSet<ValorListadoVO>(CollectionUtils.collect(instance.getValores(), new ValorBean().listadoTransformer())));
			ret.setHistoricos(new HashSet<HistoricoListadoVO>(CollectionUtils.collect(instance.getHistoricos(), new HistoricoBean().listadoTransformer())));

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public Transformer<Inspeccion, InspeccionFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Inspeccion, InspeccionListadoVO> listadoTransformer() {

		return new LvoTransformer();

	}

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * 
	 * @param filters
	 * @param pagingConfig
	 */
	protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig) {

		Map<String, String> filterAssigments = new HashMap<String, String>();
		Map<String, String> orderAssigments = new HashMap<String, String>();
		
		
		
		filterAssigments.put("edificio", "informe.edificio.id");
		filterAssigments.put("municipio", "informe.edificio.via.municipio.id");

		
		orderAssigments.put("edificio", "informe.edificio.via.nombre");
		orderAssigments.put("municipio", "informe.edificio.via.municipio.nombre");
		
		
		
		filterAssigments.put("primaryLabel", "id");
		orderAssigments.put("primaryLabel", "id");

		filterAssigments.put("informe", "informe.clave");
		orderAssigments.put("informe", "informe.clave");
		filterAssigments.put("accesibilidadPublicos", "accesibilidadPublicos.claveInforme");
		orderAssigments.put("accesibilidadPublicos", "accesibilidadPublicos.claveInforme");
		filterAssigments.put("acusticaRuidosInterioresUniones", "acusticaRuidosInterioresUniones.claveInforme");
		orderAssigments.put("acusticaRuidosInterioresUniones", "acusticaRuidosInterioresUniones.claveInforme");
		filterAssigments.put("acusticaValoracionFinal", "acusticaValoracionFinal.claveInforme");
		orderAssigments.put("acusticaValoracionFinal", "acusticaValoracionFinal.claveInforme");
		filterAssigments.put("acusticaRuidosInterioresVerticales", "acusticaRuidosInterioresVerticales.claveInforme");
		orderAssigments.put("acusticaRuidosInterioresVerticales", "acusticaRuidosInterioresVerticales.claveInforme");
		filterAssigments.put("acusticaComprobaciones", "acusticaComprobaciones.claveInforme");
		orderAssigments.put("acusticaComprobaciones", "acusticaComprobaciones.claveInforme");
		filterAssigments.put("instalaciones", "instalaciones.claveInforme");
		orderAssigments.put("instalaciones", "instalaciones.claveInforme");
		filterAssigments.put("cerramientosCubiertas", "cerramientosCubiertas.claveInforme");
		orderAssigments.put("cerramientosCubiertas", "cerramientosCubiertas.claveInforme");
		filterAssigments.put("accesibilidadValoracionFinales", "accesibilidadValoracionFinales.claveInforme");
		orderAssigments.put("accesibilidadValoracionFinales", "accesibilidadValoracionFinales.claveInforme");
		filterAssigments.put("acusticaRuidoInstalaciones", "acusticaRuidoInstalaciones.claveInforme");
		orderAssigments.put("acusticaRuidoInstalaciones", "acusticaRuidoInstalaciones.claveInforme");
		filterAssigments.put("estructura", "estructura.claveInforme");
		orderAssigments.put("estructura", "estructura.claveInforme");
		filterAssigments.put("cimentaciones", "cimentaciones.claveInforme");
		orderAssigments.put("cimentaciones", "cimentaciones.cimentacionprofundaTexto");
		filterAssigments.put("accesibilidadAjustesRazonables", "accesibilidadAjustesRazonables.claveInforme");
		orderAssigments.put("accesibilidadAjustesRazonables", "accesibilidadAjustesRazonables.claveInforme");
		filterAssigments.put("eficienciasEnergeticas", "eficienciasEnergeticas.claveInforme");
		orderAssigments.put("eficienciasEnergeticas", "eficienciasEnergeticas.claveInforme");
		filterAssigments.put("acusticaRuidosExteriores", "acusticaRuidosExteriores.claveInforme");
		orderAssigments.put("acusticaRuidosExteriores", "acusticaRuidosExteriores.claveInforme");
		filterAssigments.put("acusticaMejorasAcusticas", "acusticaMejorasAcusticas.claveInforme");
		orderAssigments.put("acusticaMejorasAcusticas", "acusticaMejorasAcusticas.claveInforme");
		filterAssigments.put("acusticaRuidosInterioresHorizontales", "acusticaRuidosInterioresHorizontales.claveInforme");
		orderAssigments.put("acusticaRuidosInterioresHorizontales", "acusticaRuidosInterioresHorizontales.claveInforme");
		filterAssigments.put("acusticaDatosGenerales", "acusticaDatosGenerales.claveInforme");
		orderAssigments.put("acusticaDatosGenerales", "acusticaDatosGenerales.claveInforme");
		filterAssigments.put("acusticas", "acusticas.claveInforme");
		orderAssigments.put("acusticas", "acusticas.claveInforme");
		filterAssigments.put("conservacion", "conservacion.claveInforme");
		orderAssigments.put("conservacion", "conservacion.claveInforme");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
