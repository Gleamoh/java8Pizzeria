package fr.pizzeria.service;

import java.sql.SQLException;

import fr.pizzeria.dao.impl.PizzaJdbcDaoImpl;
import fr.pizzeria.exception.DeleteException;

/**
 * 
 * @author Kevin M.
 */
public class SupprimerPizzaService extends MenuPizzaService {
	/**
	 * pDao : PizzaJdbcDaoImpl
	 */
	PizzaJdbcDaoImpl pDao = new PizzaJdbcDaoImpl();

	/**
	 * Constructor
	 * 
	 */
	public SupprimerPizzaService() {
		super();
	}

	@Override
	public void executeUC() throws DeleteException {

		System.out.println("########################################");
		System.out.println("#           SUPPRIMER PIZZA            #");
		System.out.println("########################################");
		System.out.print("Veuillez choisir le code de la pizza à supprimer : ");
		String codePizza = getScanner().nextLine();
		System.out.println("########################################");
		System.out.println();
		// supprimer la pizza
		try {
			pDao.deletePizza(codePizza);
		} catch (SQLException e) {
			throw new DeleteException();
		}

	}

}
