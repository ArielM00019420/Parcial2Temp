package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.AproveeCitaDTO;
import com.grupo10.parcial2clinica.domain.dtos.CreateCitaDTO;
import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.entities.CitaMedica;
import com.grupo10.parcial2clinica.domain.entities.User;
import com.grupo10.parcial2clinica.services.CitaMedicaService;
import com.grupo10.parcial2clinica.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/api/cita")
public class CitaMedicaController {
    @Autowired
    private CitaMedicaService citaMedicaService;
    @Autowired
    private UserService userService;

    @GetMapping("/allCitas")
    public ResponseEntity<GeneralResponse> allCitas() {
        return GeneralResponse.getResponse(
                citaMedicaService.findAll()
        );
    }
    @GetMapping("/allCitasByUser")
    public ResponseEntity<GeneralResponse> allCitasByUser() {
        User user = userService.findUserAuthenticated();
        if (user == null) return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "No user found");
        return GeneralResponse.getResponse(
                citaMedicaService.findByUser(user)
        );
    }
    //De momento no me convence
//    @GetMapping("/allCitasByUserRole")
//    public ResponseEntity<GeneralResponse> allCitasByUserRole() {
//        User user = userService.findUserAuthenticated();
//        if (user == null) return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "No user found");
//        return GeneralResponse.getResponse(
//                citaMedicaService.findByUserRole(user)
//        );
//    }
    //No urge
//    @GetMapping("/allCitasByDate/{date}")
//    public ResponseEntity<GeneralResponse> allCitasByDate(@PathVariable LocalDate date) {
//        return null;
//    }

    @PostMapping("/requestCita")
    public ResponseEntity<GeneralResponse> createCita(@RequestBody @Valid CreateCitaDTO info, BindingResult errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = errors.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();
            return GeneralResponse.getResponse(HttpStatus.BAD_REQUEST, errorMessages.toString());
        }

        User user = userService.findUserAuthenticated();
        if (user == null) return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "Debes iniciar sesion");
        citaMedicaService.requestCita(info, user);
        return GeneralResponse.getResponse(HttpStatus.OK, "Cita creada");
    }

    @PostMapping("/aproveCita")
    public ResponseEntity<GeneralResponse> completeCita(@RequestBody @Valid AproveeCitaDTO info, BindingResult errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = errors.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();
            return GeneralResponse.getResponse(HttpStatus.BAD_REQUEST, errorMessages.toString());
        }
        User user = userService.findUserAuthenticated();
        if (user == null) return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "Debes iniciar sesion");
        if (!user.getRols().contains("ASST")) return GeneralResponse.getResponse(HttpStatus.FORBIDDEN, "No tiene permisos para aprobar citas");
        citaMedicaService.aproveCita(info);
        return GeneralResponse.getResponse(HttpStatus.OK, "Cita aprobada");
    }
}
