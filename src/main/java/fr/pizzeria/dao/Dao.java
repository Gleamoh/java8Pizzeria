package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;

/**
 * 
 * @author Kevin M. Interface qui definie les méthodes permettant CRUD
 *
 */
public interface Dao<T> {

	/**
	 * @return : List<T>
	 */
	List<T> findAll();

	/**
	 * @param id
	 * @return : T
	 */
	T findById(int id);

	/**
	 * @param labelle
	 * @return : T
	 * @throws SQLException
	 */
	List<T> findByLabel(String labelle);

	/**
	 * @param t
	 * @throws SaveException
	 *             : void
	 */
	void saveNew(T t);

	/**
	 * @param t
	 * @throws UpdateException
	 *             : void
	 */
	void update(T t);

	/**
	 * @param t
	 * @throws DeleteException
	 *             : void
	 */
	void delete(T t);

	/**
	 * @param result
	 * @return : List<Pizza>
	 */
	List<T> parseToList(ResultSet result);

}
