package org.example.dtos;

import lombok.Data;
import org.example.entity.Cliente;
import org.example.entity.Producto;
import org.example.entity.converter.EstadoEnvioConvertidor;
import org.example.entity.converter.EstadoPagoConvertidor;
import org.example.entity.types.EstadoEnvio;
import org.example.entity.types.EstadoPago;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class ProductoDTO implements Serializable {

    private Long id;

    private String descripcionProducto;

    private int cantidad;

    private Double costo;

    private Double impuesto;

    private Double costoEnvio;

    private Double precioVenta;

    private Double valorRestante;

    private  String codigoEstadoEnvio;
    private  String descripcionEstadoEnvio;

    private  String estadoPago;

    private Timestamp updatedOn;

    private Timestamp createdOn;

    private ClienteDTO cliente;

    public static ProductoDTO convertirADTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setDescripcionProducto(producto.getDescripcionProducto());
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setCosto(producto.getCosto());
        productoDTO.setImpuesto(producto.getImpuesto());
        productoDTO.setCostoEnvio(producto.getCostoEnvio());
        productoDTO.setPrecioVenta(producto.getPrecioVenta());
        productoDTO.setValorRestante(producto.getValorRestante());
        productoDTO.setCodigoEstadoEnvio(producto.getEstadoEnvio().getCodigo());
        productoDTO.setDescripcionEstadoEnvio(producto.getEstadoEnvio().getMensaje());
        productoDTO.setEstadoPago(producto.getEstadoPago().getEstado());
        productoDTO.setUpdatedOn(producto.getUpdatedOn());
        productoDTO.setCreatedOn(producto.getCreatedOn());
        ClienteDTO clienteDTO = ClienteDTO.transformar(producto.getCliente());
        productoDTO.setCliente(clienteDTO);

        return productoDTO;
    }
}
