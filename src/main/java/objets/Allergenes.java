package objets;

public class Allergenes {

	private long id;
	private String Nom;
	

	public Allergenes(String nom) {
		super();
		Nom = nom;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Allergenes [Nom=" + Nom + "]";
	}
	
}
