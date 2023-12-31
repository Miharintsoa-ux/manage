package fr.management.tool.service;

import java.util.List;

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

    @Override
    public List<Materiel> readMateriels() {
        return materielRepository.findAll();
    }

    @Override
    public Materiel readById(String id) {
        return materielRepository.findById(id).orElseThrow(
            () -> new RuntimeException("material not found")
        );
    }

    @Override
    public Materiel updateMateriel(String id, Materiel materiel) {
        return materielRepository.findById(id).map( ancien -> {
            ancien.setDesign(materiel.getDesign());
            ancien.setAbout(materiel.getAbout());
            ancien.setImage_link(materiel.getImage_link());
            ancien.setState(materiel.getState());

            return materielRepository.save(ancien);
        }
            
        ).orElseThrow(
            () -> new RuntimeException("materiel not found")
        );

    }

    @Override
    public void deleteMateriel(String id) {
        Materiel materiel = materielRepository.findById(id).orElseThrow(
            () -> new RuntimeException("materiel not found")
        );

        if(materiel != null)
            materielRepository.deleteById(id);
    }

    @Override
    public List<?> compteState() {
        return materielRepository.findStateCount();
    }

    @Override
    public List<Materiel> findMateriels(String chaine) {
        return materielRepository.findMaterielByChaine(chaine);
    }

    
    
    
    
}
