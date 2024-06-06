package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.CitasByRolDTO;
import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.dtos.SaveCitaDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller("/api/cita")
public class CitaMedicaController {
    @GetMapping("/allCitas")
    public ResponseEntity<GeneralResponse> allCitas() {
        return null;
    }
    @GetMapping("/allCitasByUserRole")
    public ResponseEntity<GeneralResponse> allCitasByUserRole(@RequestBody @Valid CitasByRolDTO info, BindingResult errors) {
        return null;
    }
    @GetMapping("/allCitasByDate/{date}")
    public ResponseEntity<GeneralResponse> allCitasByDate(@PathVariable LocalDate date) {
        return null;
    }
    @PostMapping("/saveCita")
    public ResponseEntity<GeneralResponse> saveCita(@RequestBody @Valid SaveCitaDTO info, BindingResult errors) {
        return null;
    }
}
