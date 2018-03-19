package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.NotImplementedException;

import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class PizzaPizzeriaDao implements PizzeriaDao {

	EntityManagerFactory emf;

	/**
	 * Constructor
	 * 
	 */
	public PizzaPizzeriaDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		return (findPizzaByCode(codePizza) != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#saveNew(java.lang.Object)
	 */
	@Override
	public void saveNew(Pizza pizza) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Pizza pizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(pizza);
		et.commit();
		em.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Pizza pizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(pizza);
		et.commit();
		em.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#parseToList(java.sql.ResultSet)
	 */
	@Override
	public List<Pizza> parseToList(ResultSet result) {
		throw new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#updatePizza(java.lang.String,
	 * fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		Pizza newPizza = findPizzaByCode(codePizza).get(0);
		newPizza.setCategorie(pizza.getCategorie());
		newPizza.setCode(pizza.getCode());
		newPizza.setId(pizza.getId());
		newPizza.setLabelle(pizza.getLabelle());
		newPizza.setPrix(pizza.getPrix());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(findPizzaByCode(codePizza).get(0));
		et.commit();
		em.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public List<Pizza> findPizzaByCode(String codePizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		TypedQuery<Pizza> query = em.createQuery("from Pizza p where p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#findAll()
	 */
	@Override
	public List<Pizza> findAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		TypedQuery<Pizza> query = em.createQuery("from Pizza", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#findById(int)
	 */
	@Override
	public Pizza findById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Pizza pizza = em.find(Pizza.class, id);
		em.close();
		return pizza;
	}

	@Override
	public List<Pizza> findByLabel(String labelle) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("from Pizza p where p.labelle = :labelle ", Pizza.class);
		query.setParameter("labelle", 1);
		return query.getResultList();
	}
}
