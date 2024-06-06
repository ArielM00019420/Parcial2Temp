package com.grupo10.parcial2clinica.services;

import com.grupo10.parcial2clinica.domain.dtos.UserRegisterDTO;
import com.grupo10.parcial2clinica.domain.entities.Token;
import com.grupo10.parcial2clinica.domain.entities.User;

public interface UserService {
    User findByIdentifier(String identifier);
    User findByUsernameOrEmail(String username, String email);
    void register(UserRegisterDTO userRegisterDTO);
    boolean checkPassword(User user, String password);

    //Token management
    Token registerToken(User user) throws Exception;
    Boolean isTokenValid(User user, String token);
    void cleanTokens(User user) throws Exception;

    //User management
    User findUserAuthenticated();
}
