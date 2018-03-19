package fr.pizzeria.service;

import fr.pizzeria.dao.FactoryDao;
import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.SaveException;

/**
 * @author Kevin M.
 *
 */
public class AjouterPizzaService extends MenuPizzaService {

	/**
	 * Constructor
	 * 
	 */
	public AjouterPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws SaveException {

		System.out.println("########################################");
		System.out.println("#           NOUVELLE PIZZA             #");
		System.out.println("########################################");
		try {
			FactoryDao.getPizzaDao().saveNew(editPizza());
		} catch (PizzeriaException e) {
			throw new SaveException();
		}
		System.out.println("########################################");
		System.out.println();

	}

	// TODO ajouter les pizzas à la base
}
