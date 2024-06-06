package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.dtos.UserInfoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller("/api/user")
public class UserController {
    @GetMapping("/allPatients")
    public ResponseEntity<GeneralResponse> allPatients() {
        return null;
    }
    @GetMapping("/allDoctors")
    public ResponseEntity<GeneralResponse> allDoctors() {
        return null;
    }
    @PutMapping("/toggleStatus")
    public ResponseEntity<GeneralResponse> toggleStatus(@RequestBody @Valid UserInfoDTO info, BindingResult validationResult) {
        return null;
    }

    @GetMapping("/findUser")
    public ResponseEntity<GeneralResponse> getUserByIdentifier(@RequestBody @Valid UserInfoDTO info, BindingResult validationResult) {
        return null;
    }
}


