package es.caib.avaedi.at4forms.common.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import es.caib.avaedi.at4forms.common.basedao.Model;

/**
 * POJO de base con los metodos comunes a todas las clases de modelo
 * @author agarcia
 *
 */
@Entity
@Table(name="audit_operation"
    ,schema="audit"
)
public class AuditOperation implements Model  {

    private long id;
    private long transactionId;
    private Date transactionTimeStamp;
    private Date operationTimeStamp;
    private String dbUser;
    private char action;
    private String table;
    private long objectId;
	
    @Id
    @Column(name="audit_id")
    public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getObjectId() {
		return objectId;
	}
	public void setObjectId(long oid) {
		this.objectId = oid;
	}

    @Column(name="audit_table")
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}

	@Override
	@Transient
	public Date getDateCreation() {
		return this.operationTimeStamp;
	}
	@Override
	@Transient
	public Date getLastModified() {
		return this.operationTimeStamp;
	}
	@Override
	@Transient
	public String getCreatorUser() {
		return this.dbUser;
	}
	@Override
	@Transient
	public String getModUser() {
		return this.dbUser;
	}
	
	@Override
	@Transient
	public void setDateCreation(Date ahora) {}
	@Override
	@Transient
	public void setLastModified(Date ahora) {}
	@Override
	@Transient
	public void setCreatorUser(String username) {}
	@Override
	@Transient
	public void setModUser(String username) {}
    

}
