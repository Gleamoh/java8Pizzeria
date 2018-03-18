package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.jdbc.StatementJdbc;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class PizzaPizzeriaDao implements PizzeriaDao {

	/**
	 * FFF dao : PizzaDao
	 */
	private static PizzeriaDao dao;

	/**
	 * Singleton dao
	 * 
	 * @return
	 */
	public static PizzeriaDao getInstance() {
		if (dao == null)
			dao = new PizzaPizzeriaDao();
		return dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza) throws SQLException {
		return (findPizzaByCode(codePizza) != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#saveNew(java.lang.Object)
	 */
	@Override
	public void saveNew(Pizza pizza) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO pizza (code, labelle, prix, id_categorie) " + "VALUES (?, ?, ?, ?)");
		preparedStatement.setString(1, pizza.getCode());
		preparedStatement.setString(2, pizza.getLabelle());
		preparedStatement.setDouble(3, pizza.getPrix());
		preparedStatement.setInt(4, pizza.getCategorie().getId());
		preparedStatement.executeUpdate();
		
		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Pizza pizza) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE pizza SET code=?, labelle=?, id_categorie=? WHERE id=?");
		preparedStatement.setString(1, pizza.getCode());
		preparedStatement.setString(2, pizza.getLabelle());
		preparedStatement.setInt(3, pizza.getCategorie().getId());
		preparedStatement.setInt(4, pizza.getId());
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Pizza t) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pizza WHERE id=?");
		preparedStatement.setInt(1, t.getId());
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#parseToList(java.sql.ResultSet)
	 */
	@Override
	public List<Pizza> parseToList(ResultSet result) throws SQLException {
		List<Pizza> list = new ArrayList<>();
		CategoriePizza categoriePizza = null;

		while (result.next()) {
			categoriePizza = new CategoriePizza(null, result.getInt("id_categorie"));
			
			Pizza pizza = new Pizza(result.getString("code"), result.getString("labelle"), result.getDouble("prix"),
					categoriePizza);
			pizza.setId(result.getInt("id"));
			list.add(pizza);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#updatePizza(java.lang.String,
	 * fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE pizza SET code = ?, labelle = ?, id_categorie = ? WHERE code=?");
		preparedStatement.setString(1, pizza.getCode());
		preparedStatement.setString(2, pizza.getLabelle());
		preparedStatement.setInt(3, pizza.getCategorie().getId());
		preparedStatement.setString(4, codePizza);
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pizza WHERE code=?");
		preparedStatement.setString(1, codePizza);
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.PizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();

		PreparedStatement preparedStatement = jdbc.rebuildStatement().getConnection()
				.prepareStatement("SELECT * FROM pizza WHERE code = ? LIMIT 1");
		preparedStatement.setString(1, codePizza);
		ResultSet resultSet = preparedStatement.executeQuery();

		List<Pizza> pizzas = parseToList(resultSet);
		Pizza pizza = null;
		if (!pizzas.isEmpty()) {
			pizza = pizzas.get(0);
		}
		preparedStatement.close();
		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return pizza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#findAll()
	 */
	@Override
	public List<Pizza> findAll() throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();

		ResultSet resultSet = jdbc.rebuildStatement().executeQuery("SELECT * FROM pizza");
		List<Pizza> list = parseToList(resultSet);

		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.Dao#findById(int)
	 */
	@Override
	public Pizza findById(int id) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();

		PreparedStatement preparedStatement = jdbc.rebuildStatement().getConnection()
				.prepareStatement("SELECT * FROM pizza WHERE id = ? LIMIT 1");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		List<Pizza> pizzas = parseToList(resultSet);
		Pizza pizza = null;
		if (!pizzas.isEmpty()) {
			pizza = pizzas.get(0);
		}

		preparedStatement.close();
		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return pizza;
	}

	@Override
	public Pizza findByLabel(String labelle) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		PreparedStatement preparedStatement;

		preparedStatement = jdbc.rebuildStatement().getConnection()
				.prepareStatement("SELECT * FROM pizza WHERE labelle = ? LIMIT 1");
		preparedStatement.setString(1, labelle);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Pizza> pizzas = parseToList(resultSet);
		Pizza pizza = null;
		if (!pizzas.isEmpty()) {
			pizza = pizzas.get(0);
		}

		preparedStatement.close();
		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return pizza;
	}
}
