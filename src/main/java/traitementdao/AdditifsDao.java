package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;
import objets.Produits;

public interface AdditifsDao {

	public Connection getConnection();

	//List<Ingredients> extraire();

	void insertAdditifs(Connection conn,Produits produits) throws SQLException ;

	//int update(String ancienNom, String nouveauNom);
	
	//boolean delete(Additifs additifs);
	
}
