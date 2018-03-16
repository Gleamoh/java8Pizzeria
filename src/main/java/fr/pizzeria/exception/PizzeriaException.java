package fr.pizzeria.exception;

/**
 * @author Kevin M.
 *
 */
public class PizzeriaException extends Exception {

	/** PizzaException.java : long */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 */
	public PizzeriaException() {
		super("Erreur dans l'application Pizzeria");
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public PizzeriaException(String message) {
		super(message);
	}

}
