package Ticket.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titolo;

    @Column(length = 1000)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private StatoTicket stato; // APERTO, IN_COARICO, RISOLTO

    private LocalDateTime dataCreazione;

    private Integer mentoreId;

    public enum StatoTicket {
        APERTO, IN_CARICO, RISOLTO
    }

    /**
     * Logica di Business: Il mentore prende in carico il ticket dalla lista comune
     */
    public void prendiInCarico(Integer mentoreId) {
        if (this.stato != StatoTicket.APERTO) {
            throw new IllegalStateException("Questo ticket è già stato preso in carico o è già risolto.");
        }
        this.stato = StatoTicket.IN_CARICO;
        this.mentoreId = mentoreId;
    }

    /**
     * Logica di Business: Il mentore risolve il ticket
     */
    public void risolvi(Integer mentoreId) {
        if (this.stato != StatoTicket.IN_CARICO) {
            throw new IllegalStateException("Puoi risolvere solo un ticket che è attualmente in carico.");
        }
        if (!this.mentoreId.equals(mentoreId)) {
            throw new SecurityException("Non puoi risolvere un ticket preso in carico da un altro mentore.");
        }
        this.stato = StatoTicket.RISOLTO;
    }
}