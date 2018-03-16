package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Kevin M. Interface qui definie les méthodes permettant CRUD
 *
 */
public interface IDao<T> {

	/**
	 * @return : List<T>
	 */
	List<T> findAll();

	/**
	 * @param id
	 * @return : Pizza
	 */
	Pizza findById(int id);

	/**
	 * @param t
	 * @throws SaveException
	 *             : void
	 */
	void saveNew(T t) throws SaveException;

	/**
	 * @param t
	 * @throws UpdateException
	 *             : void
	 */
	void update(T t) throws UpdateException;

	/**
	 * @param t
	 * @throws DeleteException
	 *             : void
	 */
	void delete(T t) throws DeleteException;

	/**
	 * @param id
	 * @throws DeleteException
	 *             : void
	 */
	void deleteById(int id) throws DeleteException;

	/**
	 * @param result
	 * @return : List<Pizza>
	 */
	List<T> parseToList(ResultSet result) throws SQLException;

}
