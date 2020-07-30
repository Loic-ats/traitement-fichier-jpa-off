package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import objets.Marques;
import objets.Produits;

public class MarquesDaoTest implements MarquesDao {

	@Override
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
	public void insererMarques(Connection conn, Produits produits) throws SQLException {

		Statement statement = conn.createStatement();

		Marques marque = produits.getMarque();

		statement = conn.createStatement();

		ResultSet res = statement
				.executeQuery("SELECT ID, NOM FROM MARQUES WHERE nom='" + marque.getNom().replace("'", "''") + "'");

		if (res.next()) {

			Long id = res.getLong("ID");

			marque.setId(id);

		} else {

			statement.executeUpdate("INSERT INTO MARQUES (NOM) VALUES ('" + marque.getNom().replace("'", "''") + "')");

			res = statement

					.executeQuery("SELECT ID, NOM FROM MARQUES WHERE nom='" + marque.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				marque.setId(id);

			}

		}
		
		res.close();
		statement.close();

	}

}
