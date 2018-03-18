/**
 * 
 */
package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.pizzeria.model.Pizza;

/**
 * @author kevin
 *
 */
public class PizzaPizzeriaDaoTest {

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#saveNew(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testSaveNew() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#update(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#delete(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#parseToList(java.sql.ResultSet)}.
	 */
	@Test
	public void testParseToList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#deletePizza(java.lang.String)}.
	 */
	@Test
	public void testDeletePizza() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#findPizzaByCode(java.lang.String)}.
	 */
	@Test
	public void testFindPizzaByCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaPizzeriaDao#findAll()}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testFindAll() throws SQLException {
		PizzaPizzeriaDao dao = new PizzaPizzeriaDao();
		List<Pizza> list = dao.findAll();
		assertNotNull(list);
		assertTrue(0 < list.size());
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaPizzeriaDao#findById(int)}.
	 */
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.pizzeria.dao.PizzaPizzeriaDao#findByLabel(java.lang.String)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testFindByLabel() throws SQLException {
		PizzaPizzeriaDao pdDaoImpl = new PizzaPizzeriaDao();

		Pizza p1 = pdDaoImpl.findByLabel(null);
		Pizza p2 = pdDaoImpl.findByLabel("Pépédrponi");
		Pizza p3 = pdDaoImpl.findByLabel("Pépéroni");

		assertNull(p1);
		assertNull(p2);
		assertNotNull(p3);
	}

	@Test(expected = NullPointerException.class)
	public void testFindByLabel_null() throws SQLException {

		try {
			PizzaPizzeriaDao pdDaoImpl = new PizzaPizzeriaDao();
			pdDaoImpl.findByLabel(null);
		} catch (RuntimeException e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

	}
}
