package fr.pizzeria.main;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.impl.CategoryDaoImpl;
import fr.pizzeria.dao.impl.PizzaJdbcDaoImpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestJdbc {

	static final Logger LOGGER = LoggerFactory.getLogger(TestJdbc.class);
	public static void main(String[] args) {
		
		
		// Ajouter les catégorie
		CategoryDaoImpl c =new CategoryDaoImpl();
		PizzaJdbcDaoImpl pdDaoImpl = new PizzaJdbcDaoImpl();
		try {
			/*
			c.saveNew(new CategoriePizza("Viande", 0));
			c.saveNew(new CategoriePizza("Vegan", 0));
			c.saveNew(new CategoriePizza("Poisson", 0));
			c.saveNew(new CategoriePizza("Truc puch", 0));
			*/
			
			// afficher la liste
			
			LOGGER.info("Liste");
			for (CategoriePizza cat : c.findAll()) {
				
				LOGGER.info(cat.toString());
			}
			
			// ajouter pizza
			CategoriePizza vegan = c.findById(34);
			CategoriePizza viande = c.findById(35);
			CategoriePizza poisson = c.findById(36);
			
			pdDaoImpl.saveNew(new Pizza("PEP", "Pépéroni", 12.50, viande));
			
			LOGGER.info("Liste Pizzas");
			for (Pizza pit : pdDaoImpl.findAll()) {
				
				LOGGER.info(pit.toString());
			}
			
			
			/*
			// trouver une categorie
			
			LOGGER.info(c.findById(1).toString());
			LOGGER.info(c.findById(1).toString());
			LOGGER.info(c.findById(2).toString());
			LOGGER.info(c.findById(13).toString());
			LOGGER.info(c.findById(12).toString());
			
			// modifier
			CategoriePizza cat = c.findById(11);
			cat.setLabelle("Kekette surprise");
			c.update(cat);
			
			// supprimer une categorie
			cat = c.findById(1);
			c.delete(cat);
			*/
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
//		pizzaList = new ArrayList<>();
//		saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
//		saveNewPizza(new Pizza("MAR", "Margarita", 14.00, CategoriePizza.SANS_VIANDE));
//		saveNewPizza(new Pizza("rei", "La Reine", 11.00, CategoriePizza.VIANDE));
//		saveNewPizza(new Pizza("FRO", "La 4 formages", 12.00, CategoriePizza.SANS_VIANDE));
//		saveNewPizza(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
//		saveNewPizza(new Pizza("sav", "La savoyarde", 13.00, CategoriePizza.POISSON));
//		saveNewPizza(new Pizza("ORI", "L\'orientale", 13.50, CategoriePizza.VIANDE));
//		saveNewPizza(new Pizza("IND", "L\'indienne", 14.00, CategoriePizza.VIANDE));
//		
		
		
		//System.out.println((new StatementJdbc()).rebuildStatement());
		//System.out.println((new StatementJdbc()).rebuildStatement());
		//StatementJdbc jdbc = new StatementJdbc();
	
		
//		PizzaJdbcDao.getInstance();
	
	}
}
