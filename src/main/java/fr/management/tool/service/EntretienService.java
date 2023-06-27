package fr.management.tool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.management.tool.entity.Entretien;
import fr.management.tool.interfaceservice.EntretienInterface;
import fr.management.tool.repository.EntretienRepository;

@Service
public class EntretienService implements EntretienInterface {

    private EntretienRepository manager;

    public EntretienService(EntretienRepository entretienRepository) {
        this.manager = entretienRepository;
    }

    @Override
    public Entretien addEntretien(Entretien entretien) {
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
    
}
