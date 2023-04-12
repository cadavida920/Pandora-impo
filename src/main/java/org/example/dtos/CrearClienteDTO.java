package org.example.dtos;
import lombok.Data;
import org.example.entity.Cliente;
import java.io.Serializable;

@Data
public class CrearClienteDTO implements Serializable {
    private String nombre;
    private String email;

    public Cliente transformar() {
        Cliente cliente = new Cliente();
        cliente.setBalance(0.0);
        cliente.setNombre(nombre);
        cliente.setCorreo(email);
        return cliente;
    }
}
