package traitementdao;

import java.util.List;

import objets.Ingredients;

public interface IngredientsDao {

	List<Ingredients> extraire();

	void insert(Ingredients ingredients);

	int update(String ancienNom, String nouveauNom);
	
}
