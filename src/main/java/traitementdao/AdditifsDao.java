package traitementdao;

import java.util.List;
import objets.Additifs;

public interface AdditifsDao {

	List<Additifs> extraire();

	void insert(Additifs additifs);

	int update(String ancienNom, String nouveauNom);
	
}
