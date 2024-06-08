package com.grupo10.parcial2clinica.domain.dtos;

import com.grupo10.parcial2clinica.domain.entities.UserXCitaMedica;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class AproveeCitaDTO {
    private UUID citaMedicaId;
    private LocalDateTime dateTime;
    private List<UserXCitaMedica> DoctorAndSpecialty;
}
