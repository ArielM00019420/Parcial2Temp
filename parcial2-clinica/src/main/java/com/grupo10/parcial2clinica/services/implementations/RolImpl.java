package com.grupo10.parcial2clinica.services.implementations;

import com.grupo10.parcial2clinica.domain.dtos.SaveRolDTO;
import com.grupo10.parcial2clinica.domain.entities.Rol;
import com.grupo10.parcial2clinica.repositories.RolRepository;
import com.grupo10.parcial2clinica.services.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RolImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findRoleById(String id) {
        return rolRepository.findById(id);
    }

    @Override
    public void save(SaveRolDTO info) {
        Rol rol = new Rol();
        rol.setId(info.getId());
        rol.setName(info.getName());
        rol.setDescription(info.getDescription());
        rolRepository.save(rol);
    }
}
