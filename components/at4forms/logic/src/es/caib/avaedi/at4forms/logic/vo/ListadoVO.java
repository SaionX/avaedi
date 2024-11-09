package es.caib.avaedi.at4forms.logic.vo;

import java.io.Serializable;
import java.util.Date;

public interface ListadoVO {
	
	public Serializable getPrimaryKey(); 
	public String getPrimaryLabel();

	Date getDateCreation();

	Date getLastModified();

	String getCreatorUser();

	String getModUser();
	
}
