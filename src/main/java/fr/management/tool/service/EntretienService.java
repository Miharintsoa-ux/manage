package fr.management.tool.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import fr.management.tool.entity.Entretien;
import fr.management.tool.entity.Intervenant;
import fr.management.tool.entity.Materiel;
import fr.management.tool.enumeration.Etat;
import fr.management.tool.interfaceservice.EntretienInterface;
import fr.management.tool.repository.EntretienRepository;
import fr.management.tool.repository.IntervenantRepository;
import fr.management.tool.repository.MaterielRepository;

@Service
public class EntretienService implements EntretienInterface {

    private EntretienRepository manager;
    private IntervenantRepository interManager;
    private MaterielService materielService;

    public EntretienService(EntretienRepository manager,
                            IntervenantRepository iManager,
                            MaterielService serviceMateriel) {
        this.manager = manager;
        this.interManager = iManager;
        this.materielService = serviceMateriel;
    }

    @Override
    public Entretien addEntretien(Entretien entretien) {

        Intervenant intervenant = entretien.getIntervenant();
        String id = intervenant.getId();
        Optional<Intervenant> res = interManager.findById(id);

        Materiel materiel = entretien.getMateriel();
        materiel.setState(Etat.BON);
        String id_materiel = materiel.getId();

        materielService.updateMateriel(id_materiel, materiel);
    

        if(!res.isPresent())
            interManager.save(intervenant);        

        return manager.save(entretien);
    }

    @Override
    public List<Entretien> getEntretiens() {
        return manager.findAll();
    }

    @Override
    public Entretien getEntretien(long id) {
        return manager.findById(id).orElseThrow(
            () -> new RuntimeException("entretien not found")
        );
    }

    @Override
    public Entretien updateEntretien(long id, Entretien newEntretien) {
        Entretien entretien = manager.findById(id).orElseThrow(
            () -> new RuntimeException("entretien not found")
        );

        Intervenant intervenant = newEntretien.getIntervenant();
        String intervenant_id = intervenant.getId();
        Optional<Intervenant> res = interManager.findById(intervenant_id);

        if(!res.isPresent())
            interManager.save(intervenant); 

        entretien.setDate(newEntretien.getDate());
        entretien.setHours(newEntretien.getHours());
        entretien.setIntervenant(newEntretien.getIntervenant());
        entretien.setMateriel(newEntretien.getMateriel());

        manager.save(entretien);
        return entretien;
    }

    @Override
    public void deleteEntretien(long id) {
        manager.findById(id).orElseThrow(
            () -> new RuntimeException("entretien inexistant")
        );

        manager.deleteById(id);
        
    }

    @Override
    public List<Entretien> findByMonth(int month) {
       return  manager.findEntretiensByMonth(month);
    }

    @Override
    public List<Entretien> findBetween(Date debut, Date fin) {
        return manager.findBetweenDate(debut, fin);
    }
    
}
