package traitementdao;

import java.sql.Connection;
import java.sql.SQLException;

import objets.Produits;

public interface MarquesDao{

	//List<Marques> extraire();
	
	public Connection getConnection();

	void insererMarques(Connection conn,Produits produits) throws SQLException;

	//int update(String ancienNom, String nouveauNom);

	//boolean delete(Produits produits);
	
}