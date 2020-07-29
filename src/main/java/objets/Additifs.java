package objets;

public class Additifs {
	

	private long id;
	private String nom;
	
	public Additifs(String nom) {
		super();
		this.nom = nom;
	} 
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Additifs [nom=" + nom + "]";
	}

}
