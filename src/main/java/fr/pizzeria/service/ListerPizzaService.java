package fr.pizzeria.service;

import fr.pizzeria.dao.CategoryDao;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaPizzeriaDao;
import fr.pizzeria.dao.PizzeriaDao;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class ListerPizzaService extends MenuPizzaService {

	private PizzeriaDao pizzaDao = new PizzaPizzeriaDao();
	private Dao<CategoriePizza> cDao = new CategoryDao();

	/**
	 * Constructor
	 * 
	 */
	public ListerPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws SaveException {

		System.out.println("########################################");
		System.out.println("#              NOS PIZZAS              #");
		System.out.println("########################################");

		for (Pizza pizza : pizzaDao.findAll()) {
			CategoriePizza categorie = cDao.findById(pizza.getCategorie().getId());
			pizza.setCategorie(categorie);
			System.out.println("#    " + pizza);
			System.out.println("----------------------------------------");
		}

		System.out.println("########################################");
		System.out.println("\n");
	}

}
