package pizzeria;

import java.util.Scanner;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.service.ServicePizzaAjouter;
import fr.pizzeria.service.ServicePizzaLister;
import fr.pizzeria.service.ServicePizzaMenu;
import fr.pizzeria.service.ServicePizzaModifier;
import fr.pizzeria.service.ServicePizzaSupprimer;

/**
 * @author Kevin M.
 *
 */
@Deprecated // Ne pas utiliser cette classe. Anciene version.
public class PizzeriaConsoleService {
	public static void main(String[] args) throws UpdatePizzaException {

		Scanner scanner = new Scanner(System.in);
		ServicePizzaMenu.setScanner(scanner);
		int choix = 0;

		while (true) {
			if (choix == 99) {
				System.out.println("Aurevoir ☹");
				break;
			}
			ServicePizzaMenu.ShowMenu();
			choix = Integer.parseInt(scanner.nextLine());

			switch (choix) {
			case 1: // list
				(new ServicePizzaLister()).executeUC();
				break;
			case 2: // add
				(new ServicePizzaAjouter()).executeUC();
				break;
			case 3: // modifier
				(new ServicePizzaLister()).executeUC();
				(new ServicePizzaModifier()).executeUC();
				break;
			case 4: // supprimer
				(new ServicePizzaLister()).executeUC();
				(new ServicePizzaSupprimer()).executeUC();
				break;
			default:
				System.out.println("Merci de saisir une option correcte !");
				break;
			}
		}
	}
}
