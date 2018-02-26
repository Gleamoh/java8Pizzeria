package fr.pizzeria.service;

public class ServicePizzaAjouter extends ServicePizzaMenu{
	
	public ServicePizzaAjouter() {
		super();
	}

	@Override
	public void executeUC() {
		System.out.println("########################################");
		System.out.println("#           NOUVELLE PIZZA             #");
		System.out.println("########################################");
		getPizzaMemDoa().saveNewPizza(editPizza());
		System.out.println("########################################");
		System.out.println();
	}
}
