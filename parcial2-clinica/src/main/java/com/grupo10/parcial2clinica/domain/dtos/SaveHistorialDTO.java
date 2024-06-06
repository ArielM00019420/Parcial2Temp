package com.grupo10.parcial2clinica.domain.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveHistorialDTO {
    private String name;
    private String description;
    private LocalDate date;
}
