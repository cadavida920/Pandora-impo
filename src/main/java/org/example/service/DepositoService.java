package org.example.service;
import org.example.dtos.ProductoDTO;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import org.example.entity.Depositos;
import java.util.List;
public interface DepositoService {

    Depositos nuevoDeposito (Depositos depositos);
    List<Depositos> consultarDepositoPorCliente (Long idCliente);







}
