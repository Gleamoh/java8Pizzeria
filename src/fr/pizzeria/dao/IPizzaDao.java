package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	public List<Pizza> findAllPizzas();
	public void saveNewPizza(Pizza pizza) throws SavePizzaException;
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	public void deletePizza(String codePizza) throws DeletePizzaException;
	public Pizza findPizzaByCode(String codePizza);
	public boolean pizzaExists(String codePizza);
}
