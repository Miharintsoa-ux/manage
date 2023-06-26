package fr.management.tool.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "intervenant", cascade = CascadeType.ALL)
    private Set<Entretien> entretien = new HashSet<>();
    
}
