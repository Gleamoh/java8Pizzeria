package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaMemoireDao;
import fr.pizzeria.exception.DeletePizzaException;

/**
 * 
 * @author Kevin M.
 */
public class ServicePizzaSupprimer extends ServicePizzaMenu {

	/** Constructor
	 * 
	 */
	public ServicePizzaSupprimer() {
		super();
	}

	@Override
	public void executeUC() {

		(new ServicePizzaLister()).executeUC();
		System.out.println("########################################");
		System.out.println("#           SUPPRIMER PIZZA            #");
		System.out.println("########################################");
		System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
		String codePizza = getScanner().nextLine();
		System.out.println("########################################");
		System.out.println();
		// supprimer la pizza
		try {
			PizzaMemoireDao.getInstance().deletePizza(codePizza);
		} catch (DeletePizzaException e) {
			e.printStackTrace();
		}

	}

}
