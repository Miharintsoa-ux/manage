package fr.management.tool.interfaceservice;


import java.util.List;

import fr.management.tool.entity.Materiel;

public interface MaterielInteface {
    public Materiel createMateriel(Materiel materiel);
    public List<Materiel> readMateriels();
    
}
