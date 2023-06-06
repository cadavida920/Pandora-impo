package org.example.dtos;

import lombok.Data;
import org.example.entity.Cliente;
import org.example.entity.Producto;
import org.example.entity.types.EstadoEnvio;
import org.example.entity.types.EstadoPago;

import java.io.Serializable;

@Data
public class CrearProductoDTO implements Serializable {
    private String descripcionProducto;
    private int cantidad;
    private Double costo;
    private Double impuesto;
    private Double costoEnvio;
    private Long clienteId;

    public Producto transformar() {
        Producto producto = new Producto();
        producto.setDescripcionProducto(descripcionProducto);
        producto.setCantidad(cantidad);
        producto.setCosto(costo);
        producto.setImpuesto(impuesto);
        producto.setCostoEnvio(costoEnvio);
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        producto.setCliente(cliente);
        producto.setPrecioVenta((costo*cantidad+ impuesto + costoEnvio) * 1.1);
        producto.setValorRestante(producto.getPrecioVenta());
        producto.setEstadoPago(EstadoPago.PENDIENTE);
        producto.setEstadoEnvio(EstadoEnvio.PROCESO_COMPRA);
        return producto;
    }
}




