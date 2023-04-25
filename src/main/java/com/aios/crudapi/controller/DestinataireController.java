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

import com.aios.crudapi.dao.DestinataireDAO;
import com.aios.crudapi.model.Destinataire;


@RestController
@RequestMapping("/api")
public class DestinataireController {

	
	@Autowired
	private DestinataireDAO destinataireDAO;


    @RequestMapping(value = "/destinataires", //
            method = RequestMethod.GET, //
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public List<Destinataire> getDestinataires() {
        List<Destinataire> list = destinataireDAO.getAllDestinataires();
        return list;
    }


    @RequestMapping(value = "/destinataires/{id_desinataire}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Destinataire getDestinataire(@PathVariable("id_desinataire") int id_desinataire) {
        return destinataireDAO.getDestinataire(id_desinataire);
    }


    @RequestMapping(value = "/destinataire", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Destinataire addDestinataire(@RequestBody Destinataire destinataire) {

        System.out.println("(Service Side) Creating destinataire: " + destinataire.getNom());

        return destinataireDAO.saveDestinataire(destinataire);
    }


    @RequestMapping(value = "/destinataire", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Destinataire updateDestinataire(@RequestBody Destinataire destinataire) {

        System.out.println("(Service Side) Editing destinataire: " + destinataire.getNom());

        return destinataireDAO.updateDestinataire(destinataire);
    }


    @RequestMapping(value = "/destinataire/{id_desinataire}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteDestinataire(@PathVariable("id_desinataire") int id_desinataire) {

        System.out.println("(Service Side) Deleting destinataire: " + id_desinataire);

        destinataireDAO.deleteDestinataire(id_desinataire);
    }
}
