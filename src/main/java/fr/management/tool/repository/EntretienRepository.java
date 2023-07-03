package fr.management.tool.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.management.tool.entity.Entretien;


public interface EntretienRepository extends JpaRepository<Entretien, Long> {
    
    @Query("SELECT u FROM Entretien u WHERE MONTH(u.date) = :date")
    public List<Entretien> findEntretiensByMonth(
    @Param("date") int date);

    @Query("SELECT u FROM Entretien u WHERE u.date BETWEEN :debut AND :fin")
    public List<Entretien> findBetweenDate(
    @Param("debut") Date debut,
    @Param("fin") Date fin);
}
