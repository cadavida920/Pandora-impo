package org.example.service;

import org.example.entity.Depositos;

import java.util.List;
public interface DepositoService {

    Depositos nuevoDeposito (Depositos depositos);
    List<Depositos> consultarDepositoPorCliente(Long idCliente);

    Depositos consultarDepositoPorId(Long idDeposito);

    List<Depositos> consultarTodosLosDepositos();


}
