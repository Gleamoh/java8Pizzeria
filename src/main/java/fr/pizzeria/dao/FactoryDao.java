package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.model.CategoriePizza;

public class FactoryDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizza");
	
	public static Dao<CategoriePizza> getCategorieDao() {
		return new CategorieDao(emf);
	}
	
	public static PizzeriaDao getPizzaDao() {
		return new PizzaPizzeriaDao(emf);
	}
}
