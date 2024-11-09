package es.caib.avaedi.logic.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
import es.caib.avaedi.common.model.DocumentacionOtro;
import es.caib.avaedi.common.persistence.DocumentacionOtroDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.DocumentacionOtroFormVO;
import es.caib.avaedi.logic.vo.DocumentacionOtroListadoVO;

/**
 * Bean negocio para tratar el formulario: DocumentacionOtro
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("DocumentacionOtroBean")
public class DocumentacionOtroBean extends BaseBean<DocumentacionOtro, DocumentacionOtroListadoVO, DocumentacionOtroFormVO> implements DocumentacionOtroBO {

	public DocumentacionOtroBean() {
		super(DocumentacionOtro.class, DocumentacionOtroListadoVO.class, DocumentacionOtroFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: DocumentacionOtro
	 */
	@Autowired
	@Qualifier("DocumentacionOtroDao")
	protected DocumentacionOtroDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: DocumentacionOtro
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected DocumentacionOtroDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Inspeccion
	 */
	@Autowired
	@Qualifier("InspeccionDao")
	protected InspeccionDao inspeccionDao;

	/**
	 * DAO para acceder al modelo: Inspeccion
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setInspeccionDao(InspeccionDao dao) {
		this.inspeccionDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "inspeccion.id", FormData2Java.toString(inspeccionId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de DocumentacionOtro con los datos recibidos de la
	 * capa de servicio
	 */
	protected DocumentacionOtro setFormData(DocumentacionOtroFormVO formData, DocumentacionOtro record) throws GenericBusinessException {

		if (record == null) {
			record = new DocumentacionOtro();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "inspeccion" });

			//----- Relacion Inspeccion
			record.setInspeccion(this.inspeccionDao.findById(formData.getInspeccionId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<DocumentacionOtro, DocumentacionOtroListadoVO> {

		@Override
		public DocumentacionOtroListadoVO transform(DocumentacionOtro instance, DocumentacionOtroListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "inspeccion" });

				ret.setInspeccionId(instance.getInspeccion().getId());
				ret.setInspeccionLabel(FormData2Java.toString(instance.getInspeccion().getId()));

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public DocumentacionOtroListadoVO transform(DocumentacionOtro instance) {
			if (instance == null) {
				return null;
			}
			DocumentacionOtroListadoVO ret = new DocumentacionOtroListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<DocumentacionOtro, DocumentacionOtroFormVO> {

		@Override
		public DocumentacionOtroFormVO transform(DocumentacionOtro instance) {
			if (instance == null) {
				return null;
			}
			DocumentacionOtroFormVO ret = new DocumentacionOtroFormVO();
			listadoTransformer().transform(instance, ret);

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public Transformer<DocumentacionOtro, DocumentacionOtroFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<DocumentacionOtro, DocumentacionOtroListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "id");
		orderAssigments.put("primaryLabel", "id");

		filterAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("inspeccion", "inspeccion.id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
