package fr.pizzeria.service;

public class ServicePizzaFactory {
	
	public static ServicePizzaMenu getService(int choix) {
		switch (choix) {
		case 1: // list
			return new ServicePizzaLister();
		case 2: // add
			return new ServicePizzaAjouter();
		case 3: // modifier
			return new ServicePizzaModifier();
		case 4: // supprimer
			return new ServicePizzaSupprimer();
		default:
			return null;
		}
	}
}
