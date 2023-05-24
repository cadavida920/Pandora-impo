package org.example.repository;
import org.example.entity.Cliente;
import org.example.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {
    List<Producto> findAllByClienteId(Long id);
    List<Producto> findAll();

}
