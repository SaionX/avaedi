package es.caib.avaedi.logic.bo;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.util.ArchivoUtil;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.common.model.Blob;
import es.caib.avaedi.common.persistence.BlobDao;
import es.caib.avaedi.logic.vo.BlobFormVO;
import es.caib.avaedi.logic.vo.BlobListadoVO;

/**
 * Bean negocio para tratar el formulario: Blob
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("BlobBean")
public class BlobBean extends BaseBean<Blob, BlobListadoVO, BlobFormVO> implements BlobBO {

	public BlobBean() {
		super(Blob.class, BlobListadoVO.class, BlobFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Blob
	 */
	@Autowired
	@Qualifier("BlobDao")
	protected BlobDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Blob
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected BlobDao getMainDao() {
		return this.mainDao;
	}

	/*
	 * Finders para relaciones
	 */

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * 
	 * @param filters
	 * @param pagingConfig
	 */
	protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig) {

		Map<String, String> filterAssigments = new HashMap<String, String>();
		Map<String, String> orderAssigments = new HashMap<String, String>();
		filterAssigments.put("primaryLabel", "clave");
		orderAssigments.put("primaryLabel", "clave");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

	/*
	Archivos desde/a filesystem
	 */
	@Override
	protected Blob setFormData(BlobFormVO formData, Blob record) throws GenericBusinessException {

		try {
			record = super.setFormData(formData, record);
			if (formData.getDatos() != null) {
				ArchivoUtil.exportaArchivoAFilesystem(formData);
				record.setPath(formData.getPath());
			}
		} catch (IOException e) {
			log.error("Error guardando el archivo en filesystem", e);
			throw new GenericBusinessException(e);
		}

		return record;
	}

	private class FvoTransformer implements Transformer<Blob, BlobFormVO> {

		@Override
		public BlobFormVO transform(Blob instance) {
			if (instance == null) {
				return null;
			}
			BlobFormVO ret = new BlobFormVO();
			listadoTransformer().transform(instance, ret);

			if (ret.getPath() != null) {
				try {
					ret.setDatos(ArchivoUtil.obtenerDatosArchivoEnFilesystem(ret));
				} catch (IOException e) {
					log.error("Error leyendo el archivo " + ret.getClave() + " de filesystem", e);
				}
			}

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * @return
	 */
	@Override
	public Transformer<Blob, BlobFormVO> formTransformer() {

		return new FvoTransformer();

	}

	@Override
	public boolean delete(Serializable id) throws GenericBusinessException {
		BlobFormVO b = super.load(id);
		if (super.delete(id)) {
			if (b.getPath() != null) {
				try {
					ArchivoUtil.borrarArchivo(b);
				} catch (IOException e) {
					log.error("No se ha podido eliminar el archivo " + b.getPath(), e);
				}
			}
			return true;
		} else {
			return false;
		}
	}	
}
