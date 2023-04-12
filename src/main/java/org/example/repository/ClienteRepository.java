package org.example.repository;

import org.example.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository <Cliente, Long> {
    List<Cliente> findAll();

}
