package org.example.service.imp;

import org.example.dtos.ProductoDTO;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import org.example.entity.Depositos;
import org.example.entity.Producto;
import org.example.repository.ClienteRepository;
import org.example.repository.DepositoRepository;
import org.example.service.DepositoService;
import org.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DepositoServiceImpl  implements DepositoService {
    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public Depositos nuevoDeposito(Depositos depositos) {
        Cliente cliente = clienteRepository.findById(depositos.getCliente().getId()).get();

        List<Producto> productos = productoService.consultarProductosPorClienteId(cliente.getId());

        AtomicReference<Double> valorDeposito = new AtomicReference<>(depositos.getValorDeposito());

        productos.forEach(
                producto -> {
                    // pregunto si tengo plata para reducir la deuda
                    if (valorDeposito.get() > 0d ) {
                        if (valorDeposito.get() >= producto.getValorRestante()) {
                            valorDeposito.set(valorDeposito.get() - producto.getValorRestante());
                            producto.setValorRestante(0d);
                            producto.setEstadoPago("PAGADO");
                        } else {
                            producto.setValorRestante(producto.getValorRestante() - valorDeposito.get());
                            valorDeposito.set(0d);
                            producto.setEstadoPago("PARCIAL");
                        }
                    }
                }
        );

        cliente.setBalance(cliente.getBalance() + valorDeposito.get());
        clienteRepository.save(cliente);
        depositos.setCliente(cliente);
        return depositoRepository.save(depositos);
    }
    @Override
    public List<Depositos> consultarDepositoPorCliente(Long idCliente) {
        return depositoRepository.findAllByClienteId(idCliente);
    }

    @Override
    public Depositos consultarDepositoPorId(Long idDeposito) {
        return depositoRepository.findById(idDeposito)
                .orElseThrow(() -> new EntityNotFoundException("Deposito no encontrado"));
    }

    @Override
    public List<Depositos> consultarTodosLosDepositos() {
        return depositoRepository.findAll();
    }

}
