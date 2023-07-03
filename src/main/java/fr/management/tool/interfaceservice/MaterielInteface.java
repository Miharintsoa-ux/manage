package fr.management.tool.interfaceservice;


import java.util.List;

import fr.management.tool.entity.Materiel;

public interface MaterielInteface {
    public Materiel createMateriel(Materiel materiel);
    public List<Materiel> readMateriels();
    public Materiel readById(String id);
    public Materiel updateMateriel(String id, Materiel materiel);
    public void deleteMateriel(String id);
    public List<?> compteState();
    public List<Materiel> findMateriels(String chaine);
    
}
