package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ResourceBundle;
import objets.Categories;
import objets.Produits;


public class CategoriesDaoTest implements CategoriesDao{

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

	public void insertCategories(Connection conn, Produits produits) throws SQLException {
			

		Categories categories = produits.getCategorie();

		Statement statement = conn.createStatement();

		ResultSet res = statement.executeQuery(

				"SELECT ID, NOM FROM CATEGORIES WHERE nom='" + categories.getNom().replace("'", "''") + "'");

		if (res.next()) {

			Long id = res.getLong("ID");

			categories.setid(id);

		} else {

			statement.executeUpdate(

					"INSERT INTO CATEGORIES (NOM) VALUES ('" + categories.getNom().replace("'", "''") + "')");

			res = statement.executeQuery(

					"SELECT ID, NOM FROM CATEGORIES WHERE nom='" + categories.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				categories.setid(id);

			}
		}
		
	}
	
}
