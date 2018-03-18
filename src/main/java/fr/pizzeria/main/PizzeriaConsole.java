package fr.pizzeria.main;

import java.util.Scanner;

import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.service.FactoryPizzaService;
import fr.pizzeria.service.MenuPizzaService;

/**
 * @author Kevin M.
 *
 */
public class PizzeriaConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		MenuPizzaService.setScanner(scanner);
		int choix = 0;

		while (true) {
			MenuPizzaService.ShowMenu();
			String choixBrut = scanner.nextLine().trim();
			if(choixBrut.matches("[0-9]"))
			choix = Integer.parseInt(choixBrut);

			if (5 >= choix && 1 <= choix) {
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
