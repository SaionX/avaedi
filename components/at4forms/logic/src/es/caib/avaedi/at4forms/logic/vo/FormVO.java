package es.caib.avaedi.at4forms.logic.vo;

import java.util.Date;


public interface FormVO extends ListadoVO {

	
	void setDateCreation(Date ahora);

	void setLastModified(Date ahora);

	void setCreatorUser(String username);

	void setModUser(String username);


}
