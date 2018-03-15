package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaMemoireDao;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class ServicePizzaLister extends ServicePizzaMenu {
	
	/** Constructor
	 * 
	 */
	public ServicePizzaLister() {
		super();
	}

	@Override
	public void executeUC() {

		System.out.println("########################################");
		System.out.println("#              NOS PIZZAS              #");
		System.out.println("########################################");
		
		for (Pizza pizza : PizzaMemoireDao.getInstance().findAllPizzas()) {
			System.out.println("#    " + pizza);
			System.out.println("----------------------------------------");
		}
		
		System.out.println("########################################");
		System.out.println("\n");
	}

}
