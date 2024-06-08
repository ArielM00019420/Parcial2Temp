package com.grupo10.parcial2clinica.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    //Este lo da la asistente
    private LocalDateTime dateTime;
    //Este lo da el usuario
    @NotEmpty
    private String reason;
    //Default value is false
    private Boolean status;
    //Este se autogenera con la solicitud de cita
    @ManyToOne
    private User patient;
    //Este es posterior
    @OneToMany
    @JsonIgnore
    private List<Prescripcion> prescriptions;
    //Este lo genera la asistente
    @OneToMany
    private List<UserXCitaMedica> DoctorAndSpecialty;
}
