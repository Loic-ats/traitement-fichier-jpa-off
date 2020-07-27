package objets;

public abstract class Categorie {

	
	private String Categorie;
	

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	@Override
	public String toString() {
		return "Categorie [Categorie=" + Categorie + "]";
	}
	

}
