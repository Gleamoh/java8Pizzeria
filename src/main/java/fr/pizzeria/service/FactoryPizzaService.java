package fr.pizzeria.service;

/**
 * @author ETY0006
 *
 */
public class FactoryPizzaService {
	
	/**
	 * Génère les instances de service
	 * @param choix
	 * @return
	 */
	public static MenuPizzaService getService(int choix) {
		switch (choix) {
		case 1: // list
			return new ListerPizzaService();
		case 2: // add
			return new AjouterPizzaService();
		case 3: // modifier
			return new ModifierPizzaService();
		case 4: // supprimer
			return new SupprimerPizzaService();
		case 5: // ajouter la liste de pizza dans la base
			return new InflateDataPizzaService();
		case 6:
			return new DeleteAllPizzasService();
		default:
			return null;
		}
	}
}
