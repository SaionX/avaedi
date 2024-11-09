package es.caib.avaedi.at4forms.common.audit;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;

import java.io.Serializable;
import java.util.Date;


/**
 * TransferObject para la implementacion del listado AuditOperation
 */
@DataTransferObject
public class AuditOperationListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}
	
	@Override
	public String getPrimaryLabel() {
		  return this.getTable();
	}
	

      private Long id;
      private long transactionId;
      private Date transactionTimeStamp;
      private Date operationTimeStamp;
      private String dbUser;
      private char action;
      private String table;
      private long objectId;
	private ListadoVO newRecord;
	private ListadoVO oldRecord;

    public AuditOperationListadoVO() {
    }

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    public Date getTransactionTimeStamp() {
        return this.transactionTimeStamp;
    }
    
    public void setTransactionTimeStamp(Date transactionTimeStamp) {
        this.transactionTimeStamp = transactionTimeStamp;
    }
    public Date getOperationTimeStamp() {
        return this.operationTimeStamp;
    }
    
    public void setOperationTimeStamp(Date operationTimeStamp) {
        this.operationTimeStamp = operationTimeStamp;
    }
    public String getDbUser() {
        return this.dbUser;
    }
    
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }
    public char getAction() {
        return this.action;
    }
    
    public void setAction(char action) {
        this.action = action;
    }
    public String getTable() {
        return this.table;
    }
    
    public void setTable(String table) {
        this.table = table;
    }
    public long getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(long oid) {
        this.objectId = oid;
    }

    public ListadoVO getNewRecord() {
    	return newRecord;
    }
    
	public void setNewRecord(ListadoVO newRecord) {
		
		this.newRecord = newRecord;
		
	}

    public ListadoVO getOldRecord() {
    	return oldRecord;
    }
    
	public void setOldRecord(ListadoVO oldRecord) {
		
		this.oldRecord = oldRecord;
		
	}

}


