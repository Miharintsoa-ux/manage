package fr.management.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.management.tool.entity.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel,String>{
    
}
