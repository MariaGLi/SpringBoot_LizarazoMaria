package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.infrastructure.controller.Error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

import com.adrian.demojpa.application.service.RolService;

@Service
public class RolServiceImpl implements RolService{

    private final RoleRepository roleRepository;

    public RolServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }   

    private Optional <Rol> getRolByName (String rolName) {
        return roleRepository.findByName(rolName);
    }

    @Override
    public List<Rol> findAllRolesFilter(String filter, String value) {
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name) {
       Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateException("El rol " + name +" ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);
    }

    @Override
    public Rol removeRol(Long id) {
        Optional<Rol> rol = roleRepository.findById(id);
        if (!rol.isPresent()) {
            throw new EntityNotFoundException("El rol con id " + id + " no existe");
        }

        if (!rol.get().getPersons().isEmpty()) {
            throw new EntityNotFoundException("El rol con id " + id + " está asociado con otra tabla, no se puede eliminar.");
        }
        //roleRepository.deleteById(id);
        roleRepository.delete(rol.get());
        return rol.get();
    }
}