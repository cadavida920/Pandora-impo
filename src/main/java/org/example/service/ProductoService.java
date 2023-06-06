package org.example.service;

import org.example.dtos.UpdateProductoDto;
import org.example.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto nuevoProducto (Producto producto);
    Producto consultarProducto (Long id);
    List<Producto> consultarProductosPorClienteId(Long id);

    List<Producto> obtenerTodosLosProductos();

    Producto actualizarProducto(UpdateProductoDto producto);
}
