package fr.pizzeria.service;

import java.util.Scanner;

import org.apache.commons.lang.math.NumberUtils;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
			try {
				pizzaMemDoa.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50));
				pizzaMemDoa.saveNewPizza(new Pizza("MAR", "Margarita", 14.00));
				pizzaMemDoa.saveNewPizza(new Pizza("REIN", "La Reine", 11.00));
				pizzaMemDoa.saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00));
				pizzaMemDoa.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50));
				pizzaMemDoa.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00));
				pizzaMemDoa.saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50));
				pizzaMemDoa.saveNewPizza(new Pizza("IND", "L\'indienne", 14.00));
			} catch (SavePizzaException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void executeUC() throws PizzaException;

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

	/**
	 * Affiche l'interface d'edition d'une pizza
	 * 
	 * @return Pizza
	 * @throws UpdatePizzaException
	 *             lève cette exception si la saisie de l'utilisateur est
	 *             incorrecte
	 */
	protected Pizza editPizza() throws UpdatePizzaException {

		System.out.println("----------------------------------------");
		System.out.print("Veuillez saisir le code : ");
		String code = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		// vérifie que le code est unique et a une taille de 3
		if (code.length() != 3 || (new PizzaDao()).pizzaExists(code) || code.equals(""))
			throw new UpdatePizzaException("Le code doit etre unique et au format  \"ABC\" !");

		System.out.print("Veuillez saisir le nom (sans espace) : ");
		String labelle = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir le prix : ");
		String prix = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		// vérifier que le prix est bien un nombre
		if (!NumberUtils.isDigits(prix)) {
			throw new UpdatePizzaException("Le prix doit etre un nombre !");
		} else {
			double goodPrice = Double.parseDouble(prix);
			return new Pizza(code, labelle, goodPrice);
		}

	}

}
