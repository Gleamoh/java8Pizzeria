package fr.pizzeria.service;

import java.util.stream.Stream;

import fr.pizzeria.dao.FactoryDao;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class InflateDataPizzaService extends MenuPizzaService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.service.ServicePizzaMenu#executeUC()
	 */
	@Override
	public void executeUC() throws SaveException {

		// Ajouter les categories
		
		FactoryDao.getCategorieDao().saveNew(new CategoriePizza(0, "Vegan", null));
		FactoryDao.getCategorieDao().saveNew(new CategoriePizza(0, "Viande", null));
		FactoryDao.getCategorieDao().saveNew(new CategoriePizza(0, "Poisson", null));
		
		CategoriePizza vegan = FactoryDao.getCategorieDao().findByLabel("Vegan").get(0);
		CategoriePizza viande = FactoryDao.getCategorieDao().findByLabel("Viande").get(0);
		CategoriePizza poisson = FactoryDao.getCategorieDao().findByLabel("Poisson").get(0);
		Pizza[] list = new Pizza[] { 
				new Pizza("PEP", "Pépéroni", 12.50, viande),
				new Pizza("MAR", "Margarita", 14.00, vegan), new Pizza("REI", "La Reine", 11.00, viande),
				new Pizza("FRO", "La 4 formages", 12.00, vegan), new Pizza("CAN", "La cannibale", 12.50, vegan),
				new Pizza("SAV", "La savoyarde", 13.00, poisson), new Pizza("ORI", "L''orientale", 13.50, viande),
				new Pizza("IND", "L''indienne", 14.00, viande) };

		Stream.of(list).forEach(p -> FactoryDao.getPizzaDao().saveNew(p));
		

	}

}
