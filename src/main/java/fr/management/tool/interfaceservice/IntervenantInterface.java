package fr.management.tool.interfaceservice;

import java.util.List;

import fr.management.tool.entity.Intervenant;

public interface IntervenantInterface {
    public Intervenant createIntervenant(Intervenant intervenant);   
    public List<Intervenant> getIntervenants();
    public Intervenant getIntervenant(String id);
    public Intervenant updatIntervenant(String id, Intervenant intervenant);
    public void deleteIntervenant(String id);
    public  List<Intervenant> findIntervenantsByChaine(String chaine);
}
