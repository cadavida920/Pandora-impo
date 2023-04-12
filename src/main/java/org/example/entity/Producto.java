package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private int estadoEnvio;

    private String estadoPago;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}