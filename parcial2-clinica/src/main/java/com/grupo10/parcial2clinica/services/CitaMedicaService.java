package com.grupo10.parcial2clinica.services;

import com.grupo10.parcial2clinica.domain.dtos.AproveeCitaDTO;
import com.grupo10.parcial2clinica.domain.dtos.CreateCitaDTO;
import com.grupo10.parcial2clinica.domain.entities.CitaMedica;
import com.grupo10.parcial2clinica.domain.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaMedicaService {
    List<CitaMedica> findAll();
    List<CitaMedica> findByUserRole(User user);
    Optional<CitaMedica> findByUser(User user);
    void requestCita(CreateCitaDTO info, User user);
    List<CitaMedica> findByDate(LocalDateTime date);
    void aproveCita(AproveeCitaDTO infoToAproveeCita);
    //Practicamente un delete
    void cancelCita(CitaMedica citaMedica);
    //Puede ser para encontrar las citas que estan pendientes, pero meh
//    List<CitaMedica> findByStatus(boolean status);
    //Update del status
}
