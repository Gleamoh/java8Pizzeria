package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public class ServicePizzaLister extends ServicePizzaMenu {
	
	
	public ServicePizzaLister() {
		super();
	}

	@Override
	public void executeUC() {

		System.out.println("########################################");
		System.out.println("#              NOS PIZZAS              #");
		System.out.println("########################################");
		
		for (Pizza pizza : getPizzaMemDoa().findAllPizzas()) {
			System.out.println("#    " + pizza);
			System.out.println("----------------------------------------");
		}
		
		System.out.println("########################################");
		System.out.println("\n");
	}

}
