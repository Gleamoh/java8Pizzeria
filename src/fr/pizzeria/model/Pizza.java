package fr.pizzeria.model;

public class Pizza {
	
	private int id;
	private String code;
	private String labelle;
	private double prix;
	private static int compteur = 0;
	
	public Pizza(String code, String libelle, double prix) {
		id = compteur ++; 
		this.code = code;
		this.labelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String libelle, double prix) {
		this.id = id;
		this.labelle = libelle;
		this.prix = prix;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return labelle;
	}

	public void setLibelle(String libelle) {
		this.labelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return code + " -> " + labelle + " (" + prix + " €)";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pizza) {
			return (((Pizza) obj).id == id);
		} else {	
			return false;
		}		
	}
	
	public void copyOf(Pizza pizza) {
		id = pizza.id;
		code = pizza.code;
		labelle = pizza.labelle;
		prix = pizza.prix;
	}
	
}
