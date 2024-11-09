package es.caib.avaedi.logic.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import es.caib.avaedi.at4forms.common.util.Constants;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.common.model.Edificio;
import es.caib.avaedi.common.persistence.EdificioDao;
import es.caib.avaedi.common.persistence.ViaDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioListadoVO;
import es.caib.avaedi.logic.vo.InformeListadoVO;

/**
 * Bean negocio para tratar el formulario: Edificio
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("EdificioBean")
public class EdificioBean extends BaseBean<Edificio, EdificioListadoVO, EdificioFormVO> implements EdificioBO {

	public EdificioBean() {
		super(Edificio.class, EdificioListadoVO.class, EdificioFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Edificio
	 */
	@Autowired
	@Qualifier("EdificioDao")
	protected EdificioDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Edificio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EdificioDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Via
	 */
	@Autowired
	@Qualifier("ViaDao")
	protected ViaDao viaDao;

	/**
	 * DAO para acceder al modelo: Via
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setViaDao(ViaDao dao) {
		this.viaDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId) throws GenericBusinessException {
		return this.findByVia(viaId, null, null);
	}

	@Override
	public ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByVia(viaId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "via.clave", FormData2Java.toString(viaId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Devuelve la instancia de EdificioFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigoCatastro
	 * @return la instancia de EdificioFormVO
	 * @throws GenericBusinessException
	 */
	public EdificioFormVO findByCodigoCatastro(String codigoCatastro) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByCodigoCatastro(codigoCatastro));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Rellena una instancia de Edificio con los datos recibidos de la capa de
	 * servicio
	 */
	protected Edificio setFormData(EdificioFormVO formData, Edificio record) throws GenericBusinessException {

		if (record == null) {
			record = new Edificio();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "informes", "via" });

			//----- Relacion Via
			record.setVia(this.viaDao.findById(formData.getViaId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Edificio, EdificioListadoVO> {

		@Override
		public EdificioListadoVO transform(Edificio instance, EdificioListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "via", "informes" });

				ret.setViaId(instance.getVia().getClave());
				ret.setViaLabel(ViaBean.composeLabel(instance.getVia()));
				ret.setMunicipioId(instance.getVia().getMunicipio().getClave());
				ret.setMunicipioLabel(instance.getVia().getMunicipio().getNombre());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public EdificioListadoVO transform(Edificio instance) {
			if (instance == null) {
				return null;
			}
			EdificioListadoVO ret = new EdificioListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Edificio, EdificioFormVO> {

		@Override
		public EdificioFormVO transform(Edificio instance) {
			if (instance == null) {
				return null;
			}
			EdificioFormVO ret = new EdificioFormVO();
			listadoTransformer().transform(instance, ret);

			ret.setInformes(new LinkedHashSet<InformeListadoVO>(CollectionUtils.collect(instance.getInformes(), new InformeBean().listadoTransformer())));

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public Transformer<Edificio, EdificioFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Edificio, EdificioListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "referenciaCatastral");
		orderAssigments.put("primaryLabel", "referenciaCatastral");

		filterAssigments.put("via", "via.clave");
		orderAssigments.put("via", "via.nombre");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}
	
	public static String composeLabel(EdificioListadoVO edi){
		String edificioLabel =  edi.getViaLabel() + ", " + edi.getNumeroCatastro();
		if (edi.getNumeroExtra() != null && !edi.getNumeroExtra().equals("")) {
			edificioLabel += " (" + edi.getNumeroExtra() + ")";
		}
		return edificioLabel;
	}
	
	public static String composeLabel(Edificio edi){
		String edificioLabel =  ViaBean.composeLabel(edi.getVia()) + ", " + edi.getNumeroCatastro();
		if (edi.getNumeroExtra() != null && !edi.getNumeroExtra().equals("")) {
			edificioLabel += " (" + edi.getNumeroExtra() + ")";
		}
		return edificioLabel;
	}




	@Override
	public ResultadoBusqueda<EdificioFormVO> getListadoCompleto(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.getListado(filters, pagingConfig, formTransformer());
	}
	

}
