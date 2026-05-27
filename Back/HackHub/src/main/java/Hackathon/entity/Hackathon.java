package Hackathon.entity;

import Membro.entity.MembroStaff;
import Sottomissione.entity.Sottomissione;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hackathon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hackathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    // Relazione con lo Staff: Jakarta creerà una tabella di giunzione automatica 'hackathon_staff'
    @ManyToMany
    @JoinTable(
            name = "hackathon_staff",
            joinColumns = @JoinColumn(name = "hackathon_id"),
            inverseJoinColumns = @JoinColumn(name = "membro_id")
    )
    @Builder.Default
    private List<MembroStaff> staffAssegnato = new ArrayList<>();

    // Cancella la vecchia @ElementCollection e usa questa:
    @OneToMany(mappedBy = "hackathon", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Sottomissione> sottomissioni = new ArrayList<>();

    /**
     * Logica di Business: Verifica se un membro dello staff è assegnato a questo Hackathon
     */
    public boolean haMembroStaff(Integer membroId) {
        return staffAssegnato.stream()
                .anyMatch(membro -> membro.getId().equals(membroId));
    }

    public List<Object> getListaSottomissioni(){
        return null;
    }
}