package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import objets.Ingredients;

public class SupDoublon {


	public static void SupprimDoublon( ArrayList <Ingredients> listavecdoublon) {
		
		
		ArrayList<Ingredients> listsansdoublon = new ArrayList<Ingredients>();
	
		Set<Ingredients> mySet = new HashSet<Ingredients>(listavecdoublon);
							
			mySet.addAll(listavecdoublon);

			listsansdoublon = new ArrayList<Ingredients>(mySet);
						
		System.out.println(listsansdoublon);
		
	}
	
}



