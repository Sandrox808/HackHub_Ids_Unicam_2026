package Membro.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ORGANIZZATORE")
@NoArgsConstructor
public class Organizzatore extends MembroStaff {
    // Qui metteremo il metodo nuovoHackathon(...) appena l'entità Hackathon sarà pronta
}