package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import objets.Additifs;

public class AdditifsDaoTest implements AdditifsDao{

	public AdditifsDaoTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Additifs> extraire() {

		Connection connection = null;

		List<Additifs> listeAdd = new ArrayList<Additifs>();

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			ResultSet monResultat = monCanal.executeQuery("SELECT * FROM additifs;");

			while (monResultat.next()) {

				// tant que cest vrai on continue

				listeAdd.add(new Additifs(monResultat.getInt("ID"), monResultat.getString("nom")));

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

		return listeAdd;

	}

	public void insert(Additifs additifs) {

		Connection connection = null;

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			int nb = monCanal.executeUpdate(

					"insert into additifs (ID, nom) " +

							"values ("

							+ additifs.getId() + ",'"

							+ additifs.getNom() + "',;");

			if (nb == 1) {

				System.out.println("addditifs ajouté!");

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

							"update additifs SET nom='" + nouveauNom +

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
