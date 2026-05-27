package Hackathon.control;

import Hackathon.entity.Hackathon;
import Hackathon.entity.HackathonRepository;
import Membro.entity.MembroRepository;
import Membro.entity.MembroStaff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Garantisce che le operazioni sul DB siano atomiche e sicure
public class HackathonService {

    private final HackathonRepository hackathonRepository;
    private final MembroRepository membroRepository;

    // Dependency Injection dei repository necessari
    public HackathonService(HackathonRepository hackathonRepository, MembroRepository membroRepository) {
        this.hackathonRepository = hackathonRepository;
        this.membroRepository = membroRepository;
    }

    /**
     * Crea e salva un nuovo Hackathon nel database
     */
    public Hackathon creaHackathon(Hackathon hackathon) {
        return hackathonRepository.save(hackathon);
    }

    /**
     * Ritorna la lista di tutti gli Hackathon presenti nel database
     */
    public List<Hackathon> getAllHackathon() {
        return hackathonRepository.findAll();
    }

    /**
     * Assegna un membro dello staff esistente a un Hackathon esistente
     */
    public void assegnaMembroStaff(Integer hackathonId, Integer membroId) {
        Hackathon hackathon = hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new IllegalArgumentException("Hackathon non trovato con ID: " + hackathonId));

        MembroStaff membro = membroRepository.findById(membroId)
                .orElseThrow(() -> new IllegalArgumentException("Membro dello staff non trovato con ID: " + membroId));

        // Aggiunge il membro alla lista interna dell'entità
        hackathon.getStaffAssegnato().add(membro);

        // Jakarta Persistence si accorge della modifica e aggiorna la tabella di giunzione in automatico
        hackathonRepository.save(hackathon);
    }
}