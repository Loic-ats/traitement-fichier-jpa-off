package traitementdao;

import java.util.List;

import objets.Marques;

public interface MarquesDao {

	List<Marques> extraire();

	void insert(Marques marques);

	int update(String ancienNom, String nouveauNom);

	boolean delete(Marques additifs);
}
