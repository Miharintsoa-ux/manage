package fr.management.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.management.tool.entity.Intervenant;

public interface IntervenantRepository extends JpaRepository<Intervenant, String> {
    
}
