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

    @GetMapping("/read")
    public List<Intervenant> geIntervenants(){
        return service.getIntervenants();
    }

    @GetMapping("/search/chaine/{chaine}")
    public List<Intervenant> search(@PathVariable String chaine){
        return service.findIntervenantsByChaine(chaine);
    }

    @GetMapping("/read/{id}")
    public Intervenant getIntervenant(
        @PathVariable("id") String id){
        return service.getIntervenant(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Intervenant> modifierIntervenant(
        @PathVariable("id") String id, 
        @RequestBody Intervenant intervenant){

            return new ResponseEntity<Intervenant>(
                service.updatIntervenant(id,intervenant),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIntervenant(
        @PathVariable("id") String id){
        service.deleteIntervenant(id);
        return new ResponseEntity<String>("intervenant supprimé", HttpStatus.OK);
    }

 
    
}
