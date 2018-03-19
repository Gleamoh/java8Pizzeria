package fr.pizzeria.exception;

/**
 * Exception techniques
 * @author Kevin M.
 *
 */
public class TechnicalException extends RuntimeException {

	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public TechnicalException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public TechnicalException(String message) {
		super(message);
	}

}
