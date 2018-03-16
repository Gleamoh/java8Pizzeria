package fr.pizzeria.exception;

public class ParametersJdbcException extends JdbcException {
	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	/** Constructor
	 * 
	 */
	public ParametersJdbcException() {
		super();
	}

	/** Constructor
	 * @param message
	 */
	public ParametersJdbcException(String message) {
		super(message);
	}
	
}
