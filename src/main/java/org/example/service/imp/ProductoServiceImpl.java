package org.example.service.imp;

import org.example.dtos.ProductoDTO;
import org.example.dtos.UpdateProductoDto;
import org.example.entity.Cliente;
import org.example.entity.Producto;
import org.example.repository.ClienteRepository;
import org.example.repository.ProductoRepository;
import org.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
   private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository  ClienteRepository;

    @Override
    public Producto nuevoProducto(Producto producto) {
        Cliente cliente = ClienteRepository.findById(producto.getCliente().getId()).get();
        producto.setCliente(cliente);
        return productoRepository.save(producto);
    }
    @Override
    public Producto consultarProducto(Long id) {
        Producto producto = productoRepository.findById(id).get();
        return producto;
    }

    @Override
    public List<Producto> consultarProductosPorClienteId(Long id) {
        return productoRepository.findAllByClienteId(id);
    }
    @Override
    public Producto actualizarProducto( UpdateProductoDto productoDto) {
        Producto producto = consultarProducto(productoDto.getId());
        producto.setEstadoEnvio(productoDto.getEstadoEnvio());
        return productoRepository.save(producto);
    }
}
