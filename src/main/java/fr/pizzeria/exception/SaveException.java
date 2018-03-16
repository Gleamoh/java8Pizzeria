package fr.pizzeria.exception;

public class SaveException extends PizzeriaException {

	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 */
	public SaveException() {
		super("Erreur lors de la création d'un élement");
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public SaveException(String message) {
		super(message);
	}
}
