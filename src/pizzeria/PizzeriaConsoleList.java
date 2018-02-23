package pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDoa;
import fr.pizzeria.model.Pizza;

public class PizzeriaConsoleList {

	public static void main(String[] args) {

		// tableau de pizza
		PizzaMemDoa pizzaMemDoa = new PizzaMemDoa();

		pizzaMemDoa.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50));
		pizzaMemDoa.saveNewPizza(new Pizza("MAR", "Margarita", 14.00));
		pizzaMemDoa.saveNewPizza(new Pizza("REIN", "La Reine", 11.00));
		pizzaMemDoa.saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00));
		pizzaMemDoa.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50));
		pizzaMemDoa.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00));
		pizzaMemDoa.saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50));
		pizzaMemDoa.saveNewPizza(new Pizza("IND", "L\'indienne", 14.00));

		// menu
		Scanner sc = new Scanner(System.in);
		int choix = 0;

		while (choix != 99) {

			System.out.println("****** Pizzeria Administration ********");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizzas");
			System.out.println("99. Sortir");
			System.out.println("\n");
			choix = Integer.parseInt(sc.nextLine());

			switch (choix) {
			case 1: {

				System.out.println("\n");
				System.out.println("Liste des pizzas");
				System.out.println("\n");
				showPizzas(pizzaMemDoa);
				break;
			}
			case 2: {

				System.out.println("\n");
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println("\n");
				pizzaMemDoa.saveNewPizza(editPizza(sc));
				break;
			}
			case 3: {

				System.out.println("Mise à jour d’une pizza");
				showPizzas(pizzaMemDoa);
				System.out.print("Veuillez choisir le code de la pizza à modifier : ");
				String code = sc.nextLine();
				System.out.println("");
				// modifier la pizza
				pizzaMemDoa.updatePizza(code, editPizza(sc));
				break;
			}
			case 4: {

				System.out.println("Suppression d’une pizza");
				showPizzas(pizzaMemDoa);
				System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
				String code = sc.nextLine();
				System.out.println("");
				// supprimer la pizza
				pizzaMemDoa.deletePizza(code);
				break;
			}
			default: {

				System.out.println("Aurevoir ☹");
				break;
			}
			}
		}
		sc.close();
	}

	private static void showPizzas(PizzaMemDoa pizzaMemDoa) {
		
		for (Pizza pizza : pizzaMemDoa.findAllPizzas()) {
			System.out.println(pizza);
		}
		
		System.out.println("\n");
	}

	private static Pizza editPizza(Scanner sc) {

		System.out.println("Veuillez saisir le code :");
		String code = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace) :");
		String labelle = sc.nextLine();

		System.out.println("Veuillez saisir le prix :");
		double prix = Double.parseDouble(sc.nextLine());

		return new Pizza(code, labelle, prix);
	}

}
