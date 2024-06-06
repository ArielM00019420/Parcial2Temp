package com.grupo10.parcial2clinica.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaveCitaDTO {
    private LocalDateTime dateTime;
    private String motive;
    private Boolean status;
}
