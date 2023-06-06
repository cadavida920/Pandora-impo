package org.example.service;

import org.example.entity.Producto;
import org.example.entity.types.EstadoEnvio;

public interface EstadoProductosHistoricoService {

    void guardarHistorico(Producto producto, EstadoEnvio estadoEnvioAnterior);

}
