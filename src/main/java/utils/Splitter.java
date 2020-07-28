package utils;

import objets.Ingredients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Splitter {

	public static ArrayList <Ingredients> splitIngredients(String morceaux) {

		String [] lignes = morceaux.split(",", -1);

		ArrayList<Ingredients> list = new ArrayList<Ingredients>();

			for (int i = 0; i < lignes.length; i++) {

			list.add(new Ingredients(i, lignes[i].trim()));
		}

				return list;
	}

}
