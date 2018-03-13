package fr.pizzeria.exception;

/**
 * @author Kevin M.
 *
 */
public class UpdatePizzaException extends PizzaException {

	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public UpdatePizzaException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
	}

}
