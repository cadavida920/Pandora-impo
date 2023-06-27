package org.example.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateClienteDto implements Serializable {
    @NotNull(message = "El campo 'id' no puede estar vacío")
    private Long id;

    @NotEmpty(message = "El campo 'nombre' no puede estar vacío")
    private String nombre;

    private String correo;
}
