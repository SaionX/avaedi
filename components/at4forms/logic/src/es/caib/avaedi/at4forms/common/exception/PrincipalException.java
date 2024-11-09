package es.caib.avaedi.at4forms.common.exception;

public class PrincipalException extends GenericBusinessException {

	/**
	 *
	 */
	private static final long serialVersionUID = -7636616252315301236L;

	/**
	 * message constructor.
	 * @param message the error message
	 */
	public PrincipalException(String message) {
		super(message);
	}

	/**
	 * cause constructor.
	 * @param cause the cause
	 */
	public PrincipalException(Exception cause) {
		super(cause);
	}

	/**
	 * message and cause constructor.
	 * @param message the error message
	 * @param cause   the cause
	 */
	public PrincipalException(String message, Exception cause) {
		super(message, cause);
	}


}
