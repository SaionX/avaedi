package es.caib.avaedi.at4forms.common.audit;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;

/**
 * Interfaz DAO para AuditOperation.
 * @author agarcia
 */
public interface AuditOperationDao extends BaseDao<AuditOperation> {

	public <T> T getNewRecord(long id, String tableName, Class<T> typeClass);
	public <T> T getOldRecord(long id, String tableName, Class<T> typeClass);
}


