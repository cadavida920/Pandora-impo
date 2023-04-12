package org.example.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateClienteDto implements Serializable {
    private Long id;
    private String nombre;
    private String correo;




}
