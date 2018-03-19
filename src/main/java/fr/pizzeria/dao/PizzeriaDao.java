package fr.pizzeria.dao;

import java.util.List;

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
	public void updatePizza(String codePizza, Pizza pizza);

	/**
	 * Supprime une pizza
	 * 
	 * @param codePizza
	 * @throws DeletePizzaException
	 */
	public void deletePizza(String codePizza);

	/**
	 * Trouver une pizza en fonction du code en paramètre
	 * 
	 * @param codePizza
	 * @return
	 */
	public List<Pizza> findPizzaByCode(String codePizza);

	/**
	 * Retourne vrai si la pizza est presente dans la liste
	 * 
	 * @param codePizza
	 * @return boolean
	 */
	public boolean pizzaExists(String codePizza);
}
