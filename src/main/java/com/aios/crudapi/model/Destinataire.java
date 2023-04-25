package com.aios.crudapi.model;

public class Destinataire {
	
	private int idDestinataire;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String pays;
    
    
    public Destinataire(int idDestinataire, String nom, String adresse, String codePostal, String ville, String pays) {
        
        if (nom == null || nom.isEmpty() || adresse == null || adresse.isEmpty() ||
            codePostal == null || codePostal.isEmpty() || ville == null || ville.isEmpty() || pays == null || pays.isEmpty()) {
                throw new IllegalArgumentException("parametres manquants");
        }
        
    	this.idDestinataire = idDestinataire;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }
    
    
	public int getIdDestinataire() {
		return idDestinataire;
	}
	public void setIdDestinataire(int idDestinataire) {
		this.idDestinataire = idDestinataire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
    
    
    
}
