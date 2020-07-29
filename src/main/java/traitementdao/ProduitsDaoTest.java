package traitementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;


import objets.Additifs;
import objets.Allergenes;
import objets.Categories;
import objets.Ingredients;
import objets.Marques;
import objets.Produits;


public class ProduitsDaoTest {

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


	public static void insererProduit(Connection conn, Produits produits) throws SQLException {


		// TODO: Premièrement: Je regarde si la catégorie de produit existe en base
		// TODO: - Cas 1: la catégorie n'existe pas: je la créé
		// TODO: - Cas 2: la catégorie existe: je la récupère et je l'associe au
		// produit.

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


		// Insertion ou Select de la marque

		Marques marque = produits.getMarque();

		statement = conn.createStatement();

		res = statement

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

		// Insertion du produit

		statement = conn.createStatement();

		String query = "SELECT ID, NOM FROM PRODUIT WHERE nom='"

				+ produits.getNom().replace("'", "''").replace("\\", "") + "'";

		System.out.println(query);

		res = statement.executeQuery(query);

		if (res.next()) {

			// Je fais rien

		} else {

			statement.executeUpdate("INSERT INTO PRODUIT (NOM, ID_CAT, ID_MAR, GRADENUTRI) VALUES ('"

					+ produits.getNom().replace("'", "''").replace("\\", "") + "'," + categories.getid() + ","

					+ marque.getId() + ",'" + produits.getGradeNutri() + "')");

			res = statement.executeQuery("SELECT ID, NOM FROM PRODUIT WHERE nom='"

					+ produits.getNom().replace("'", "''").replace("\\", "") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				produits.setId(id);

			}

		}

		// Traitement des ingrédients

		List<Ingredients> ingredients = produits.getIngredient();

		for (Ingredients ingredient : ingredients) {

			statement = conn.createStatement();

			res = statement.executeQuery(

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


		// Traitement des Allergenes

		List<Allergenes> allergenes = produits.getAllergenes();

		for (Allergenes allergene : allergenes) {

			statement = conn.createStatement();

			res = statement.executeQuery(

					"SELECT ID, NOM FROM ALLERGENES WHERE nom='" + allergene.getNom().replace("'", "''") + "'");

			if (res.next()) {

				Long id = res.getLong("ID");

				allergene.setid(id);

			} else {

				statement.executeUpdate(

						"INSERT INTO ALLERGENES (NOM) VALUES ('" + allergene.getNom().replace("'", "''") + "')");

				res = statement.executeQuery(

						"SELECT ID, NOM FROM ALLERGENES WHERE nom='" + allergene.getNom().replace("'", "''") + "'");

				if (res.next()) {

					Long id = res.getLong("ID");

					allergene.setid(id);

				}

			}

		}


		// Traitement des Additifs :

		List<Additifs> additifs = produits.getAdditif();

		for (Additifs additif : additifs) {

			statement = conn.createStatement();

			res = statement.executeQuery("SELECT ID, NOM FROM ADDITIFS WHERE nom='"

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