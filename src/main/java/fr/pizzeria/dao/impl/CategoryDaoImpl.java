package fr.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.jdbc.StatementJdbc;
import fr.pizzeria.model.CategoriePizza;

/**
 * @author Kevin M.
 *
 */
public class CategoryDaoImpl implements Dao<CategoriePizza> {

	@Override
	public List<CategoriePizza> findAll() throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		ResultSet resultSet = jdbc.rebuildStatement()
				.executeQuery("SELECT * FROM categorie");
		
		List<CategoriePizza> list = parseToList(resultSet);

		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return list;
	}

	@Override
	public CategoriePizza findById(int id) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		PreparedStatement preparedStatement;

		preparedStatement = jdbc.rebuildStatement().getConnection()
				.prepareStatement("SELECT * FROM categorie WHERE id = ? LIMIT 1");
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		CategoriePizza categoriePizza = parseToList(resultSet).get(0);

		preparedStatement.close();
		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return categoriePizza;
	}

	@Override
	public void saveNew(CategoriePizza t) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO categorie (labelle) VALUES (?)");
		preparedStatement.setString(1, t.getLabelle());
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	@Override
	public void update(CategoriePizza t) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE categorie SET labelle=? WHERE id=?");
		preparedStatement.setString(1, t.getLabelle());
		preparedStatement.setInt(2, t.getId());
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	@Override
	public void delete(CategoriePizza t) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		Connection connection = jdbc.rebuildStatement().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM categorie WHERE id=?");
		preparedStatement.setInt(1, t.getId());
		preparedStatement.executeUpdate();

		connection.commit();
		preparedStatement.close();
		jdbc.CloseStatementAndConnection();
	}

	@Override
	public List<CategoriePizza> parseToList(ResultSet result) throws SQLException {
		List<CategoriePizza> list = new ArrayList<>();
		while (result.next()) {
			list.add(new CategoriePizza(result.getString("labelle"), result.getInt("id")));
		}
		return list;
	}

	@Override
	public CategoriePizza findByLabel(String labelle) throws SQLException {
		StatementJdbc jdbc = new StatementJdbc();
		PreparedStatement preparedStatement;

		preparedStatement = jdbc.rebuildStatement().getConnection()
				.prepareStatement("SELECT * FROM categorie WHERE labelle = ? LIMIT 1");
		preparedStatement.setString(1, labelle);

		ResultSet resultSet = preparedStatement.executeQuery();

		CategoriePizza categoriePizza = parseToList(resultSet).get(0);

		preparedStatement.close();
		resultSet.close();
		jdbc.CloseStatementAndConnection();

		return categoriePizza;
	}
	
	

}
