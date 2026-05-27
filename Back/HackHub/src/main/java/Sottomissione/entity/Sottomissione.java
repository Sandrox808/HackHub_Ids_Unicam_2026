package Sottomissione.entity;

import Hackathon.entity.Hackathon;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sottomissione")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Sottomissione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeProgetto;
    private String githubUrl;

    @Column(length = 1000)
    private String descrizione;

    // Relazione: Molte sottomissioni appartengono a un solo Hackathon
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hackathon_id", nullable = false)
    private Hackathon hackathon;

    // Campi per il Giudizio (gestiti dal Giudice dello Staff)
    private Integer punteggio; // Es. da 1 a 10
    private String feedbackGiudice;
    private Integer giudicatoDaMembroId; // ID del Giudice dello staff che ha valutato
}
