package fr.management.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.management.tool.entity.Intervenant;

public interface IntervenantRepository extends JpaRepository<Intervenant, String> {
    
    @Query("SELECT u FROM Intervenant u WHERE u.name LIKE %:name%")
    public List<Intervenant> findIntervenantByChaine(
    @Param("name") String name);
}
