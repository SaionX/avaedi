package es.caib.avaedi.at4forms.common.audit;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

import es.caib.avaedi.at4forms.common.exception.TransferObjectCreateException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.logic.util.TransferObjectFactory;

/**
 * Bean negocio para tratar el formulario: AuditOperation
 * @author agarcia@at4.net
 *
 */
@Repository("AuditOperationBean")
public class AuditOperationBean extends BaseBean<AuditOperation, AuditOperationListadoVO, AuditOperationFormVO> implements AuditOperationBO {

	public AuditOperationBean() {
		super(AuditOperation.class, AuditOperationListadoVO.class, AuditOperationFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: AuditOperation
	 */
	@Autowired @Qualifier("AuditOperationDao")
	protected AuditOperationDao mainDao;

	/** Bean para acceder a los métodos de negocio: AuditOperation
	 * @param bean the bean to set
	 */
	protected AuditOperationDao getMainDao() {
		return this.mainDao;
	}



/*
	Finders para relaciones
*/
	private class LvoTransformer implements ListadoTransformer<AuditOperation, AuditOperationListadoVO> {

		private AuditOperationDao auditDao;

		public LvoTransformer(AuditOperationDao mainDao) {
			this.auditDao = mainDao;
		}

		@Override
		public AuditOperationListadoVO transform(AuditOperation instance, AuditOperationListadoVO ret) {
			return null;
			/*
			 * TODO: generalizar
			
			if (instance == null) {
				return null;
			}
			try {
				// Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] {});

				if (this.auditDao != null) {
					
					//TODO: esto debería ser generalizable/personalizable por aplicación
					if (ret.getTable().equals("aci_infraccion")) {
						
						
						//TODO: los beans podrían estar inyectados
						ret.setNewRecord( 
								new InfraccionBean().listadoTransformer().transform(
										this.auditDao.getNewRecord(ret.getId(), ret.getTable(), Infraccion.class)
										)
								);
						
						if (instance.getAction() == AuditConstants.OPERATION_TYPE_UPDATE) { //Sólo los updates tienen oldRecord
							ret.setOldRecord( 
									new InfraccionBean().listadoTransformer().transform(
											this.auditDao.getOldRecord(ret.getId(), ret.getTable(), Infraccion.class)
											)
									);
						}
						
						
					} else if (ret.getTable().equals("aci_foto")) {

						ret.setNewRecord( 
								new FotoBean().listadoTransformer().transform(
										this.auditDao.getNewRecord(ret.getId(), ret.getTable(), Foto.class)
										)
								);
						
						if (instance.getAction() == AuditConstants.OPERATION_TYPE_UPDATE) { //Sólo los updates tienen oldRecord
							ret.setOldRecord( 
									new FotoBean().listadoTransformer().transform(
											this.auditDao.getOldRecord(ret.getId(), ret.getTable(), Foto.class)
											)
									);
						}
						
					}

				}

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}
				 */

		}

		@Override
		public AuditOperationListadoVO transform(AuditOperation instance) {
			if (instance == null) {
				return null;
			}
			AuditOperationListadoVO ret = new AuditOperationListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<AuditOperation, AuditOperationFormVO> {

		@Override
		public AuditOperationFormVO transform(AuditOperation instance) {
			if (instance == null) {
				return null;
			}
			AuditOperationFormVO ret = new AuditOperationFormVO();
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
	public Transformer<AuditOperation, AuditOperationFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<AuditOperation, AuditOperationListadoVO> listadoTransformer() {

		return new LvoTransformer(this.mainDao);

	}






	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * @param filters
	 * @param pagingConfig
	 */
	protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig) {

				
		Map<String, String> assigments = new HashMap<String, String>();
		assigments.put("primaryLabel", "auditAction");


		CriteriaUtils.normalizeFilters(assigments, filters, pagingConfig); 
	}



}


