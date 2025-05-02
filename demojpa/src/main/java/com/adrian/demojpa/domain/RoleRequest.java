package com.adrian.demojpa.domain;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RoleRequest implements Serializable{

    @NotBlank(message = "El nombre del rol no puede estar vacío")
    @Size(min = 3, max = 20)
    @NotNull(message = "El nombre del rol no puede ser nulo")

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
