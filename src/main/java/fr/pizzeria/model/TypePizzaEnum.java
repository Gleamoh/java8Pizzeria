/**
 * 
 */
package fr.pizzeria.model;

/**
 * @author kevin
 * Liste des catégories de pizza possible
 */
public enum TypePizzaEnum {
	
	VIANDE("Viandre"), VEGAN("Vegan"), POISSON("Poisson");
	
	/**
	 * TypePizzaEnum.java : String
	 */
	private String labelle;

	
	/** Constructor
	 * @param labelle : String
	 */
	private TypePizzaEnum(String labelle) {
		this.labelle = labelle;
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
	
}
