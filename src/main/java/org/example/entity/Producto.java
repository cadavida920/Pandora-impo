package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.converter.EstadoEnvioConvertidor;
import org.example.entity.converter.EstadoPagoConvertidor;
import org.example.entity.types.EstadoEnvio;
import org.example.entity.types.EstadoPago;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String descripcionProducto;
    @NonNull
    private int cantidad;
    @NonNull
    private Double costo;

    private Double impuesto;
    @NonNull
    private Double costoEnvio;
    @NonNull
    private Double precioVenta;

    private Double valorRestante;

    @Convert(converter = EstadoEnvioConvertidor.class)
    private EstadoEnvio estadoEnvio;

    @Convert(converter = EstadoPagoConvertidor.class)
    private EstadoPago estadoPago;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}