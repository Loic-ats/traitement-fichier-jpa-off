package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;

import objets.Produits;

public interface CategoriesDao {
	
	public Connection getConnection();

	//List<Ingredients> extraire();

	void insertCategories(Connection conn,Produits produits) throws SQLException ;

	//int update(String ancienNom, String nouveauNom);
	
	//boolean delete(Produits produits);
	
}
