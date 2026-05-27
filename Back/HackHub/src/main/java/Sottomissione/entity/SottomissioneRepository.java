package Sottomissione.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SottomissioneRepository extends JpaRepository<Sottomissione, Integer> {
    // Query personalizzata automatica per trovare le sottomissioni di uno specifico Hackathon
    List<Sottomissione> findByHackathonId(Integer hackathonId);
}