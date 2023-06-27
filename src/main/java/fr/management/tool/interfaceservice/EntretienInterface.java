package fr.management.tool.interfaceservice;

import java.util.List;

import fr.management.tool.entity.Entretien;

public interface EntretienInterface {
    public Entretien addEntretien(Entretien entretien);    
    public List<Entretien> getEntretiens();
    public Entretien getEntretien(long id);
    public Entretien updateEntretien(long id, Entretien newEntretien);
    public void deleteEntretien(long id);

}
