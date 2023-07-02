package fr.management.tool.entity;

import java.util.HashSet;
import java.util.Set;

import fr.management.tool.enumeration.Etat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="materiel")
public class Materiel {

    @Id
    @Column(name = "materiel_id")
    private String id;

    private String design;

    @Column(name = "carateristiques")
    private String about;

    @Column(name = "image_link")
    private String image_link;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private Etat state;

    @OneToMany(mappedBy = "materiel", cascade = CascadeType.ALL)
    private Set<Entretien> entretien = new HashSet<>();
    
}
