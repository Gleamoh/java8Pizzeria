package fr.pizzeria.service;

import java.sql.SQLException;

import fr.pizzeria.dao.PizzaPizzeriaDao;
import fr.pizzeria.exception.PizzeriaException;
import fr.pizzeria.exception.SaveException;

/**
 * @author Kevin M.
 *
 */
public class AjouterPizzaService extends MenuPizzaService {
	/**
	 * pDao : PizzaJdbcDaoImpl
	 */
	PizzaPizzeriaDao pDao = new PizzaPizzeriaDao();

	/**
	 * Constructor
	 * 
	 */
	public AjouterPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws SaveException {

		System.out.println("########################################");
		System.out.println("#           NOUVELLE PIZZA             #");
		System.out.println("########################################");
		try {
			pDao.saveNew(editPizza());
		} catch (PizzeriaException | SQLException e) {
			throw new SaveException();
		}
		System.out.println("########################################");
		System.out.println();

	}

	// TODO ajouter les pizzas à la base
}
