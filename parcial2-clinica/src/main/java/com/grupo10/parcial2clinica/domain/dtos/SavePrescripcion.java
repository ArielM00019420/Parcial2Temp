package com.grupo10.parcial2clinica.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SavePrescripcion {
    private String description;
    private LocalDateTime dateTime;
}
