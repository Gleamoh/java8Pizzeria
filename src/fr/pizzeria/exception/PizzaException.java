package fr.pizzeria.exception;

/**
 * @author Kevin M.
 *
 */
public class PizzaException extends Exception {

	/** PizzaException.java : long */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public PizzaException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public PizzaException(String message) {
		super(message);
	}

}
