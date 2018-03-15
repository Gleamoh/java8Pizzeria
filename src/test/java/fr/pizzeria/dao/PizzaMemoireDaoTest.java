package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemoireDaoTest {

	private static List<Pizza> list() {
		List<Pizza> list = new ArrayList<>();
		list.add(new Pizza(0, null, 0));
		list.add(new Pizza(1, null, 0));
		list.add(new Pizza(100, null, 0));
		list.add(new Pizza(-1, null, 0));

		list.add(new Pizza(null, null, 0, null));
		list.add(new Pizza("DDD", "dddddd", 0.4, CategoriePizza.POISSON));
		
		return list;
	}

	@Test
	public void testGetInstance() {
		assertTrue(PizzaMemoireDao.getInstance() instanceof PizzaMemoireDao);
		assertTrue(PizzaMemoireDao.getInstance() != null);
	}

	@Test
	public void testFindAllPizzas() {

		assertTrue(PizzaMemoireDao.getInstance().findAllPizzas() instanceof ArrayList);
		assertTrue(PizzaMemoireDao.getInstance().findAllPizzas() == null);
		assertTrue(PizzaMemoireDao.getInstance().findAllPizzas().size() == 8);
	}

	@Test
	public void testSaveNewPizzaWithValues() {
		// int est immuable il faut utiliser un AtomicInteger à la place
		AtomicInteger taille = new AtomicInteger(8);
		list().stream().forEachOrdered(p -> testSaveNewPizza(p, taille.incrementAndGet()));
	}

	private void testSaveNewPizza(Pizza p, int taille) {
		try {

			PizzaMemoireDao.getInstance().saveNewPizza(p);
			assertEquals(taille, PizzaMemoireDao.getInstance().findAllPizzas().size());

		} catch (SavePizzaException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPizzaByCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testPizzaExists() {
		fail("Not yet implemented");
	}

}
