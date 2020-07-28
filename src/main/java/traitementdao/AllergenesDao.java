package traitementdao;

import java.util.List;

import objets.Allergenes;

public interface AllergenesDao {

	List<Allergenes> extraire();

	void insert(Allergenes allergenes);

	int update(String ancienNom, String nouveauNom);
	
}
