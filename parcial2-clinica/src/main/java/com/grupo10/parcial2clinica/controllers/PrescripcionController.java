package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.dtos.SavePrescripcion;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller("/api/prescripcion")
public class PrescripcionController {
    @PostMapping("/savePrescripcion")
    public ResponseEntity<GeneralResponse> savePrescripcion(@RequestBody @Valid SavePrescripcion info, BindingResult errors) {
        return null;
    }
    @GetMapping("/{cita}")
    public ResponseEntity<GeneralResponse> allPrescripcionesByCita(@PathVariable UUID cita ) {
        return null;
    }

}
