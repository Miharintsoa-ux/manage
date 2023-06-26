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
    
}