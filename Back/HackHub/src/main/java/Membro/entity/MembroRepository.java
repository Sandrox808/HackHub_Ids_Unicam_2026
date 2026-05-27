package Membro.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroStaff, Integer> {
    // Vuoto! Non c'è codice qui dentro.
}