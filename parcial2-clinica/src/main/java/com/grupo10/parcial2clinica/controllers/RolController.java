package com.grupo10.parcial2clinica.controllers;

import com.grupo10.parcial2clinica.domain.dtos.AddRoleDTO;
import com.grupo10.parcial2clinica.domain.dtos.GeneralResponse;
import com.grupo10.parcial2clinica.domain.dtos.SaveRolDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/api/rol")
public class RolController {
    @PostMapping("/saveRol")
    public ResponseEntity<GeneralResponse> saveRol(@RequestBody @Valid SaveRolDTO newRol, BindingResult errors) {
        return null;
    }
    @GetMapping("/allRoles")
    public ResponseEntity<GeneralResponse> allRoles() {
        return null;
    }
    @PutMapping("/updateRoleToUser")
    public ResponseEntity<GeneralResponse> updateRole(@RequestBody @Valid AddRoleDTO updateRol, BindingResult errors ) {
        return null;
    }

}
