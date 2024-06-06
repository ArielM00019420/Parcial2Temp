package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.dtos.SaveHistorialDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/api/historial")
public class HistorialController {
    @PostMapping("/saveHistorial")
    public ResponseEntity<GeneralResponse> saveHistorial(@RequestBody @Valid SaveHistorialDTO info, BindingResult errors) {
        return null;
    }
    @GetMapping("/{patient}")
    public  ResponseEntity<GeneralResponse> allHistorialesByPatient() {
        return null;
    }

}
