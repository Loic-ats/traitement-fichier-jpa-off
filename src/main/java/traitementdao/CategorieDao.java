package traitementdao;

import java.util.List;

import objets.Categories;

public interface CategorieDao {

	List<Categories> extraire();

	void insert(Categories additifs);

	int update(String ancienNom, String nouveauNom);

}
