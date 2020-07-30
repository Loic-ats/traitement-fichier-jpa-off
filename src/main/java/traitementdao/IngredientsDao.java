package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;

import objets.Produits;

public interface IngredientsDao {
	
	public Connection getConnection();

	//List<Ingredients> extraire();

	void insertIngredients(Connection conn,Produits produits) throws SQLException ;

	//int update(String ancienNom, String nouveauNom);
	
	//boolean delete(Produits produits);
	
}
