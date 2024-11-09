package es.caib.avaedi.at4forms.common.exception;


/**
 * clase Exception que puede ser lanzada por la capa dao
 *
 * @author  agarcia
 */
public class DaoException extends Exception {
	private static final long serialVersionUID = -2415568908371485648L;

	/**
	 * message constructor
	 * @param message the error message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * cause constructor.
	 * @param cause the cause
	 */
	public DaoException(Exception cause) {
		super(cause);
	}

	/**
	 * message y cause constructor.
	 * @param message the error message
	 * @param cause   the cause
	 */
	public DaoException(String message, Exception cause) {
		super(message, cause);
	}
}
