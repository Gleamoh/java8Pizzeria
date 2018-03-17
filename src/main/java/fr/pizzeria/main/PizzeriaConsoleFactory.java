package fr.pizzeria.main;

import java.util.Scanner;

import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.service.FactoryPizzaService;
import fr.pizzeria.service.MenuPizzaService;

/**
 * @author Kevin M.
 *
 */
public class PizzeriaConsoleFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		MenuPizzaService.setScanner(scanner);
		int choix = 0;

		while (true) {
			MenuPizzaService.ShowMenu();
			choix = Integer.parseInt(scanner.nextLine());

			if (4 >= choix && 1 <= choix) {
				try {
					FactoryPizzaService.getService(choix).executeUC();
				} catch (PizzeriaException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} else if (99 == choix) {
				System.out.println("Aurevoir ☹");
				break;
			} else {
				System.out.println("Merci de saisir une option correcte !\n");
			}
		}
	}
}
