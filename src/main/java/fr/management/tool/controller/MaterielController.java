package fr.management.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.management.tool.entity.Materiel;
import fr.management.tool.service.MaterielService;

@RestController
@RequestMapping("/materiel")
public class MaterielController {

    private MaterielService service;

    public MaterielController(MaterielService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Materiel> createMateriel(
        @RequestBody Materiel materiel){
        return new ResponseEntity<Materiel>(service.createMateriel(materiel), HttpStatus.CREATED);
    }
    
}