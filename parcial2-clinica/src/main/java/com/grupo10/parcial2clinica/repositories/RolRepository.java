package com.grupo10.parcial2clinica.repositories;

import com.grupo10.parcial2clinica.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RolRepository extends JpaRepository<Rol, UUID>{
    Rol findById(String id);
}
