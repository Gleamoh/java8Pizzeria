package fr.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.pizzeria.exception.JdbcException;
import fr.pizzeria.exception.ParametersJdbcException;

/**
 * @author Kevin M. TODO creer un pool de connexion
 */
public class DatabaseJdbc {
	/**
	 * databaseName : String Nom de la base de données
	 */
	private String name;

	/**
	 * ipServer : String L'adresse IP du serveur ou "localhost"
	 */
	private String ipServer;

	/**
	 * subDriver : String Le type de sous driver
	 */
	private String subDriver;

	/**
	 * port : String Le port de connection
	 */
	private String port;

	/**
	 * useSsl : boolean Vrai si la connexion utilise le protocole SSL
	 */
	private boolean useSsl;

	/**
	 * username : String Nom d'utilisateur de la base de données
	 */
	private String username;

	/**
	 * password : String Mot de passe de l'utilisateur
	 */
	private String password;

	/**
	 * driver : String Driver de chargement
	 */
	private String driver;

	/**
	 * connection : Connection connection
	 */
	private Connection connection;

	/**
	 * database : DatabaseJdbc Une seule instance par application
	 */
	private static DatabaseJdbc database;

	/**
	 * Constructor
	 * 
	 * @throws JdbcException
	 */
	private DatabaseJdbc() throws JdbcException {
		buildParameters();
		LoadDriver();
		buildConnection();
	}

	/**
	 * @return DatabaseJdbc Singleton
	 * @throws JdbcException
	 *             : DatabaseJdbc
	 */
	public static DatabaseJdbc getInstance() throws JdbcException {
		if (null == database)
			database = new DatabaseJdbc();
		return database;
	}

	/**
	 * Charger le driver
	 * 
	 * @param database
	 *            : void
	 */
	private void LoadDriver() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * : void Creer la connection
	 */
	private void buildConnection() {
		try {
			connection = DriverManager.getConnection(toUrl(), username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retourner la connection en cours ou en recréer une si elle est fermée
	 * 
	 * @return : Connection
	 */
	public Connection rebuildConnection() {
		try {
			if (connection.isClosed())
				buildConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return : String Retourner l'url de connexion
	 */
	private String toUrl() {
		return "jdbc:" + subDriver + "://" + ipServer + ":" + port + "/" + name + "?useSSL=" + useSsl;
	}

	/**
	 * : void Initialiser les attribut via un fichier de config
	 * 
	 * @throws JdbcException
	 *             : void
	 */
	private void buildParameters() throws JdbcException {
		ResourceBundle file = null;
		try {
			file = ResourceBundle.getBundle("jdbc");
			name = file.getString("database_name");
			username = file.getString("database_username");
			password = file.getString("user_password");
			subDriver = file.getString("sub_driver");
			ipServer = file.getString("ip_server");
			port = file.getString("port");
			driver = file.getString("driver");
		} catch (Exception e) {
			throw new ParametersJdbcException("Le fichier de configuration de la base de données est incorrect");
		}
	}

	/**
	 * Getter
	 * 
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return name;
	}

	/**
	 * Getter
	 * 
	 * @return the ipServer
	 */
	public String getIpServer() {
		return ipServer;
	}

	/**
	 * Getter
	 * 
	 * @return the subDriver
	 */
	public String getSubDriver() {
		return subDriver;
	}

	/**
	 * Getter
	 * 
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Getter
	 * 
	 * @return the useSsl
	 */
	public boolean isUseSsl() {
		return useSsl;
	}

	/**
	 * Getter
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter
	 * 
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

}
