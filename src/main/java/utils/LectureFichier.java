package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import objets.Ingredients;
import objets.Produits;

public class LectureFichier {

	public static void main(String[] args) {

		try {
			File file = new File(
					"E:\\Developpements\\Projets\\Donnees\\openFoodFacts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			
			ArrayList<Ingredients> list = new ArrayList<Ingredients>();
			
			for (String ligne : lignes) {

				String[] morceaux = ligne.split("\\|", -1);

				String categories = morceaux[0];
				String marques = morceaux[1];
				String nom = morceaux[2];
				String nutritionGradeFr = morceaux[3];
				list = Splitter.splitIngredients(morceaux[4]);
				
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
				String allergene = morceaux[28];
				String additif = morceaux[29];
		
		
			} 
			
			
			System.out.println("La liste avec les doublon est " + list);
			// Supprimer la première ligne de l'ArrayList qui contient les titres des
			// colonnes
			// list.remove(0);

			System.out.println("Nombre de lignes :" + lignes.size());

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
}
