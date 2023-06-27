package fr.management.tool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/read")
    public List<Entretien> getEntretiens(){
        return service.getEntretiens();
    }

    @GetMapping("/read/{id}")
    public Entretien ObtainEntretien(
        @PathVariable("id") long id){
        return service.getEntretien(id);
    }
    
}
