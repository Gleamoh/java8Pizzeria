package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.NotImplementedException;

import fr.pizzeria.model.CategoriePizza;

/**
 * @author Kevin M.
 *
 */
public class CategorieDao implements IDao<CategoriePizza> {

	private EntityManagerFactory emf;

	/**
	 * Constructor
	 * 
	 */
	public CategorieDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<CategoriePizza> findAll() {

		EntityManager em = emf.createEntityManager();
		TypedQuery<CategoriePizza> query = em.createQuery("from CategoryPizza c", CategoriePizza.class);
		List<CategoriePizza> categoriePizzas = query.getResultList();

		em.close();

		return categoriePizzas;
	}

	@Override
	public CategoriePizza findById(int id) {
		EntityManager em = emf.createEntityManager();
		CategoriePizza categoriePizza = em.find(CategoriePizza.class, id);
		em.close();
		return categoriePizza;
	}

	@Override
	public void saveNew(CategoriePizza categoriePizza) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(categoriePizza);
		et.commit();
		em.close();

	}

	@Override
	public void update(CategoriePizza categoriePizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(categoriePizza);
		et.commit();
		em.close();
	}

	@Override
	public void delete(CategoriePizza categoriePizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(categoriePizza);
		et.commit();
		em.close();
	}

	@Override
	public List<CategoriePizza> parseToList(ResultSet result) {
		throw new NotImplementedException();
	}

	@Override
	public List<CategoriePizza> findByLabel(String labelle) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<CategoriePizza> query = em.createQuery("from CategoriePizza c where c.labelle = :labelle ",
				CategoriePizza.class);
		query.setParameter("labelle", labelle);
		List<CategoriePizza> categoriePizzas = query.getResultList();
		em.close();
		
		return  categoriePizzas;
	}

}
