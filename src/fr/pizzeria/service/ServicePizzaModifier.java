package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;

/**
 * @author Kevin M.
 *
 */
public class ServicePizzaModifier extends ServicePizzaMenu {

	/** Constructor
	 * 
	 */
	public ServicePizzaModifier() {
		super();
	}

	@Override
	public void executeUC() {

		(new ServicePizzaLister()).executeUC();
		System.out.println("########################################");
		System.out.println("#           MODIFIER PIZZA             #");
		System.out.println("########################################");
		System.out.print("Veuillez choisir le code de la pizza à modifier : ");
		String code = getScanner().nextLine();
		System.out.println("----------------------------------------");
		System.out.println();
		// modifier la pizza
		try {
			PizzaDao.getInstance().updatePizza(code, editPizza());
		} catch (UpdatePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
