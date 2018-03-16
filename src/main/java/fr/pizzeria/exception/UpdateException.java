package fr.pizzeria.exception;

public class UpdateException extends PizzeriaException {

	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public UpdateException() {
		super("Erreur lors de la mise à jour d'un élement");
	}

	/** Constructor
	 * @param message
	 */
	public UpdateException(String message) {
		super(message);
	}

}
