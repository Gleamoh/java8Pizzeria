package fr.pizzeria.service;

import fr.pizzeria.dao.FactoryDao;
import fr.pizzeria.exception.DeleteException;

/**
 * 
 * @author Kevin M.
 */
public class SupprimerPizzaService extends MenuPizzaService {

	/**
	 * Constructor
	 * 
	 */
	public SupprimerPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws DeleteException {

		System.out.println("########################################");
		System.out.println("#           SUPPRIMER PIZZA            #");
		System.out.println("########################################");
		System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
		String codePizza = getScanner().nextLine();
		System.out.println("########################################");
		System.out.println();
		// supprimer la pizza
		FactoryDao.getPizzaDao().deletePizza(codePizza);

	}

}
