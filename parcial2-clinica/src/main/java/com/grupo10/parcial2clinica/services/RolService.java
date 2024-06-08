package com.grupo10.parcial2clinica.services;

import com.grupo10.parcial2clinica.domain.dtos.SaveRolDTO;
import com.grupo10.parcial2clinica.domain.entities.Rol;
import jakarta.validation.Valid;

import java.util.List;

public interface RolService {
    List<Rol> findAllRoles();
    Rol findRoleById(String id);
    void save(@Valid SaveRolDTO info);
}
