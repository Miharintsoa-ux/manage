package fr.management.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.management.tool.entity.Intervenant;
import fr.management.tool.service.IntervenantService;

@RestController
@RequestMapping("/intervenant")
public class IntervenantController {

    private IntervenantService service;

    public IntervenantController(IntervenantService intervenantService) {
        this.service = intervenantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Intervenant> creerIntervenant(
        @RequestBody Intervenant intervenant){
        return new ResponseEntity<Intervenant>(service.createIntervenant(intervenant), HttpStatus.CREATED);
    }
    
}
