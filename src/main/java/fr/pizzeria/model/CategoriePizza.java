package fr.pizzeria.model;

/**
 * @author Kevin M.
 *
 */
public class CategoriePizza {

	
	/**
	 * id : int
	 */
	private int id;

	/**
	 * label : String
	 */
	private String labelle;

	/**
	 * Constructor
	 * 
	 */
	public CategoriePizza() {

	}

	/**
	 * Constructor
	 * 
	 * @param categorie
	 */
	public CategoriePizza(String categorie, int id) {
		labelle = categorie;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + " - " + labelle ;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the label
	 */
	public String getLabelle() {
		return labelle;
	}

	/**
	 * Setter
	 * 
	 * @param label
	 *            the label to set
	 */
	public void setLabelle(String label) {
		this.labelle = label;
	}

}
