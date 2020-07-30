package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import objets.Additifs;
import objets.Produits;

public class AdditifDaoTest implements AdditifsDao{

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
	public void insertAdditifs(Connection conn, Produits produits) throws SQLException {
		
		
		List<Additifs> additifs = produits.getAdditif();
		
		Statement statement = conn.createStatement();
		
		
		for (Additifs additif : additifs) {

			statement = conn.createStatement();

			ResultSet res = statement.executeQuery("SELECT ID, NOM FROM ADDITIFS WHERE nom='"

					+ additif.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				additif.setId(id);

			} else {

				statement.executeUpdate("INSERT INTO allergenes (NOM) VALUES ('"

						+  additif.getNom().replace("'", "''") + "')");

				res = statement.executeQuery("SELECT ID, NOM FROM INGREDIENTS WHERE nom='"

						+  additif.getNom().replace("'", "''") + "'");

				if (res.next()) {

					Long id = res.getLong("ID");

					additif.setId(id);

				}

			}

		}
			
		
	}
	
}
