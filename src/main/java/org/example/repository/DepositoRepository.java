package org.example.repository;

import org.example.entity.Depositos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositoRepository  extends CrudRepository<Depositos,Long> {
    List<Depositos> findAllByClienteId(Long idCliente);

}
