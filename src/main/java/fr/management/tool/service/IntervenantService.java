package fr.management.tool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.management.tool.entity.Intervenant;
import fr.management.tool.interfaceservice.IntervenantInterface;
import fr.management.tool.repository.IntervenantRepository;

@Service
public class IntervenantService implements IntervenantInterface{

    private IntervenantRepository manager;

    public IntervenantService(IntervenantRepository intervenantRepository) {
        this.manager = intervenantRepository;
    }

    @Override
    public Intervenant createIntervenant(Intervenant intervenant) {
        return manager.save(intervenant);
    }

    @Override
    public List<Intervenant> getIntervenants() {
        return manager.findAll();
    }

    @Override
    public Intervenant getIntervenant(String id) {
        return manager.findById(id).orElseThrow(
            () -> new RuntimeException("intevenant introuvable")
        );
    }

    @Override
    public Intervenant updatIntervenant(String id, Intervenant intervenant) {
        return manager.findById(id).map(p -> {
            p.setName(intervenant.getName());
            p.setImage(intervenant.getImage());
            p.setTaux(intervenant.getTaux());

            return manager.save(p);
        }).orElseThrow(
            () -> new RuntimeException("intervenant introuvable")
        );

    }

    @Override
    public void deleteIntervenant(String id) {
        manager.findById(id).orElseThrow(
            () -> new RuntimeException("intervenant introuvable")
        );
        
        manager.deleteById(id);
    }
    
}
