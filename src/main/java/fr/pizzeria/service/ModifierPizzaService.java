package fr.pizzeria.service;

import fr.pizzeria.dao.FactoryDao;
import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.UpdateException;

/**
 * @author Kevin M.
 *
 */
public class ModifierPizzaService extends MenuPizzaService {

	/**
	 * Constructor
	 * 
	 */
	public ModifierPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws UpdateException {

		System.out.println("########################################");
		System.out.println("#           MODIFIER PIZZA             #");
		System.out.println("########################################");
		System.out.print("Veuillez choisir le code de la pizza à modifier : ");
		String code = getScanner().nextLine();
		System.out.println("----------------------------------------");
		System.out.println();
		// modifier la pizza
		try {
			FactoryDao.getPizzaDao().updatePizza(code, editPizza());
		} catch (PizzeriaException e) {
			e.printStackTrace();
		}

	}

}
