package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Kevin M. Interface qui definie les méthodes permettant CRUD
 *
 */
public interface IPizzaDao {
	/**
	 * Retourne la liste des pizzas
	 * 
	 * @return List<Pizza>
	 */
	public List<Pizza> findAllPizzas();

	/**
	 * @param id
	 * @return : Pizza
	 */
	public Pizza findPizzayId(int id);
	
	/**
	 * Ajoute une pizza
	 * 
	 * @param pizza
	 * @throws SavePizzaException
	 */
	public void saveNewPizza(Pizza pizza) throws SavePizzaException;

	/**
	 * Modifie une pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 * @throws UpdatePizzaException
	 */
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;

	/**
	 * Supprime une pizza
	 * 
	 * @param codePizza
	 * @throws DeletePizzaException
	 */
	public void deletePizza(String codePizza) throws DeletePizzaException;

	/**
	 * Trouver une pizza en fonction du code en paramètre
	 * 
	 * @param codePizza
	 * @return
	 */
	public Pizza findPizzaByCode(String codePizza);

	/**
	 * Retourne vrai si la pizza est presente dans la liste
	 * 
	 * @param codePizza
	 * @return boolean
	 */
	public boolean pizzaExists(String codePizza);
}
