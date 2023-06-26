package fr.management.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.management.tool.entity.Entretien;

public interface EntretienRepository extends JpaRepository<Entretien, Long> {
    
}
