package fr.management.tool.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import fr.management.tool.entity.Entretien;
import fr.management.tool.entity.Intervenant;
import fr.management.tool.interfaceservice.EntretienInterface;
import fr.management.tool.repository.EntretienRepository;
import fr.management.tool.repository.IntervenantRepository;

@Service
public class EntretienService implements EntretienInterface {

    private EntretienRepository manager;
    private IntervenantRepository interManager;

    public EntretienService(EntretienRepository manager, IntervenantRepository iManager) {
        this.manager = manager;
        this.interManager = iManager;
    }

    @Override
    public Entretien addEntretien(Entretien entretien) {

        Intervenant intervenant = entretien.getIntervenant();
        String id = intervenant.getId();
        Optional<Intervenant> res = interManager.findById(id);

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
    
}
