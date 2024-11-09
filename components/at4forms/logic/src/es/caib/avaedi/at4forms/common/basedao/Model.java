package es.caib.avaedi.at4forms.common.basedao;

import java.util.Date;

public interface Model {

	Date getDateCreation();

	Date getLastModified();

	String getCreatorUser();

	String getModUser();
	
	void setDateCreation(Date ahora);

	void setLastModified(Date ahora);

	void setCreatorUser(String username);

	void setModUser(String username);
	
}
