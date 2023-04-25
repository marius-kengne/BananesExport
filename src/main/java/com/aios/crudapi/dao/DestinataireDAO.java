package com.aios.crudapi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aios.crudapi.model.Destinataire;

@Repository
public class DestinataireDAO {

	private static final Map<Integer, Destinataire> destinatairesMap = new HashMap<Integer, Destinataire>();

    static {
        initDestinataire();
    }

    
    private static void initDestinataire() {
    	
        Destinataire destinataire1 = new Destinataire(1, "AUCAN" , "7 rue cergy", "95120", "Mons", "Belgique");
        Destinataire destinataire2 = new Destinataire(2, "Olivier" , "Esplanade paris", "23054", "Paris", "France");

        
        destinatairesMap.put(destinataire1.getIdDestinataire(), destinataire1);
        destinatairesMap.put(destinataire2.getIdDestinataire(), destinataire2);
        
    }

    public Destinataire getDestinataire(int idDestination) {
        return destinatairesMap.get(idDestination);
    }


    public Destinataire saveDestinataire(Destinataire destinataire) {
    	
    	if(destinatairesMap.containsKey(destinataire.getIdDestinataire()))
    		return null;
    	
    	destinatairesMap.put(destinataire.getIdDestinataire(), destinataire);
        return destinataire;
    }

    public Destinataire updateDestinataire(Destinataire destinataire) {
        destinatairesMap.put(destinataire.getIdDestinataire(), destinataire);
        return destinataire;
    }

    public void deleteDestinataire(int id_desinataire) {
        destinatairesMap.remove(id_desinataire);
    }

    public List<Destinataire> getAllDestinataires() {
        Collection<Destinataire> destinatairesCollection = destinatairesMap.values();
        List<Destinataire> listDestinataires = new ArrayList<Destinataire>();
        listDestinataires.addAll(destinatairesCollection);
        return listDestinataires;
    }

}
