package Membro.entity;


import Hackathon.entity.Hackathon;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "membro_staff")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ruolo", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MembroStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;


    /**
     * Logica di Business: Controlla se il membro è assegnato all'hackathon
     * e in caso positivo restituisce le sottomissioni.
     */
    public List<Object> ottieniSottomissioniSeAssegnato(Hackathon hackathon) {
        // Ipotizziamo che l'oggetto Hackathon abbia un metodo per verificare se lo staff è associato
        // o se questo specifico membro è il giudice/mentore/organizzatore di quell'hackathon.
        if (!hackathon.haMembroStaff(this.id)) {
            throw new SecurityException("Accesso negato: Non sei assegnato a questo Hackathon.");
        }

        // Uso 'Object' temporaneamente in attesa che tu crei l'entità Sottomissione
        return hackathon.getListaSottomissioni();
    }
}