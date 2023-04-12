package org.example.dtos;
import lombok.Data;
import org.example.entity.Cliente;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {
    private Long id;
    private double balance;
    private String nombre;
    private String email;

    public static ClienteDTO transformar(Cliente cliente)  {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setBalance(cliente.getBalance());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getCorreo());
        return clienteDTO;
    }
}
