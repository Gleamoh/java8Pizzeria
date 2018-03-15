package fr.pizzeria.exception.jdbc;

public class ParametersJdbcException extends JdbcException {
	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	public ParametersJdbcException() {
		super();
	}

	public ParametersJdbcException(String message) {
		super(message);
	}
	
}
