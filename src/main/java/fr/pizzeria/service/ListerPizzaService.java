package fr.pizzeria.service;

import fr.pizzeria.dao.FactoryDao;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class ListerPizzaService extends MenuPizzaService {

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

		for (Pizza pizza : FactoryDao.getPizzaDao().findAll()) {
			CategoriePizza categorie = FactoryDao.getCategorieDao().findById(pizza.getCategorie().getId());
			pizza.setCategorie(categorie);
			System.out.println("#    " + pizza);
			System.out.println("----------------------------------------");
		}

		System.out.println("########################################");
		System.out.println("\n");
	}

}
