package fr.pizzeria.service;

import java.util.Scanner;

import org.apache.commons.lang.math.NumberUtils;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public abstract class ServicePizzaMenu {

	/** ServicePizzaMenu.java : Scanner */
	private static Scanner scanner;

	/**
	 * Constructor
	 * 
	 */
	public ServicePizzaMenu() {

	}

	/**
	 * @throws PizzaException
	 */
	public abstract void executeUC() throws PizzaException;

	/**
	 * Afficher le menu de selection
	 */
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
		if (code.length() != 3 || PizzaDao.getInstance().pizzaExists(code) || code.equals(""))
			throw new UpdatePizzaException("Le code doit etre unique et au format  \"ABC\" !");

		System.out.print("Veuillez saisir le nom (sans espace) : ");
		String labelle = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir le prix : ");
		String prix = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir la catégorie [ <Viande> | <Sans Viande> | <Poisson> ]) : ");
		String categorie = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		// détecter la categorie en fonction du label
		CategoriePizza categoriePizza = CategoriePizza.findByLabel(categorie);
		
		// autre methode : trouver en fonction du nom de la categorie ex: SANS_VIANDE
		// CategoriePizza categoriePizza = CategoriePizza.valueOf(categorie.toUpperCase());
		
		if (categoriePizza == null) {
			throw new UpdatePizzaException("Veuillez renseigner une catégorie existante !");
		}

		// vérifier que le prix est bien un nombre
		if (!NumberUtils.isNumber(prix)) {
			throw new UpdatePizzaException("Le prix doit etre un nombre !");
		} else {
			double goodPrice = Double.parseDouble(prix);
			return new Pizza(code, labelle, goodPrice, categoriePizza);
		}

	}

	/**
	 * Getter
	 * 
	 * @return the scanner
	 */
	protected static Scanner getScanner() {
		if (scanner == null)
			return new Scanner(System.in);
		return scanner;
	}

	/**
	 * Setter
	 * 
	 * @param scanner
	 *            the scanner to set
	 */
	public static void setScanner(Scanner scanner) {
		ServicePizzaMenu.scanner = scanner;
	}

}
