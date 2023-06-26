package fr.management.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.management.tool.entity.Entretien;
import fr.management.tool.service.EntretienService;

@RestController
@RequestMapping("/entretien")
public class EntretienController {

    private EntretienService service;

    public EntretienController(EntretienService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Entretien> createEntretien(
        @RequestBody Entretien entretien){

        return new ResponseEntity<Entretien>(
            service.addEntretien(entretien),
            HttpStatus.CREATED);
    }
    
}
