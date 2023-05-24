package org.example.service.imp;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import org.example.repository.ClienteRepository;
import org.example.service.ClienteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> byId = repository.findById(id);
        return byId.get();
    }



    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> all = repository.findAll();
        return all;
    }


    @Override
    public Cliente actualizarCliente(UpdateClienteDto actualizarcliente) {
        Cliente cliente = repository.findById(actualizarcliente.getId()).get();
        cliente.setNombre(actualizarcliente.getNombre());
        repository.save(cliente);
        return cliente;
    }



}

