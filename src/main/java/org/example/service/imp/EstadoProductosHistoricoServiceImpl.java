package org.example.service.imp;

import org.example.entity.EstadoProductosHistorico;
import org.example.entity.Producto;
import org.example.entity.types.EstadoEnvio;
import org.example.repository.EstadoProductosHistoricoRepository;
import org.example.service.EstadoProductosHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoProductosHistoricoServiceImpl implements EstadoProductosHistoricoService {
    @Autowired
    private EstadoProductosHistoricoRepository repository;

    @Override
    public void guardarHistorico(Producto producto, EstadoEnvio estadoAnterior) {
        EstadoProductosHistorico estadoProductosHistorico = new EstadoProductosHistorico();
        estadoProductosHistorico.setProducto(producto);
        estadoProductosHistorico.setEstadoEnvioNuevo(producto.getEstadoEnvio());
        estadoProductosHistorico.setEstadoEnvioAnterior(estadoAnterior);
        repository.save(estadoProductosHistorico);
    }
}
