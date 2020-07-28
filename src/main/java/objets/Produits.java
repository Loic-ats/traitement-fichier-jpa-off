package objets;



public class Produits extends Composition {
 
	private Categories categorie;
    private Marques marque;
    private String NomProduit;
    private String gradeNutri;
    private Ingredients ingredients;
    private Allergenes Allergenes;
    private Additifs Additifs;
	
    
    public Produits(String energie100g, String graisse100g, String sucres100g, String fibres100g, String proteines100g,
			String sel100g, String vitA100g, String vitD100g, String vitE100g, String vitK100g, String vitC100g,
			String vitB1100g, String vitB2100g, String vitPP100g, String vitB6100g, String vitB9100g, String vitB12100g,
			String calcium100g, String magnesium100g, String iron100g, String fer100g, String betaCarotene100g,
			String presenceHuilePalme, Categories categorie, Marques marque, String nomProduit, String gradeNutri,
			Ingredients ingredients, objets.Allergenes allergenes, objets.Additifs additifs) {
		super(energie100g, graisse100g, sucres100g, fibres100g, proteines100g, sel100g, vitA100g, vitD100g, vitE100g,
				vitK100g, vitC100g, vitB1100g, vitB2100g, vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g,
				magnesium100g, iron100g, fer100g, betaCarotene100g, presenceHuilePalme);
		this.categorie = categorie;
		this.marque = marque;
		NomProduit = nomProduit;
		this.gradeNutri = gradeNutri;
		this.ingredients = ingredients;
		Allergenes = allergenes;
		Additifs = additifs;
	}
    
    

  
}

