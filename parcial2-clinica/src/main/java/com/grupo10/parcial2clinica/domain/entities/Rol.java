package com.grupo10.parcial2clinica.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_rols")
public class Rol {
    @Id
    @Pattern(regexp = "^[A-Z]{4}$", message = "El código de la especialidad debe tener 4 letras mayúsculas")
    private String id;
    private String name;

    @OneToMany
    @JsonIgnore
    private List<UserXRol> userRol;

}
