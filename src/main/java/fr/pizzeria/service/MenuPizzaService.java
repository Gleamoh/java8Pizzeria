package fr.pizzeria.service;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.lang.math.NumberUtils;

import fr.pizzeria.dao.CategoryDao;
import fr.pizzeria.dao.PizzaPizzeriaDao;
import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public abstract class MenuPizzaService {

	/** ServicePizzaMenu.java : Scanner */
	private static Scanner scanner;

	/**
	 * pDao : PizzaJdbcDaoImpl
	 */
	PizzaPizzeriaDao pDao = new PizzaPizzeriaDao();

	/**
	 * cDao : CategoryDaoImpl
	 */
	CategoryDao cDao = new CategoryDao();

	/**
	 * Constructor
	 * 
	 */
	public MenuPizzaService() {

	}

	/**
	 * @throws PizzeriaException
	 */
	public abstract void executeUC() throws PizzeriaException;

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
		System.out.println("*   5. Générer les pizzas             *");
		System.out.println("*   99. Sortir                        *");
		System.out.println("*                                     *");
		System.out.println("***************************************");
		System.out.println("\n");
	}

	/**
	 * Affiche l'interface d'edition d'une pizza
	 * 
	 * @return Pizza
	 * @throws PizzeriaException 
	 * @throws UpdatePizzaException
	 *             lève cette exception si la saisie de l'utilisateur est
	 *             incorrecte
	 */
	protected Pizza editPizza() throws PizzeriaException {
		
		
		System.out.println("----------------------------------------");
		System.out.print("Veuillez saisir le code : ");
		String code = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		// vérifie que le code est unique et a une taille de 3
		try {
			if (code.length() != 3 || pDao.pizzaExists(code) || code.equals(""))
				throw new UpdateException("Le code doit etre unique et au format  \"ABC\" !");
		} catch (SQLException e1) {
			throw new PizzeriaException("La pizza n'existe pas");
		}

		System.out.print("Veuillez saisir le nom : ");
		String labelle = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir le prix : ");
		String prix = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		System.out.print("Veuillez saisir la catégorie [ Viande | Vegan | Poisson ]) : ");
		String categorie = scanner.nextLine().trim();
		System.out.println("----------------------------------------");

		// détecter la categorie en fonction du label
		CategoriePizza categoriePizza;
		try {
			categoriePizza = cDao.findByLabel(categorie);
		} catch (SQLException e) {
			throw new PizzeriaException("Aucune pizza trouvée pour ce code");
		}
		
		if (categoriePizza == null) {
			throw new UpdateException("Veuillez renseigner une catégorie existante !");
		}

		// vérifier que le prix est bien un nombre
		if (!NumberUtils.isNumber(prix)) {
			throw new UpdateException("Le prix doit etre un nombre !");
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
		MenuPizzaService.scanner = scanner;
	}

}
