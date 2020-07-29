package traitementdao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



import objets.Ingredients;


public class IngredientsJointureDao implements IngredientsDao {


	public static void main(String[] args) {

		IngredientsJointureDao ing = new IngredientsJointureDao();

		List<Ingredients> listeIng = ing.extraire();

		ing.insert(new Ingredients("betterave"));

		listeIng = ing.extraire();

		for (Ingredients ingredient : listeIng) {

			System.out.println(ingredient);

		}

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

	@Override

	public List<Ingredients> extraire() {

		Connection connection = null;

		List<Ingredients> listeIng = new ArrayList<>();

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			ResultSet monResultat = monCanal.executeQuery("SELECT * FROM ingredients;");

			while (monResultat.next()) {

				// tant que cest vrai on continue

				listeIng.add(new Ingredients(monResultat.getString("nom")));

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

		return listeIng;
	}


	@Override

	public void insert(Ingredients ingredients) {

		Connection connection = null;

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			int nb = monCanal.executeUpdate("insert into ingredients (id, nom) " + "values (" + ingredients.getid()

					+ ",'" + ingredients.getNom() + ");");

			if (nb == 1) {

				System.out.println("Ingrédients ajouté!");

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


	@Override

	public int update(String ancienNom, String nouveauNom) {

		Connection connection = null;

		int nb = 0;

		try {

			connection = getConnection();

			Statement monCanal = connection.createStatement();

			nb = monCanal

					.executeUpdate("update ingrédients SET nom='" + nouveauNom + "' where nom='" + ancienNom + "';");

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

}

