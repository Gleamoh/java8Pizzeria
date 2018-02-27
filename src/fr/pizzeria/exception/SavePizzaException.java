package fr.pizzeria.exception;

/**
 * @author Kevin M.
 *
 */
public class SavePizzaException extends PizzaException {

	/** SavePizzaException.java : long */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public SavePizzaException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}

}
