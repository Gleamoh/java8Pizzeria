package pizzeria;

import java.util.Arrays;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

@Deprecated // Ne pas utiliser cette classe. Anciene version.
public class PizzeriaConsole {

	public static void main(String[] args) {

		// tableau de pizza
		Pizza[] pizzas = new Pizza[8];
//		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
//		pizzas[1] = new Pizza("MAR", "Margarita", 14.00);
//		pizzas[2] = new Pizza("REIN", "La Reine", 11.00);
//		pizzas[3] = new Pizza("FRO", "La 4 formages", 12.00);
//		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
//		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
//		pizzas[6] = new Pizza("ORI", "L\'orientale", 13.50);
//		pizzas[7] = new Pizza("IND", "L\'indienne", 14.00);

		System.out.println(pizzas[0]);
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
					showPizzas(pizzas);
					break;
				}
				case 2: {
					System.out.println("\n");
					System.out.println("Ajout d’une nouvelle pizza");
					System.out.println("\n");
					pizzas = addPizza(pizzas, editPizza(sc));
					break;
				}
				case 3: {
					System.out.println("Mise à jour d’une pizza");
					showPizzas(pizzas);
					System.out.print("Veuillez choisir le code de la pizza à modifier : ");
					String code = sc.nextLine();
					System.out.println("");
					Pizza pizza = editPizza(sc);
					// modifier la pizza
					editPizzaProcess(pizza, pizzas[getPizzaIndexByCode(pizzas, code)]);
					break;
				}
				case 4: {
					System.out.println("Suppression d’une pizza");
					
					showPizzas(pizzas);

					System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
					String code = sc.nextLine();
					System.out.println("");
					
					// supprimer la pizza
					pizzas = deletePizza(getPizzaIndexByCode(pizzas, code), pizzas);
					
					
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

	private static Pizza[] addPizza(Pizza[] old, Pizza pizza) {
		Pizza[] pizzas = Arrays.copyOf(old, old.length + 1);
		pizzas[pizzas.length - 1] = pizza;
		return pizzas;
	}

	private static void showPizzas(Pizza[] pizzas) {
		for (int i = 0; i < pizzas.length; i++) {
			System.out.println(
					pizzas[i].getCode() + " -> " + pizzas[i].getLabelle() + " (" + pizzas[i].getPrix() + " €)");
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

		return new Pizza(code, labelle, prix, null);
	}

	private static void editPizzaProcess(Pizza newPizza, Pizza pizza) {
		pizza.setCode(newPizza.getCode());
		pizza.setLabelle(newPizza.getLabelle());
		pizza.setPrix(newPizza.getPrix());
	}

	private static int getPizzaIndexByCode(Pizza[] pizza, String code) {
		for (int i = 0; i < pizza.length; i++) {
			if(pizza[i].getCode().equals(code)) return i;
		}
		return -1;
	}
	
	private static Pizza[] deletePizza(int index, Pizza[] pizzas) {
		pizzas[index] = null;
		Pizza[] newTab = {};
		for (int i = 0; i < pizzas.length; i++) {
			if(pizzas[i] != null)
				newTab = addPizza(newTab, pizzas[i]);
		}
		return newTab;
	}
}
