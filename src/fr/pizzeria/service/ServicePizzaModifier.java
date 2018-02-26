package fr.pizzeria.service;

public class ServicePizzaModifier extends ServicePizzaMenu{

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
		getPizzaMemDoa().updatePizza(code, editPizza());
	}

}
