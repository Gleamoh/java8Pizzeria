package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.model.CategoriePizza;

public class FactoryDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizza");
	
	public static IDao<CategoriePizza> getCategorieDao() {
		return new CategorieDao(emf);
	}
	
	public static IPizzeriaDao getPizzaDao() {
		return new PizzaPizzeriaDao(emf);
	}
}
