package traitementdao;

import java.util.List;
import objets.Produits;

public interface ProduitsDao{

	List<Produits> extraire();

	void insert(Produits produits);

	int update(String ancienNom, String nouveauNom);

	boolean delete(Produits produits);
	
}
	
	
