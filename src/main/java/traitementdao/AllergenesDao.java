package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;
import objets.Produits;

public interface AllergenesDao {
	
	public Connection getConnection();

	//List<Ingredients> extraire();

	void insertAllergenes(Connection conn,Produits produits) throws SQLException ;

	//int update(String ancienNom, String nouveauNom);
	
	//boolean delete(Produits produits);
	
}
