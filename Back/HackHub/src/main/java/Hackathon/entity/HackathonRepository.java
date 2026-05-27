package Hackathon.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HackathonRepository extends JpaRepository<Hackathon, Integer> {
    // Tutti i metodi come findAll(), findById(), save() sono ereditati automaticamente
}