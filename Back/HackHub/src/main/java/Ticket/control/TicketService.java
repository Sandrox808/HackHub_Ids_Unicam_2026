package Ticket.control;

import Ticket.entity.Ticket;
import Ticket.entity.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Il mentore chiama questo metodo per vedere la "Coda Comune"
     */
    public List<Ticket> getTicketAperti() {
        return ticketRepository.findByStato(Ticket.StatoTicket.APERTO);
    }

    /**
     * Azione 1: Il mentore sceglie un ticket e lo blocca per sé
     */
    public Ticket prendiInCaricoTicket(Integer ticketId, Integer mentoreId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trovato."));

        // Delega la logica di controllo stato all'entità
        ticket.prendiInCarico(mentoreId);

        // Salva le modifiche sul DB H2
        return ticketRepository.save(ticket);
    }

    /**
     * Azione 2: Il mentore dichiara il ticket come Risolto
     */
    public Ticket risolviTicket(Integer ticketId, Integer mentoreId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trovato."));

        ticket.risolvi(mentoreId);

        return ticketRepository.save(ticket);
    }
}