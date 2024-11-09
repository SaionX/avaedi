package es.caib.avaedi.at4forms.common.basedao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO de base con los métodos comunes a todas las clases de modelo
 * @author agarcia
 *
 */
@MappedSuperclass
public class BaseModel implements Model {

    private Date dateCreation;
    private Date lastModified;
    private String creatorUser;
    private String modUser;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_creation", nullable=false, length=35)
    public Date getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified", nullable=false, length=35)
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    @Column(name="creator_user", length=32)
    public String getCreatorUser() {
        return this.creatorUser;
    }
    
    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }
    
    @Column(name="mod_user", length=32)
    public String getModUser() {
        return this.modUser;
    }
    
    public void setModUser(String modUser) {
        this.modUser = modUser;
    }
    
	
}
