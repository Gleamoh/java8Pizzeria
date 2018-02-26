package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	
	private List<Pizza> pizzaList;
	
	public PizzaDao() {
		pizzaList = new ArrayList<Pizza>();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzaList.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		pizzaList.get(findPizzaIndexByCode(codePizza)).copyOf(pizza);
		
	}

	@Override
	public void deletePizza(String codePizza) {
		
		pizzaList.remove(findPizzaIndexByCode(codePizza));
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
		for (Pizza pizza : pizzaList) {
			if (pizza.getCode().equals(codePizza))
				return pizza;
		}

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		
		return (findPizzaByCode(codePizza) != null);
	}
	
	private int findPizzaIndexByCode(String codePizza) {

		for (Pizza pizza : pizzaList) {
			if (pizza.getCode().equals(codePizza))
				return pizzaList.indexOf(pizza);
		}

		return -1;
	}
}
