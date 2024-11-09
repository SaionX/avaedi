package es.caib.avaedi.at4forms.logic.vo;

import java.util.Date;
import java.util.HashMap;


import org.directwebremoting.annotations.DataTransferObject;


@DataTransferObject
public abstract class BaseVO implements ListadoVO {

    private Date dateCreation;
    private Date lastModified;
    private String creatorUser;
    private String modUser;
	
    public Date getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    public String getCreatorUser() {
        return this.creatorUser;
    }
    
    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }
    
    public String getModUser() {
        return this.modUser;
    }
    
    public void setModUser(String modUser) {
        this.modUser = modUser;
    }
	
}
