package com.grupo10.parcial2clinica.repositories;

import com.grupo10.parcial2clinica.domain.entities.Rol;
import com.grupo10.parcial2clinica.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsernameOrEmail(String username, String email);
}
