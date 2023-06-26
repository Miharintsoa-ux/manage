package fr.management.tool.entity;

import fr.management.tool.enumeration.Etat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private Etat state;
    
}
