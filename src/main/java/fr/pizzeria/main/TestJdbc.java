package fr.pizzeria.main;

import fr.pizzeria.dao.PizzaJdbcDao;
import fr.pizzeria.dao.jdbc.StatementJdbc;

public class TestJdbc {

	public static void main(String[] args) {
		System.out.println((new StatementJdbc()).rebuildStatement());
		System.out.println((new StatementJdbc()).rebuildStatement());
		StatementJdbc jdbc = new StatementJdbc();
		
		PizzaJdbcDao.getInstance();
	
	}
}
