package com.aios.crudapi.model;

import java.util.Date;

public class Commande {
	
    private int idCommande;
    private Destinataire destinataire;
    private Date dateLivraison;
    private double quantiteBananes;
    private double prixTotal;
    
    public Commande(int idCommande, Destinataire destinataire, Date dateLivraison, double quantiteBananes, double prixTotal) {
        
        if (destinataire != null && dateLivraison != null && quantiteBananes <= 10000 && quantiteBananes >= 0 && (quantiteBananes % 25 == 0 )) {
        	
        	this.idCommande = idCommande;
            this.destinataire = destinataire;
            this.dateLivraison = dateLivraison;
            this.quantiteBananes = quantiteBananes;
            this.prixTotal = prixTotal * 2.5;
            
        }else {
        	throw new IllegalArgumentException("Tous les champs sont obligatoires.");
        }
        

    }

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Destinataire getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public double getQuantiteBananes() {
		return quantiteBananes;
	}

	public void setQuantiteBananes(double quantiteBananes) {
		this.quantiteBananes = quantiteBananes;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal * 2.5;
	}
    
    
    
}
