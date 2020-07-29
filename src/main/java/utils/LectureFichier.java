package utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import objets.Additifs;
import objets.Allergenes;
import objets.Categories;
import objets.Ingredients;
import objets.Marques;
import objets.Produits;
import traitementdao.ProduitsDaoTest;

public class LectureFichier{

	public static void main(String[] args) throws SQLException {

		try {
			File file = new File("E:\\Developpements\\Projets\\Donnees\\openFoodFacts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/open-food-fact?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","");
			
			lignes.remove(0);	
				
			for (String ligne : lignes) {

				String[] morceaux = ligne.split("\\|", -1);

				String categories = morceaux[0];
				String marques = morceaux[1];
				String nom = morceaux[2];
				String nutritionGradeFr = morceaux[3];

				Produits produit = new Produits(nom);
				produit.setCategorie(new Categories(categories));
				produit.setMarque(new Marques(marques));
				produit.setGradeNutri(nutritionGradeFr);

				List <Ingredients> ListeIngredient = Splitter.splitIngredients(morceaux[4]);
					
				String energie100g = morceaux[5];
				String graisse100g = morceaux[6];
				String sucres100g = morceaux[7];
				String fibres100g = morceaux[8];
				String proteines100g = morceaux[9];
				String sel100g = morceaux[10];
				String vitA100g = morceaux[11];
				String vitD100g = morceaux[12];
				String vitE100g = morceaux[13];
				String vitK100g = morceaux[14];
				String vitC100g = morceaux[15];
				String vitB1100g = morceaux[16];
				String vitB2100g = morceaux[17];
				String vitPP100g = morceaux[18];
				String vitB6100g = morceaux[19];
				String vitB9100g = morceaux[20];
				String vitB12100g = morceaux[21];
				String calcium100g = morceaux[22];
				String magnesium100g = morceaux[23];
				String iron100g = morceaux[24];
				String fer100g = morceaux[25];
				String betaCarotene100g = morceaux[26];
				String presenceHuilePalme = morceaux[27];
												
				List <Additifs> ListeAdditif = Splitter.splitAdditifs(morceaux[28]);				
				produit.setAdditif(ListeAdditif);
				List <Allergenes> ListeAllergene = Splitter.splitAllergenes(morceaux[29]);
				produit.setAllergenes(ListeAllergene);
				
				produit.setEnergie100g(energie100g);
				produit.setGraisse100g(graisse100g);
				produit.setSucres100g(sucres100g);
				produit.setFibres100g(fibres100g);
				produit.setProteines100g(proteines100g);
				produit.setSel100g(sel100g);
				produit.setVitA100g(vitA100g);
				produit.setVitD100g(vitD100g);
				produit.setVitE100g(vitE100g);
				produit.setVitK100g(vitK100g);
				produit.setVitC100g(vitC100g);
				produit.setVitB1100g(vitB1100g);
				produit.setVitB2100g(vitB2100g);
				produit.setVitPP100g(vitPP100g);
				produit.setVitB6100g(vitB6100g);
				produit.setVitB9100g(vitB9100g);
				produit.setVitB12100g(vitB12100g);
				produit.setCalcium100g(calcium100g);
				produit.setMagnesium100g(magnesium100g);
				produit.setIron100g(iron100g);
				produit.setFer100g(fer100g);
				produit.setBetaCarotene100g(betaCarotene100g);
				produit.setPresenceHuilePalme(presenceHuilePalme);
			
				System.out.println(produit);
				ProduitsDaoTest.insererProduit(conn, produit);
				
			}

			System.out.println("Nombre de lignes :" + lignes.size());

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
}
