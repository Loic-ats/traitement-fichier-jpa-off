package objets;

public class Allergenes {

	
	private int id;
	private String Nom;
	
	
	public Allergenes(int id, String nom) {
		super();
		this.id = id;
		Nom = nom;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}



}
