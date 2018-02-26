package pizzeria;

import java.util.Scanner;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.service.ServicePizzaFactory;
import fr.pizzeria.service.ServicePizzaMenu;

public class PizzeriaConsoleFactory {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ServicePizzaMenu.setScanner(scanner);
		int choix = 0;

		while (true) {
			ServicePizzaMenu.ShowMenu();
			choix = Integer.parseInt(scanner.nextLine());

			if (4 >= choix && 1 <= choix) {
				try {
					ServicePizzaFactory.getService(choix).executeUC();
				} catch (PizzaException e) {
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
