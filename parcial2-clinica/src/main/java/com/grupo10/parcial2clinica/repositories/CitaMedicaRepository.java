package com.grupo10.parcial2clinica.repositories;


import com.grupo10.parcial2clinica.domain.entities.CitaMedica;
import com.grupo10.parcial2clinica.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, UUID> {
    Optional<CitaMedica> findById(UUID id);
    List<CitaMedica> findAll();
    List<CitaMedica> findAllByPatientAndStatusIsFalse(User patient);
    List<CitaMedica> findAllByDateTime(LocalDateTime dateTime);
    List<CitaMedica> findAllByPatient(User patient);
    List<CitaMedica> findAllByDoctor(User doctor);
    CitaMedica save(CitaMedica citaMedica);
    void delete(CitaMedica citaMedica);

}
