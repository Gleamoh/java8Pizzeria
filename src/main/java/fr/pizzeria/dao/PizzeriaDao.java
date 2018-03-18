package fr.pizzeria.dao;

import java.sql.SQLException;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Kevin M. Interface qui definie les méthodes permettant CRUD
 *
 */
public interface PizzeriaDao extends Dao<Pizza> {

	/**
	 * Modifie une pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 * @throws UpdatePizzaException
	 */
	public void updatePizza(String codePizza, Pizza pizza) throws SQLException;

	/**
	 * Supprime une pizza
	 * 
	 * @param codePizza
	 * @throws DeletePizzaException
	 */
	public void deletePizza(String codePizza) throws SQLException;

	/**
	 * Trouver une pizza en fonction du code en paramètre
	 * 
	 * @param codePizza
	 * @return
	 */
	public Pizza findPizzaByCode(String codePizza) throws SQLException;

	/**
	 * Retourne vrai si la pizza est presente dans la liste
	 * 
	 * @param codePizza
	 * @return boolean
	 */
	public boolean pizzaExists(String codePizza) throws SQLException;
}
