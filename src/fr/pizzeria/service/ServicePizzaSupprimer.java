package fr.pizzeria.service;

public class ServicePizzaSupprimer extends ServicePizzaMenu{

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
		getPizzaMemDoa().deletePizza(codePizza);
	}

}
