package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import objets.Marques;

public class MarquesDaoTest {

	public MarquesDaoTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Marques> extraire() {

		Connection connection = null;

		List<Marques> listeMar = new ArrayList<Marques>();

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			ResultSet monResultat = monCanal.executeQuery("SELECT * FROM marques;");

			while (monResultat.next()) {

				// tant que cest vrai on continue

				listeMar.add(new Marques(monResultat.getInt("ID"), monResultat.getString("nom")));

			}

			monResultat.close();

			monCanal.close();

		} catch (Exception e) {

			System.err.println("erreur d'execution" + e.getMessage());

		} finally {

			try {

				if (connection != null)

					connection.close();

			} catch (SQLException e) {

				System.err.println("probleme de connexion" + e.getMessage());

			}

		}

		return listeMar;
	}

	public void insert(Marques marques) {

		Connection connection = null;

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			int nb = monCanal.executeUpdate(

				 "insert into marques (ID, nom) " + 

			"values (" 

			+ marques.getId() + ",'"

			+ marques.getNom() + "',;");

			if (nb == 1) {

				System.out.println("marques ajouté!");

			}

			monCanal.close();

		} catch (Exception e) {


			System.err.println("Probleme de connexion" + e.getMessage());

		} finally {

			try {

				if (connection != null)

					connection.close();

			} catch (SQLException e) {

				System.err.println("Probleme de connexion" + e.getMessage());

			}
		}

	}

	public int update(String ancienNom, String nouveauNom) {

		Connection connection = null;

		int nb = 0;

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			nb = monCanal

					.executeUpdate(

							"update marques SET nom='" + nouveauNom + 

							"' where nom='" + ancienNom + "';");

			monCanal.close();

		} catch (Exception e) {

			System.err.println("erreur d'execution" + e.getMessage());

		} finally {

			try {

				if (connection != null)

					connection.close();

			} catch (SQLException e) {

				System.err.println("Probleme de connexion" + e.getMessage());

			}

		}

		return nb;
	}

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

}
