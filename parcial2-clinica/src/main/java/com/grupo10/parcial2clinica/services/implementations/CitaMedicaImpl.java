package com.grupo10.parcial2clinica.services.implementations;

import com.grupo10.parcial2clinica.domain.dtos.AproveeCitaDTO;
import com.grupo10.parcial2clinica.domain.dtos.CreateCitaDTO;
import com.grupo10.parcial2clinica.domain.entities.CitaMedica;
import com.grupo10.parcial2clinica.domain.entities.Rol;
import com.grupo10.parcial2clinica.domain.entities.User;
import com.grupo10.parcial2clinica.repositories.CitaMedicaRepository;
import com.grupo10.parcial2clinica.repositories.RolRepository;
import com.grupo10.parcial2clinica.repositories.TokenRepository;
import com.grupo10.parcial2clinica.repositories.UserRepository;
import com.grupo10.parcial2clinica.services.CitaMedicaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CitaMedicaImpl implements CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Autowired
    private RolRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CitaMedica> findAll() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public List<CitaMedica> findByUserRole(User user) {
        if (user.getRols().contains("DCTR")) {
            return citaMedicaRepository.findAllByDoctor(user);
        }
        if (user.getRols().contains("PTNT")) {
            return citaMedicaRepository.findAllByPatient(user);
        }
        return List.of();
    }

    @Override
    public Optional<CitaMedica> findByUser(User user) {
        return citaMedicaRepository.findById(user.getId());
    }

    @Override
    public void requestCita(CreateCitaDTO info, User user) {
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setStatus(false);
        citaMedica.setReason(info.getReason());
        citaMedica.setPatient(user);
        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public List<CitaMedica> findByDate(LocalDateTime date) {
        return citaMedicaRepository.findAllByDateTime(date);
    }

    @Override
    public void aproveCita(AproveeCitaDTO infoToAproveeCita) {
        CitaMedica citaMedica = citaMedicaRepository.findById(infoToAproveeCita.getCitaMedicaId()).orElse(null);
        citaMedica.setDateTime(infoToAproveeCita.getDateTime());
        citaMedica.setDoctorAndSpecialty(infoToAproveeCita.getDoctorAndSpecialty());
        citaMedica.setStatus(true);
        // Anadir rol de paciente al usuario si no lo tiene, la cita ya tiene al usuario que la creo
        User user = citaMedica.getPatient();;
        Rol ptntRole = roleRepository.findById("PTNT");
        if (!user.getRols().contains(ptntRole)) {
            user.getRols().add(ptntRole);
            userRepository.save(user);
        }
        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public void cancelCita(CitaMedica citaMedica) {
    citaMedicaRepository.delete(citaMedica);
    }
}
