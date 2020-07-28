package utils;

import objets.Ingredients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Splitter {

	public static ArrayList<Ingredients> splitIngredients(String morceaux) {

		String [] lignes = morceaux.split(",", -1);

		ArrayList<Ingredients> list = new ArrayList<Ingredients>();

		// Créer une liste de contenu unique basée sur les éléments de ArrayList
		
		//Set<Ingredients> mySet = new HashSet<Ingredients>(list);
		//ArrayList<Ingredients> listsansdoublon = new ArrayList<Ingredients>();

		for (int i = 0; i < lignes.length; i++) {

			list.add(new Ingredients(i, lignes[i]));
		}
		
		return list;
		

		//System.out.println("La liste des ingredients avec doublon est " + list);
		//mySet.addAll(list);

		//listsansdoublon = new ArrayList<Ingredients>(mySet);

		//System.out.println("La liste dans doublon est " + listsansdoublon);

	}
	

}
