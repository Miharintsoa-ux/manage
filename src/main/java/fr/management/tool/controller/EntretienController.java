package fr.management.tool.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Entretien> updateEntretien(
        @PathVariable("id") long id, 
         @RequestBody Entretien entretien){

            return new ResponseEntity<Entretien>(
                service.updateEntretien(id, entretien),
                HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntretien(
        @PathVariable("id") long id){
            service.deleteEntretien(id);
            return new ResponseEntity<String>(
                "entretien deleted", 
                HttpStatus.OK);

    }

    @GetMapping("/search/{month}")
    public List<Entretien> searchByMonth(@PathVariable int month){
        return service.findByMonth(month);
    }

    @GetMapping("/search/{debut}/{fin}")
    public List<Entretien> searchEntreDate(
        @PathVariable("debut") Date debut, 
        @PathVariable("fin") Date fin){
        return service.findBetween(debut, fin);
    }
    
}
