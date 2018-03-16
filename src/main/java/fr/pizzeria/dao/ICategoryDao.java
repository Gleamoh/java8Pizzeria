package fr.pizzeria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.jdbc.StatementJdbc;
import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Kevin M.
 *
 */
public class ICategoryDao implements IDao<CategoriePizza> {

	@Override
	public List<CategoriePizza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findById(int id) {

		StatementJdbc jdbc = new StatementJdbc();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = jdbc.rebuildStatement().getConnection()
					.prepareStatement("SELECT * FROM pizza WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			return 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.CloseStatementAndConnection();
		return null;
	}

	@Override
	public void saveNew(CategoriePizza t) throws SaveException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CategoriePizza t) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CategoriePizza t) throws DeleteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) throws DeleteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoriePizza> parseToList(ResultSet result) throws SQLException {
		List<CategoriePizza> list = new ArrayList<>();
		CategoriePizza categoriePizza = null;
		while (result.next()) {
			list.add(new CategoriePizza(result.getString("labelle"), result.getInt("id")));
		}
		return list;
	}

}
