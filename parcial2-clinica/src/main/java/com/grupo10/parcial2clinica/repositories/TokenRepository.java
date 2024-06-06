package com.grupo10.parcial2clinica.repositories;

import com.grupo10.parcial2clinica.domain.entities.Token;
import com.grupo10.parcial2clinica.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    List<Token> findByUserAndActive(User user, Boolean active);
}
