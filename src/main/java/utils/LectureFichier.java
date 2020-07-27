package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import objets.Produits;

public class LectureFichier {

	public static void main(String[] args) {

		try {
			File file = new File("D:\\DONNEES ISA\\Documents\\Diginamic\\Cours\\JDBC\\AutoFormation\\openFoodFacts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");

			ArrayList<Produits> list = new ArrayList<Produits>();

			for (String ligne : lignes) {

				String[] morceaux = ligne.split("|");
				String categories = morceaux[0];
				String marques = morceaux[1];
				String nom = morceaux[2];
				String nutritionGradeFr = morceaux[5];
				String ingredients = morceaux[6];
				String energie100g = morceaux[7];
				String graisse100g = morceaux[8];
				String sucres100g = morceaux[9];
				String fibres100g = morceaux[10];
				String proteines100g = morceaux[11];
				String sel100g = morceaux[12];
				String vitA100g = morceaux[13];
				String vitD100g = morceaux[14];
				String vitE100g = morceaux[15];
				String vitK100g = morceaux[16];
				String vitC100g = morceaux[17];
				String vitB1100g = morceaux[18];				
				String vitB2100g = morceaux[19];
				String vitPP100g = morceaux[20];
				String vitB6100g = morceaux[21];
				String vitB9100g = morceaux[22];
				String vitB12100g = morceaux[23];

				String calcium100g = morceaux[24];
				String magnesium100g = morceaux[25];
				String iron100g = morceaux[26];
				String fer100g = morceaux[27];
				String betaCarotene100g = morceaux[28];
				String presenceHuilePalme = morceaux[29];
	
				
				Produits p = new Produits(categories, marques, nom, nutritionGradeFr, ingredients, energie100g,graisse100g,sucres100g,fibres100g,proteines100g,sel100g,vitA100g,vitD100g,
						vitE100g, vitK100g, vitC100g, vitB1100g, vitB2100g, vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g,
						magnesium100g, iron100g, fer100g, betaCarotene100g, presenceHuilePalme);

				list.add(p);

			}
			// Supprimer la première ligne de l'ArrayList qui contient les titres des
			// colonnes
			//list.remove(0);

			System.out.println("Nombre de lignes :" + lignes.size());

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

}
