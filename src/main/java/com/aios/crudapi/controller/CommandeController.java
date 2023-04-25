package com.aios.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aios.crudapi.dao.CommandeDAO;
import com.aios.crudapi.model.Commande;


@RestController
@RequestMapping("/api")
public class CommandeController {

	
	@Autowired
	private CommandeDAO CommandeDAO;


    @RequestMapping(value = "/commandes", //
            method = RequestMethod.GET, //
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public List<Commande> getCommandes() {
        List<Commande> list = CommandeDAO.getAllCommandes();
        return list;
    }


    @RequestMapping(value = "/commandes/{idCommande}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Commande getCommandes(@PathVariable("idCommande") int idCommande) {
        return CommandeDAO.getCommande(idCommande);
    }

    @RequestMapping(value = "/commandesDestinataire/{idDestinataire}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Commande> getCommandesToDestinataire(@PathVariable("idDestinataire") int idDestinataire) {
        return CommandeDAO.getCommandesToDestinataire(idDestinataire);
    }
    
    
    @RequestMapping(value = "/commande", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Commande addCommandes(@RequestBody Commande commande) {

        System.out.println("(Service Side) Creating Commande: " + commande.getIdCommande());

        return CommandeDAO.saveCommande(commande);
    }


    @RequestMapping(value = "/commande", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Commande updateCommande(@RequestBody Commande Commande) {

        System.out.println("(Service Side) Editing Commande: " + Commande.getIdCommande());

        return CommandeDAO.updateCommande(Commande);
    }


    @RequestMapping(value = "/commande/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteCommande(@PathVariable("id") int id) {

        System.out.println("(Service Side) Deleting Commande: " + id);

        CommandeDAO.deleteCommande(id);
    }
}
