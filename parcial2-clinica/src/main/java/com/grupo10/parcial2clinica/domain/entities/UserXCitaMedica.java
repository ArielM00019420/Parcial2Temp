package com.grupo10.parcial2clinica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_userXcitaMedica")
public class UserXCitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "citaMedica_id")
    private CitaMedica citaMedica;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
}
