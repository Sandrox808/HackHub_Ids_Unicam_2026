package Membro.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("MENTORE")
@NoArgsConstructor
@Getter
@Setter
public class Mentore extends MembroStaff {
// Logica o attributi specifici del Mentore
}