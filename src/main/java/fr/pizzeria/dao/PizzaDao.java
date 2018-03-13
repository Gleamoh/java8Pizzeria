package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class PizzaDao implements IPizzaDao {

	/** PizzaDao.java : IPizzaDao */
	private static IPizzaDao dao;

	/** PizzaDao.java : List<Pizza> */
	private List<Pizza> pizzaList;

	/**
	 * Constructor Initialise la liste de pizza
	 */
	private PizzaDao() {
		if (pizzaList == null) {
			pizzaList = new ArrayList<>();
			saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza("MAR", "Margarita", 14.00, CategoriePizza.SANS_VIANDE));
			saveNewPizza(new Pizza("rei", "La Reine", 11.00, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00, CategoriePizza.SANS_VIANDE));
			saveNewPizza(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza("sav", "La savoyarde", 13.00, CategoriePizza.POISSON));
			saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza("IND", "L\'indienne", 14.00, CategoriePizza.VIANDE));
		}
	}

	/**
	 * Singleton dao
	 * 
	 * @return
	 */
	public static IPizzaDao getInstance() {
		if (dao == null)
			dao = new PizzaDao();
		return dao;
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

	/**
	 * Trouver l'indexe d'une pizza en fonction de son code
	 * 
	 * @param codePizza
	 * @return
	 */
	private int findPizzaIndexByCode(String codePizza) {

		for (Pizza pizza : pizzaList) {
			if (pizza.getCode().equals(codePizza))
				return pizzaList.indexOf(pizza);
		}

		return -1;
	}
}
