package org.example.repository;

import org.example.entity.EstadoProductosHistorico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoProductosHistoricoRepository extends CrudRepository<EstadoProductosHistorico, Long> {



}
