package fr.management.tool.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entretien")
public class Entretien {
    
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    @Column(name = "dateIntervention")
    private Date date;

    @Column(name = "nombreHeures")
    private int hours;
    
    @ManyToOne
    @JoinColumn(name = "intervenant_id")
    private Intervenant intervenant;

    @ManyToOne
    @JoinColumn(name = "materiel_id")
    private Materiel materiel;
}
