package fr.pizzeria.service;

import java.util.stream.Stream;

import fr.pizzeria.dao.PizzaJdbcDao;
import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class InflateDataPizzaService extends ServicePizzaMenu {

	/*
	 * (non-Javadoc)
	 * @see fr.pizzeria.service.ServicePizzaMenu#executeUC()
	 */
	@Override
	public void executeUC() throws PizzeriaException {
		
		// TODO récupérer les catégories de la base
		CategoriePizza viande = new CategoriePizza("Viande", 1);
		CategoriePizza vegan = new CategoriePizza("Vegan", 1);
		CategoriePizza poisson = new CategoriePizza("Poisson", 1);

		Pizza[] eePizzas = new Pizza[] { 
				new Pizza("PEP", "Pépéroni", 12.50, viande),
				new Pizza("MAR", "Margarita", 14.00, vegan), 
				new Pizza("rei", "La Reine", 11.00, viande),
				new Pizza("FRO", "La 4 formages", 12.00, vegan), 
				new Pizza("CAN", "La cannibale", 12.50, vegan),
				new Pizza("sav", "La savoyarde", 13.00, poisson), 
				new Pizza("ORI", "L\'orientale", 13.50, viande),
				new Pizza("IND", "L\'indienne", 14.00, viande) };

		Stream.of(eePizzas).forEach(p -> {
			try {
				PizzaJdbcDao.getInstance().saveNewPizza(p);
			} catch (SavePizzaException e) {
				e.printStackTrace();
			}
		});

	}

}
