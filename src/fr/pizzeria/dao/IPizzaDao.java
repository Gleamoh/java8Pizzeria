package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	public List<Pizza> findAllPizzas();
	public void saveNewPizza(Pizza pizza);
	public void updatePizza(String codePizza, Pizza pizza);
	public void deletePizza(String codePizza);
	public Pizza findPizzaByCode(String codePizza);
	public boolean pizzaExists(String codePizza);
}
