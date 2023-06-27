package org.example.dtos;
import lombok.Data;
import org.example.entity.Cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CrearClienteDTO implements Serializable {

    @NotNull(message = "El campo 'nombre' no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "El campo 'apellido' no puede estar vacío")
    private  String apellido;
    private String email;

    public Cliente transformar() {
        Cliente cliente = new Cliente();
        cliente.setBalance(0.0);
        cliente.setNombre(nombre + " " + apellido);
        cliente.setCorreo(email);

        return cliente;
    }
}
