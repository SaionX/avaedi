package es.caib.avaedi.at4forms.common.exception;


/**
 * clase Exception class que puede ser lanzada al crear TransferObjects
 *
 * @author  agarcia
 */
public class TransferObjectCreateException extends Exception {
	private static final long serialVersionUID = -2415568908371485648L;

	/**
	 * message constructor.
	 * @param message the error message
	 */
	public TransferObjectCreateException(String message) {
		super(message);
	}

	/**
	 * cause constructor.
	 * @param cause the cause
	 */
	public TransferObjectCreateException(Exception cause) {
		super(cause);
	}

	/**
	 * message and cause constructor.
	 * @param message the error message
	 * @param cause   the cause
	 */
	public TransferObjectCreateException(String message, Exception cause) {
		super(message, cause);
	}
}
