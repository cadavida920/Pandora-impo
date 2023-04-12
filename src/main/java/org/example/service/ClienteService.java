package org.example.service;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);

    List<Cliente> obtenerTodosLosClientes();

    Cliente actualizarCliente( UpdateClienteDto actualizarclienteDto);


}
