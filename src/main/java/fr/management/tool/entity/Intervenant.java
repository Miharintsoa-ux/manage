package fr.management.tool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "intervenant")
public class Intervenant {

    @Id
    @Column(name = "intervenant_id")
    private String id;

    @Column(name = "nom")
    private String name;

    @Column(name = "tauxHoraire")
    private long taux;
    
}
