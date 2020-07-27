package objets;

public abstract class Allergene {

	private String Additif;

	public String getAdditif() {
		return Additif;
	}

	public void setAdditif(String additif) {
		Additif = additif;
	}

	@Override
	public String toString() {
		return "Allergène [Additif=" + Additif + "]";
	} 
	

}
