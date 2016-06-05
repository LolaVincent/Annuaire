package beans;

import beans.*;

import java.util.List;
import java.util.ArrayList;

public class Annonce {

	private Long id;
	private Long categorie;
	private String nom;
	private String adresse;
	private String numero;
	
	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
    public void setCategorie( Long categorie ) {
        this.categorie = categorie;
    }
	
	public Long getCategorie() {
        return categorie;
    }
	
	public void setNom( String nom ) {
        this.nom = nom;
    }
	
	public String getNom() {
        return nom;
    }
	
	public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }
	
	public String getAdresse() {
        return adresse;
    }
	
	public void setNumero(String numero ) {
        this.numero = numero;
    }
	
	public String getNumero() {
        return numero;
    }
}