package com.grupo10.parcial2clinica.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank private String username;
    @NotBlank private String password;  // TODO: Generar un patron seguro
    @NotBlank
    private String email;
}
