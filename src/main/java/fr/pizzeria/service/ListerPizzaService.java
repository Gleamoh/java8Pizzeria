package fr.pizzeria.service;

import java.sql.SQLException;

import fr.pizzeria.dao.impl.PizzaJdbcDaoImpl;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class ListerPizzaService extends MenuPizzaService {
	
	private PizzaJdbcDaoImpl pizzaDao = new PizzaJdbcDaoImpl();
	
	/** Constructor
	 * 
	 */
	public ListerPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws SaveException {

		System.out.println("########################################");
		System.out.println("#              NOS PIZZAS              #");
		System.out.println("########################################");
		
		try {
			for (Pizza pizza : pizzaDao.findAll()) {
				System.out.println("#    " + pizza);
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			
			throw new SaveException();
		}
		
		System.out.println("########################################");
		System.out.println("\n");
	}

}
