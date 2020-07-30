package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;
import objets.Produits;

public interface ProduitsDao{

	//List<Produits> extraire();

	void insererProduit(Connection conn,Produits produits) throws SQLException;

	//int update(String ancienNom, String nouveauNom);

	//boolean delete(Produits produits);
	
}
	
	
