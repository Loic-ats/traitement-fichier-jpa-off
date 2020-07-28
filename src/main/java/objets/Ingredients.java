package objets;

public class Ingredients {

	private int id;
	private String nom;
	
	
	public Ingredients(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Ingredients [id=" + id + ", nom=" + nom + "]";
	}


}
