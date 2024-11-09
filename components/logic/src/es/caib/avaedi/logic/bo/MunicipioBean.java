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
import es.caib.avaedi.common.model.Municipio;
import es.caib.avaedi.common.persistence.IslaDao;
import es.caib.avaedi.common.persistence.MunicipioDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.MunicipioListadoVO;

/**
 * Bean negocio para tratar el formulario: Municipio
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("MunicipioBean")
public class MunicipioBean extends BaseBean<Municipio, MunicipioListadoVO, MunicipioFormVO> implements MunicipioBO {

	public MunicipioBean() {
		super(Municipio.class, MunicipioListadoVO.class, MunicipioFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Municipio
	 */
	@Autowired
	@Qualifier("MunicipioDao")
	protected MunicipioDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Municipio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected MunicipioDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Isla
	 */
	@Autowired
	@Qualifier("IslaDao")
	protected IslaDao islaDao;

	/**
	 * DAO para acceder al modelo: Isla
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setIslaDao(IslaDao dao) {
		this.islaDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId) throws GenericBusinessException {
		return this.findByIsla(islaId, null, null);
	}

	@Override
	public ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByIsla(islaId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "isla.id", FormData2Java.toString(islaId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Devuelve la instancia de MunicipioFormVO que cumple con la búsqueda
	 * findByNombre
	 * 
	 * @param nombre
	 * @return la instancia de MunicipioFormVO
	 * @throws GenericBusinessException
	 */
	public MunicipioFormVO findByNombre(String nombre) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByNombre(nombre));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la instancia de MunicipioFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigoCatastro
	 * @return la instancia de MunicipioFormVO
	 * @throws GenericBusinessException
	 */
	public MunicipioFormVO findByCodigoCatastro(int codigoCatastro) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByCodigoCatastro(codigoCatastro));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Rellena una instancia de Municipio con los datos recibidos de la capa de
	 * servicio
	 */
	protected Municipio setFormData(MunicipioFormVO formData, Municipio record) throws GenericBusinessException {

		if (record == null) {
			record = new Municipio();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "isla" });

			//----- Relacion Isla
			record.setIsla(this.islaDao.findById(formData.getIslaId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Municipio, MunicipioListadoVO> {

		@Override
		public MunicipioListadoVO transform(Municipio instance, MunicipioListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "isla" });

				ret.setIslaId(instance.getIsla().getId());
				ret.setIslaLabel(instance.getIsla().getNombre());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public MunicipioListadoVO transform(Municipio instance) {
			if (instance == null) {
				return null;
			}
			MunicipioListadoVO ret = new MunicipioListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Municipio, MunicipioFormVO> {

		@Override
		public MunicipioFormVO transform(Municipio instance) {
			if (instance == null) {
				return null;
			}
			MunicipioFormVO ret = new MunicipioFormVO();
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
	public Transformer<Municipio, MunicipioFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Municipio, MunicipioListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "nombre");
		orderAssigments.put("primaryLabel", "nombre");

		filterAssigments.put("isla", "isla.id");
		orderAssigments.put("isla", "isla.nombre");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
