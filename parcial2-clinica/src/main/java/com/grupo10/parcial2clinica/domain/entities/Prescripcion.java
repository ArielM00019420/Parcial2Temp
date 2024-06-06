package com.grupo10.parcial2clinica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_prescripcions")
public class Prescripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;
    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    private CitaMedica citaMedica;
}
