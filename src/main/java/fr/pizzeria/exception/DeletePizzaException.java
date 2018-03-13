package fr.pizzeria.exception;

/**
 * @author Kevin M.
 *
 */
public class DeletePizzaException extends PizzaException {

	/** DeletePizzaException.java : long */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public DeletePizzaException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public DeletePizzaException(String message) {
		super(message);
	}

}
