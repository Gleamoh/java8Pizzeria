package fr.pizzeria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kevin M.
 *
 */
@Entity
@Table(name="categorie")
public class CategoriePizza {

	
	/**
	 * id : int
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/**
	 * label : String
	 */
	private String labelle;

	/** pizzas : List<Pizza> */
	private List<Pizza> pizzas;
	
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
	public CategoriePizza(String categorie, int id, List<Pizza> pizzas) {
		labelle = categorie;
		this.id = id;
		this.pizzas = pizzas;
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

	/** Getter
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	/** Setter
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
