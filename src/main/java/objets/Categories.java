package objets;

public class Categories {

	
	private long id;
	private String nom;
	
	public Categories(String nom) {
		super();
		this.nom = nom;
	}
	
	public long getid() {
		return id;
	}
	public void setid(long id) {
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
		return "Categories [id=" + id + ", nom=" + nom + "]";
	}

}
