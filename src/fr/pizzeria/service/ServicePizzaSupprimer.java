package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class ServicePizzaSupprimer extends ServicePizzaMenu {

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
			PizzaDao.getInstance().deletePizza(codePizza);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
