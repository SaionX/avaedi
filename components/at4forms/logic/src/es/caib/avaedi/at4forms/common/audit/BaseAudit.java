package es.caib.avaedi.at4forms.common.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import es.caib.avaedi.at4forms.common.basedao.Model;

/**
 * POJO de base con los metodos comunes de las clases de auditoría
 * @author agarcia
 *
 */
@MappedSuperclass
public class BaseAudit<T extends Model> implements Auditoria<T> {

    private int id;
    private long transactionId;
    private Date transactionTimeStamp;
    private Date operationTimeStamp;
    private String dbUser;
    private char action;
    private long oid;
	
    @Id
    @Column(name="audit_id")
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(name="audit_transid")
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="audit_transts", nullable=false, length=35)
	public Date getTransactionTimeStamp() {
		return transactionTimeStamp;
	}
	public void setTransactionTimeStamp(Date transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="audit_operts", nullable=false, length=35)
	public Date getOperationTimeStamp() {
		return operationTimeStamp;
	}
	public void setOperationTimeStamp(Date operationTimeStamp) {
		this.operationTimeStamp = operationTimeStamp;
	}

    @Column(name="audit_dbuser", length=32, nullable=false)
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbuser) {
		this.dbUser = dbuser;
	}
    @Column(name="audit_action", nullable=false)
	public char getAction() {
		return action;
	}
	public void setAction(char action) {
		this.action = action;
	}
	
    @Column(name="audit_oid")
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}

	private T oldRecord;
	private T newRecord;

	@Override
	@Transient
	public T getOldRecord() {
		return oldRecord;
	}

	@Override
	@Transient
	public T getNewRecord() {
		return newRecord;
	}
    
	@Override
	public void setOldRecord(T oldRecord) {
		this.oldRecord = oldRecord;
	}
    
	@Override
	public void setNewRecord(T newRecord) {
		this.newRecord = newRecord;
	}
    
	
}
