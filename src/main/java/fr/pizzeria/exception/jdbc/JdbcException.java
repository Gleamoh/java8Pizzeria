package fr.pizzeria.exception.jdbc;

public class JdbcException extends Exception {

	/**
	 * serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	public JdbcException() {
		super();
	}

	public JdbcException(String message) {
		super(message);

	}

}
