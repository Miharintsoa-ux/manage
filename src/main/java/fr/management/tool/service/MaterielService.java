package fr.management.tool.service;

import org.springframework.stereotype.Service;

import fr.management.tool.entity.Materiel;
import fr.management.tool.interfaceservice.MaterielInteface;
import fr.management.tool.repository.MaterielRepository;

@Service
public class MaterielService implements MaterielInteface{

    private MaterielRepository materielRepository;

    public MaterielService(MaterielRepository manager) {
        this.materielRepository = manager;
    }

    @Override
    public Materiel createMateriel(Materiel materiel) {
        return materielRepository.save(materiel);
    }
    
    
}
