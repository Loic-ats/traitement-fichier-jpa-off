package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import objets.Ingredients;
import objets.Produits;


public class IngredientsDaoTest implements IngredientsDao{

	public Connection getConnection() {

		// recupere fichier properties

		ResourceBundle db = ResourceBundle.getBundle("database");

		try {

			// enregistre le pilote

			Class.forName(db.getString("db.driver"));

			return DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),

					db.getString("db.pass"));

		} catch (ClassNotFoundException | SQLException e) {

			throw new RuntimeException();

		}

	}

	@Override
	public void insertIngredients(Connection conn, Produits produits) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		List<Ingredients> ingredients = produits.getIngredient();

		for (Ingredients ingredient : ingredients) {

			statement = conn.createStatement();

			ResultSet res = statement.executeQuery(

					"SELECT ID, NOM FROM INGREDIENTS WHERE nom='" + ingredient.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				ingredient.setid(id);

			} else {

				statement.executeUpdate(

						"INSERT INTO INGREDIENTS (NOM) VALUES ('" + ingredient.getNom().replace("'", "''") + "')");

				res = statement.executeQuery(

						"SELECT ID, NOM FROM INGREDIENTS WHERE nom='" + ingredient.getNom().replace("'", "''") + "'");

				if (res.next()) {

					Long id = res.getLong("ID");

					ingredient.setid(id);

				}

			}

		}
		
	}
	
}