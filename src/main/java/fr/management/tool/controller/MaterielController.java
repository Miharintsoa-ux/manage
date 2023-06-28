package fr.management.tool.controller;

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

    @GetMapping("/read")
    public List<Materiel> readMateriels(){
        return service.readMateriels();
    }
    

    @GetMapping("/read/{id}")
    public Materiel getMateriel(
        @PathVariable("id") String id){
        return service.readById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Materiel> updateMateriel(
        @PathVariable("id") String id, 
        @RequestBody Materiel materiel){
        return new ResponseEntity<Materiel>(service.updateMateriel(id, materiel), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMateriel(
        @PathVariable("id") String id){
        service.deleteMateriel(id);
        return new ResponseEntity<String>("materiel deleted", HttpStatus.OK);
    }

    @GetMapping("/state")
    public List<?> getStateCompte(){
        return service.compteState();
    }
    
}
