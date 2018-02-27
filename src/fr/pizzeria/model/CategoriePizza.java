package fr.pizzeria.model;

/**
 * @author ETY0006
 *
 */
public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	/** CategoriePizza.java : String */
	private String label;

	/** Constructor
	 * @param categorie
	 */
	private CategoriePizza(String categorie) {
		label = categorie;
	}
	
	/**
	 * Trouver la catégorie en fonction du label (on evite de faire un switch)
	 * @param label
	 * @return
	 */
	public static CategoriePizza findByLabel(String label) {
		for (CategoriePizza categorie : values()) {
			if (categorie.label.equals(label)) {
				return categorie;
			}
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return label;
	}
	
	

}
