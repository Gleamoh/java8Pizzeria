package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

/**
 * @author Kevin M.
 *
 */
public class ServicePizzaAjouter extends ServicePizzaMenu{
	
	/** Constructor
	 * 
	 */
	public ServicePizzaAjouter() {
		super();
	}

	@Override
	public void executeUC() {
		
		System.out.println("########################################");
		System.out.println("#           NOUVELLE PIZZA             #");
		System.out.println("########################################");
		try {
			PizzaDao.getInstance().saveNewPizza(editPizza());
		} catch (UpdatePizzaException | SavePizzaException e) {
			e.printStackTrace();
		}
		System.out.println("########################################");
		System.out.println();
		
	}
}
