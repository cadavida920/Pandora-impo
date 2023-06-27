package org.example.dtos;

import lombok.Data;
import org.example.entity.Cliente;
import org.example.entity.Producto;
import org.example.entity.types.EstadoEnvio;
import org.example.entity.types.EstadoPago;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CrearProductoDTO implements Serializable {

    @NotEmpty(message = "El campo 'descripcion' no puede estar vacío")
    private String descripcionProducto;
    @NotNull(message = "El campo 'cantidad' no puede estar vacío")
    private int cantidad;
    @NotNull(message = "El campo 'costo' no puede estar vacío")
    private Double costo;
    private Double impuesto;
    private Double costoEnvio;

    @NotNull(message = "El campo 'cliente' no puede estar vacío")
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




