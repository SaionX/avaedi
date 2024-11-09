package es.caib.avaedi.logic.server.vo;

import java.util.Date;

public abstract class RestBaseVO implements RestVO {

	protected Date lastModified;

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

}
