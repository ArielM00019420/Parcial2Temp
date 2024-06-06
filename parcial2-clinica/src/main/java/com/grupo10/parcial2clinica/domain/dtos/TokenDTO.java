package com.grupo10.parcial2clinica.domain.dtos;

import com.grupo10.parcial2clinica.domain.entities.Token;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {
    private String token;

    public TokenDTO(Token token) {
        this.token = token.getContent();
    }
}
