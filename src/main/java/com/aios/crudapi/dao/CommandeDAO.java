package com.aios.crudapi.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aios.crudapi.model.Commande;
import com.aios.crudapi.model.Destinataire;

@Repository
public class CommandeDAO {

	@Autowired
    private static DestinataireDAO destinataireDAO;
	
	private static final Map<Integer, Commande> CommandesMap = new HashMap<Integer, Commande>();
	private static final List<Destinataire> destinataires = new ArrayList<Destinataire>();
	
	private static final Map<Integer, Destinataire> destinatairesMap = new HashMap<Integer, Destinataire>();

    static {
        initCommande();
    }

 
    private static void initCommande() {
    	
    	Destinataire destinataire1 = new Destinataire(1, "AUCAN" , "7 rue cergy", "95120", "Mons", "Belgique");
        Destinataire destinataire2 = new Destinataire(2, "Olivier" , "Esplanade paris", "23054", "Paris", "France");

    	destinataires.add(destinataire1);
    	destinataires.add(destinataire2);
    	
        Commande commande1 = new Commande(1, destinataires.get(0) , new Date(), 25.00,  15.00);
        Commande commande2 = new Commande(2, destinataires.get(1) , new Date(), 50.00,  105.00);
        
        CommandesMap.put(commande1.getIdCommande(), commande1);
        CommandesMap.put(commande2.getIdCommande(), commande2);
        
    }

    public Commande getCommande(int idCommande) {
        return CommandesMap.get(idCommande);
    }

    
    public List<Commande> getCommandesToDestinataire(int idDestinataire) {
    	
    	List<Commande> commandeToDestinataire = new ArrayList<Commande>();

    	for (Commande commande : getAllCommandes()) {
			if(commande.getDestinataire().getIdDestinataire() == idDestinataire)
				commandeToDestinataire.add(commande);
		}
    	
        return commandeToDestinataire;
    }
    
    public Commande saveCommande(Commande commande) {
    	if(CommandesMap.containsKey(commande.getIdCommande()))
    		return null;
        CommandesMap.put(commande.getIdCommande(), commande);
        return commande;
    }

    public Commande updateCommande(Commande commande) {
        CommandesMap.put(commande.getIdCommande(), commande);
        return commande;
    }

    public void deleteCommande(int idCommande) {
        CommandesMap.remove(idCommande);
    }

    public List<Commande> getAllCommandes() {
        Collection<Commande> c = CommandesMap.values();
        List<Commande> list = new ArrayList<Commande>();
        list.addAll(c);
        return list;
    }
    

}
