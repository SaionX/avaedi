package es.caib.avaedi.at4forms.common.exception;

import javax.ejb.ApplicationException;


/**
 * clase Exception class que puede ser lanzada por la capa de negocio
 *
 * @author  agarcia
 */
@ApplicationException(rollback=true)
public class GenericBusinessException extends Exception {
	private static final long serialVersionUID = -2415568908371485648L;

	/**
	 * message constructor.
	 * @param message the error message
	 */
	public GenericBusinessException(String message) {
		super(message);
	}

	/**
	 * cause constructor.
	 * @param cause the cause
	 */
	public GenericBusinessException(Exception cause) {
		super(cause.getMessage(), cause);
	}

	/**
	 * message and cause constructor.
	 * @param message the error message
	 * @param cause   the cause
	 */
	public GenericBusinessException(String message, Exception cause) {
		super(message, cause);
	}

	public GenericBusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
