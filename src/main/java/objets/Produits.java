package objets;

public class Produits extends Compositon {

	private String categories;
	private String marques;
	private String nom;
	private String nutritionGradeFr;
	private String ingredients;
	
	public Produits(String energie100g, String graisse100g, String sucres100g, String fibres100g, String proteines100g,
			String sel100g, String vitA100g, String vitD100g, String vitE100g, String vitK100g, String vitC100g,
			String vitB1100g, String vitB2100g, String vitPP100g, String vitB6100g, String vitB9100g, String vitB12100g,
			String calcium100g, String magnesium100g, String iron100g, String fer100g, String betaCarotene100g,
			String presenceHuilePalme, String categories, String marques, String nom, String nutritionGradeFr,
			String ingredients) {
		super(energie100g, graisse100g, sucres100g, fibres100g, proteines100g, sel100g, vitA100g, vitD100g, vitE100g,
				vitK100g, vitC100g, vitB1100g, vitB2100g, vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g,
				magnesium100g, iron100g, fer100g, betaCarotene100g, presenceHuilePalme);
		
		this.categories = categories;
		this.marques = marques;
		this.nom = nom;
		this.nutritionGradeFr = nutritionGradeFr;
		this.ingredients = ingredients;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getMarques() {
		return marques;
	}

	public void setMarques(String marques) {
		this.marques = marques;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Produits [categories = " + categories + ", marques = " + marques + ", nom = " + nom + ", nutritionGradeFr = "
				+ nutritionGradeFr + ", ingredients = " + ingredients + ", Composition = " + "Energie =" + getEnergie100g()
				+ ", Graisse (100g) = " + getGraisse100g() + ", Sucres (100g) = " + getSucres100g()
				+ ", Fibres100g = " + getFibres100g() + ", Proteines100g = " + getProteines100g()
				+ ", Sel100g = " + getSel100g() + ", getVitA100g = " + getVitA100g() + ", VitD100g = "
				+ getVitD100g() + ", VitE100g = " + getVitE100g() + ", VitK100g = " + getVitK100g()
				+ ", getVitC100g = " + getVitC100g() + ", VitB1100g = " + getVitB1100g() + ", VitB2100g = "
				+ getVitB2100g() + ", VitPP100g = " + getVitPP100g() + ", VitB6100g()=" + getVitB6100g()
				+ ", VitB9100g = " + getVitB9100g() + ", VitB12100g = " + getVitB12100g() + ", Calcium100g = "
				+ getCalcium100g() + ", Magnesium100g  = " + getMagnesium100g() + ", Iron100g = " + getIron100g()
				+ ", getFer100g = " + getFer100g() + ", BetaCarotene100g = " + getBetaCarotene100g()
				+ ", PresenceHuilePalme = " + getPresenceHuilePalme() + "]";
	}

	


	


}
