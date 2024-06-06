package com.grupo10.parcial2clinica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_citaMedica")
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime dateTime;
    private String motive;
    private Boolean status;

    @OneToMany
    private List<User> patients;

    @OneToMany
    private List<Prescripcion> prescriptions;
}
