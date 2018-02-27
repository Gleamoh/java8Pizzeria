package fr.pizzeria.model;

/**
 * @author Kevin M.
 * Entité Pizza
 */

public class Pizza {

	/** Pizza.java : int */
	private int id; // identifiant unique
	
	/** Pizza.java : String */
	private String code; // code unique à 3 caractères
	
	/** Pizza.java : String */
	private String labelle; // nom complet de la pizza
	
	/** Pizza.java : double */
	private double prix;
	
	/** Pizza.java : int */
	private static int compteur = 0;
	
	/** Pizza.java : CategoriePizza */
	private CategoriePizza categorie;

	/**
	 * Constructor Initialise la pizza et incremente le compteur de pizza
	 * 
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		id = compteur++;
		this.code = code;
		this.labelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String libelle, double prix) {
		this.id = id;
		this.labelle = libelle;
		this.prix = prix;
	}

	
	
	@Override
	public String toString() {
		return code + " -> " + labelle + " (" + prix + " €), " + " - " + categorie;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pizza) {
			return (((Pizza) obj).id == id);
		} else {
			return false;
		}
	}

	/**
	 *  Creer une copie de la pizza en paramètre
	 * @param pizza
	 */
	public void copyOf(Pizza pizza) {
		id = pizza.id;
		code = pizza.code;
		labelle = pizza.labelle;
		prix = pizza.prix;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter
	 * @return the labelle
	 */
	public String getLabelle() {
		return labelle;
	}

	/** Setter
	 * @param labelle the labelle to set
	 */
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/** Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Getter
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

}
