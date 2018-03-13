package fr.pizzeria.main;

	
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
@Deprecated // Ne pas utiliser cette classe. Anciene version.
public class PizzeriaConsoleList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// tableau de pizza
		IPizzaDao pizzaDoa = PizzaDao.getInstance();

		try {
			pizzaDoa.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("MAR", "Margarita", 14.00, CategoriePizza.SANS_VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("REIN", "La Reine", 11.00, CategoriePizza.VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00, CategoriePizza.SANS_VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.POISSON));
			pizzaDoa.saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50, CategoriePizza.VIANDE));
			pizzaDoa.saveNewPizza(new Pizza("IND", "L\'indienne", 14.00, CategoriePizza.VIANDE));
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				showPizzas(pizzaDoa);
				break;
			}
			case 2: {

				System.out.println("\n");
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println("\n");
				try {
					pizzaDoa.saveNewPizza(editPizza(sc));
				} catch (SavePizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 3: {

				System.out.println("Mise à jour d’une pizza");
				showPizzas(pizzaDoa);
				System.out.print("Veuillez choisir le code de la pizza à modifier : ");
				String code = sc.nextLine();
				System.out.println("");
				// modifier la pizza
				try {
					pizzaDoa.updatePizza(code, editPizza(sc));
				} catch (UpdatePizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 4: {

				System.out.println("Suppression d’une pizza");
				showPizzas(pizzaDoa);
				System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
				String code = sc.nextLine();
				System.out.println("");
				// supprimer la pizza
				try {
					pizzaDoa.deletePizza(code);
				} catch (DeletePizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	private static void showPizzas(IPizzaDao pizzaMemDoa) {
		
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

		return new Pizza(code, labelle, prix, null);
	}

}