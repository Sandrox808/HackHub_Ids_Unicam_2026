package Membro.control;

import Membro.entity.MembroRepository;
import Membro.entity.MembroStaff;
import Hackathon.entity.Hackathon;
import Hackathon.entity.HackathonRepository;
import Sottomissione.entity.Sottomissione;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class MembroService {

    private final MembroRepository membroRepository;
    private final HackathonRepository hackathonRepository;

    // Dependency Injection di entrambi i repository necessari
    public MembroService(MembroRepository membroRepository, HackathonRepository hackathonRepository) {
        this.membroRepository = membroRepository;
        this.hackathonRepository = hackathonRepository;
    }

    /**
     * Recupera tutti gli hackathon presenti nella tabella del DB.
     */
    public List<Hackathon> getAllHackathon() {
        return hackathonRepository.findAll();
    }

    /**
     * Controlla se il membro è assegnato all'hackathon dato;
     * se vero, restituisce la lista delle sottomissioni reali di quell'hackathon.
     */
    public List<Sottomissione> getSottomissioni(Integer membroId, Integer hackathonId) {
        // 1. Recuperiamo il membro dallo staff
        MembroStaff membro = membroRepository.findById(membroId)
                .orElseThrow(() -> new IllegalArgumentException("Membro dello staff non trovato con ID: " + membroId));

        // 2. Recuperiamo l'hackathon dal DB (approccio più sicuro passando l'ID)
        Hackathon hackathon = hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new IllegalArgumentException("Hackathon non trovato con ID: " + hackathonId));

        // 3. Verifichiamo l'assegnazione usando la logica interna dell'Entity
        if (!hackathon.haMembroStaff(membro.getId())) {
            throw new SecurityException("Accesso negato: Il membro " + membro.getNome() + " non è assegnato a questo Hackathon.");
        }

        // 4. Restituiamo la lista di entità Sottomissione reali
        return hackathon.getSottomissioni();
    }
}