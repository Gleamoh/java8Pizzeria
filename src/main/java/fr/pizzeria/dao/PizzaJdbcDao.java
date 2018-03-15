package fr.pizzeria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import fr.pizzeria.dao.jdbc.StatementJdbc;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class PizzaJdbcDao implements IPizzaDao {

	/** PizzaDao.java : IPizzaDao */
	private static IPizzaDao dao;

	/**
	 * Singleton dao
	 * 
	 * @return
	 */
	public static IPizzaDao getInstance() {
		if (dao == null)
			dao = new PizzaJdbcDao();
		return dao;
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		StatementJdbc jdbc = new StatementJdbc();

		ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");

		return pizzaList
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			StatementJdbc jdbc = new StatementJdbc();
			PreparedStatement preparedStatement = jdbc.rebuildStatement().getConnection().prepareStatement(
					"INSERT INTO pizza (code, labelle, prix, categorie_id) " + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, pizza.getCode());
			preparedStatement.setString(2, pizza.getLabelle());
			preparedStatement.setDouble(3, pizza.getPrix());
			preparedStatement.setInt(4, pizza.getCategorie().getId());
			preparedStatement.executeUpdate();
			
			jdbc.CloseStatementAndConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		pizzaList.get(findPizzaIndexByCode(codePizza)).copyOf(pizza);

	}

	@Override
	public void deletePizza(String codePizza) {

		pizzaList.remove(findPizzaIndexByCode(codePizza));

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {

		for (Pizza pizza : pizzaList) {
			if (pizza.getCode().equals(codePizza))
				return pizza;
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {

		return (findPizzaByCode(codePizza) != null);
	}

	/**
	 * Trouver l'indexe d'une pizza en fonction de son code
	 * 
	 * @param codePizza
	 * @return
	 */
	private int findPizzaIndexByCode(String codePizza) {
		throw new NotImplementedException("Pas besoin avec JDBC");
	}

	@Override
	public Pizza findPizzayId(int id) {
		StatementJdbc jdbc = new StatementJdbc();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = jdbc.rebuildStatement().getConnection().prepareStatement(
					"SELECT * FROM pizza WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.CloseStatementAndConnection();
		return null;
	}
}
