package fr.management.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.management.tool.entity.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel,String>{

@Query("select new map(count(m) as compte, m.state as etat) from Materiel m group by m.state")
public List<?> findStateCount();
    
}
