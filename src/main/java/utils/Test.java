package utils;

import java.util.ArrayList;

import objets.Ingredients;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		ArrayList<Ingredients> list = new ArrayList<Ingredients>();
		
		
		Ingredients ind1 = new Ingredients(1,"Sel");
		Ingredients ind2 = new Ingredients(2,"Sel");
		Ingredients ind3 = new Ingredients(1,"Sel");
		Ingredients ind4 = new Ingredients(1,"Sel");
		
		
		list.add(ind1);
		list.add(ind2);
		list.add(ind3);
		list.add(ind4);
		
		System.out.println("La liste avec doublon est " + list);
		SupDoublon.SupprimDoublon(list);

	}

}
