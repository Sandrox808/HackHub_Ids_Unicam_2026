package Membro.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("GIUDICE")
@NoArgsConstructor
@Getter
@Setter
public class Giudice extends MembroStaff {
    // Logica o attributi specifici del Giudice
}