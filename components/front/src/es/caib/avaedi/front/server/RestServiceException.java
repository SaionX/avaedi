package es.caib.avaedi.front.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestServiceException extends WebApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestServiceException(int status, String message) {
		super(Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
