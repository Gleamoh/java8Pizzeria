package fr.pizzeria.exception;

public class BuildStatementJdbcException extends JdbcException {
	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public BuildStatementJdbcException() {
		super("Erreur lors de la création du JdbcStatement");
	}

	/** Constructor
	 * @param message
	 */
	public BuildStatementJdbcException(String message) {
		super(message);
	}
	
}
