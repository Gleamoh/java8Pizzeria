package fr.pizzeria.service;

import java.util.stream.Stream;

import fr.pizzeria.dao.CategoryDao;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaPizzeriaDao;
import fr.pizzeria.dao.PizzeriaDao;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class InflateDataPizzaService extends MenuPizzaService {
	/**
	 * pDao : PizzaJdbcDaoImpl
	 */
	PizzeriaDao pDao = new PizzaPizzeriaDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.service.ServicePizzaMenu#executeUC()
	 */
	@Override
	public void executeUC() throws SaveException {

		Dao<CategoriePizza> cDao = new CategoryDao();
		CategoriePizza vegan;

		vegan = cDao.findByLabel("Vegan");
		CategoriePizza viande = cDao.findByLabel("Viande");
		CategoriePizza poisson = cDao.findByLabel("Poisson");
		Pizza[] list = new Pizza[] { new Pizza("PEP", "Pépéroni", 12.50, viande),
				new Pizza("MAR", "Margarita", 14.00, vegan), new Pizza("REI", "La Reine", 11.00, viande),
				new Pizza("FRO", "La 4 formages", 12.00, vegan), new Pizza("CAN", "La cannibale", 12.50, vegan),
				new Pizza("SAV", "La savoyarde", 13.00, poisson), new Pizza("ORI", "L''orientale", 13.50, viande),
				new Pizza("IND", "L''indienne", 14.00, viande) };

		Stream.of(list).forEach(p -> pDao.saveNew(p));

	}

}
