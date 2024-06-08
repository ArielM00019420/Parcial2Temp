package com.grupo10.parcial2clinica.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_especialty")
public class Especialidad {
    @Id
    @Pattern(regexp = "^[A-Z]{4}$", message = "El código de la especialidad debe tener 4 letras mayúsculas")
    private UUID id;
    private String name;

    @OneToMany
    private List<UserXCitaMedica> doctorSpecialty;
}
