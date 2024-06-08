package com.grupo10.parcial2clinica.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "pacial2_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Boolean active;

    //Relaciones
    @OneToMany
    private List<Rol> rols;

    @OneToMany
    private List<Historial> records;

    //Segun roles
    //DCTR (Doctor), PTNT (Patient), ADMN (Admin), ASST (Assitant)
    @OneToMany
    @JsonIgnore
    private List<UserXCitaMedica> citasMedicasDoctor;

    @OneToMany
    private List<CitaMedica> citasMedicasPaciente;

    //Tokens

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Token> tokens;

    // Aqui empiezan las implementaciones necesarias para que User implemente UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //getUsername is already overridden

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

}
