package objets;

public abstract class Additif {

	
	private String Additif;

	public String getAdditif() {
		return Additif;
	}

	public void setAdditif(String additif) {
		Additif = additif;
	}

	@Override
	public String toString() {
		return "Additif [Additif=" + Additif + "]";
	}

}
