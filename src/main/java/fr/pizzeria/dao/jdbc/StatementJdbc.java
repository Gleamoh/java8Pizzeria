package fr.pizzeria.dao.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

import fr.pizzeria.exception.BuildStatementJdbcException;
import fr.pizzeria.exception.JdbcException;

/**
 * Permet de générer un statement à partir d'un objet DatabaseJdbc. Il est
 * conseillé d'utiliser les methode rebuildConnection() et rebuildStatement
 * ainsi on peut recupérer une connexion ou un statement toujours ouvert
 * 
 * @author Kevin M.
 *
 */
public class StatementJdbc {

	/**
	 * statement : Statement statement
	 */
	private Statement statement;

	/**
	 * Constructor
	 * 
	 */
	public StatementJdbc() {
		buildStatment();
	}

	/**
	 * Creer et retourne le statement
	 * 
	 * @throws BuildStatementJdbcException
	 *             Si erreur de création
	 */
	protected void buildStatment() {
		try {
			statement = DatabaseJdbc.getInstance().rebuildConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JdbcException e) {
			e.printStackTrace();
		}
	}

	/**
	 * retourne un statement courant ou un nouveau s'il est fermé
	 * 
	 * @return : Statement Statement
	 */
	public Statement rebuildStatement() {
		try {
			if (statement.isClosed())
				buildStatment();
			return statement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  : void Femer le statement et la connection
	 */
	public void CloseStatementAndConnection() {
		try {
			statement.close();
			statement.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setter
	 * 
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

}
