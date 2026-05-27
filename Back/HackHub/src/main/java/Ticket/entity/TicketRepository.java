package Ticket.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Trova tutti i ticket assegnati a un determinato mentore
    List<Ticket> findByMentoreAssegnatoId(Integer mentoreId);

    // Trova i ticket filtrati per stato (es. tutti quelli ancora APERTI)
    List<Ticket> findByStato(Ticket.StatoTicket stato);
}