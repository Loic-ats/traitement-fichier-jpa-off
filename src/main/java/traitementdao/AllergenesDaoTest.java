package traitementdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import objets.Allergenes;
import objets.Produits;

public class AllergenesDaoTest implements AllergenesDao{

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
	public void insertAllergenes(Connection conn, Produits produits) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		List<Allergenes>allergenes = produits.getAllergenes();
		
		
		for (Allergenes allergene : allergenes) {

			statement = conn.createStatement();

			ResultSet res = statement.executeQuery(

					"SELECT ID, NOM FROM INGREDIENTS WHERE nom='" + allergene.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				allergene.setid(id);

			} else {

				statement.executeUpdate(

						"INSERT INTO INGREDIENTS (NOM) VALUES ('" + allergene.getNom().replace("'", "''") + "')");

				res = statement.executeQuery(

						"SELECT ID, NOM FROM INGREDIENTS WHERE nom='" + allergene.getNom().replace("'", "''") + "'");

				if (res.next()) {

					Long id = res.getLong("ID");

					allergene.setid(id);

				}

			}

		}
		
	}
}