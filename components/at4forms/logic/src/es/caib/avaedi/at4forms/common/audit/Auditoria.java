package es.caib.avaedi.at4forms.common.audit;

import java.util.Date;

import es.caib.avaedi.at4forms.common.basedao.Model;

public interface Auditoria<T extends Model> {
	
	public T getOldRecord();
	public T getNewRecord();
	public void setOldRecord(T oldRecord);
	public void setNewRecord(T newRecord);

    public int getId();
    public long getTransactionId();
	public Date getTransactionTimeStamp();
	public Date getOperationTimeStamp();
	public String getDbUser();
	public char getAction();
	public long getOid();
	

}
