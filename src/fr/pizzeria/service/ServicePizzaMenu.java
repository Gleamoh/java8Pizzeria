package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public abstract class ServicePizzaMenu {

	// tableau de pizza
	private static IPizzaDao pizzaMemDoa;

	protected IPizzaDao getPizzaMemDoa() {
		return pizzaMemDoa;
	}

	private static Scanner scanner;

	protected static Scanner getScanner() {
		if (scanner == null)
			return new Scanner(System.in);
		return scanner;
	}

	public static void setScanner(Scanner sc) {
		ServicePizzaMenu.scanner = sc;
	}

	public ServicePizzaMenu() {
		if (pizzaMemDoa == null) {
			pizzaMemDoa = new PizzaDao();
			pizzaMemDoa.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50));
			pizzaMemDoa.saveNewPizza(new Pizza("MAR", "Margarita", 14.00));
			pizzaMemDoa.saveNewPizza(new Pizza("REIN", "La Reine", 11.00));
			pizzaMemDoa.saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00));
			pizzaMemDoa.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50));
			pizzaMemDoa.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00));
			pizzaMemDoa.saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50));
			pizzaMemDoa.saveNewPizza(new Pizza("IND", "L\'indienne", 14.00));
		}
	}

	public abstract void executeUC();

	public static void ShowMenu() {
		System.out.println("****** Pizzeria Administration ********");
		System.out.println("*                                     *");
		System.out.println("*   1. Lister les pizzas              *");
		System.out.println("*   2. Ajouter une nouvelle pizza     *");
		System.out.println("*   3. Mettre à jour une pizza        *");
		System.out.println("*   4. Supprimer une pizzas           *");
		System.out.println("*   99. Sortir                        *");
		System.out.println("*                                     *");
		System.out.println("***************************************");
		System.out.println("\n");
	}

	protected Pizza editPizza() {
		System.out.println("----------------------------------------");
		System.out.print("Veuillez saisir le code : ");
		String code = ServicePizzaMenu.scanner.nextLine();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir le nom (sans espace) : ");
		String labelle = ServicePizzaMenu.scanner.nextLine();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir le prix : ");
		double prix = Double.parseDouble(ServicePizzaMenu.scanner.nextLine());
		System.out.println("----------------------------------------");

		return new Pizza(code, labelle, prix);
	}

}
