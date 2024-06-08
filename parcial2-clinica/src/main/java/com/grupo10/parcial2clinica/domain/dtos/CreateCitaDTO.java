package com.grupo10.parcial2clinica.domain.dtos;

import com.grupo10.parcial2clinica.domain.entities.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCitaDTO {
    private String reason;
    private LocalDate requestedDate;

}
