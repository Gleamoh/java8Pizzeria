package fr.pizzeria.exception;

public class DeleteException extends PizzeriaException {

	/**
	 * serialVersionUID : long
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 */
	public DeleteException() {
		super("Erreur lors de la suppression de l'élément");
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public DeleteException(String message) {
		super(message);
	}
}
