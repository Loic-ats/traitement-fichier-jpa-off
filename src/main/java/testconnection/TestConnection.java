package testconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TestConnection {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// recupere le fichier properties

		ResourceBundle db = ResourceBundle.getBundle("database");

		Connection connection = null;
		try {

			// enregistre le pilote
			Class.forName(db.getString("db.driver"));
			// creer la connection

			connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
					db.getString("db.pass"));
			// affiche la connexion
			boolean valid = connection.isValid(500);
			if (valid) {
				System.out.println("la connexion est ok");
			} else {
				System.err.println("il y a deconnexion");
			}
		} catch (SQLException| ClassNotFoundException e) {

			System.err.println(" erreur de connexion" + e.getMessage());

		} finally {

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println("erreur de connexion " + e.getMessage());
			}
			System.out.println(" base deconnecté");

		}

	}

}
