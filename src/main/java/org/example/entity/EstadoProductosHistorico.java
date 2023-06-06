package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.converter.EstadoEnvioConvertidor;
import org.example.entity.types.EstadoEnvio;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "estadosHistoricos")
public class EstadoProductosHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @Convert(converter = EstadoEnvioConvertidor.class)
    private EstadoEnvio estadoEnvioAnterior;

    @Convert(converter = EstadoEnvioConvertidor.class)
    private EstadoEnvio estadoEnvioNuevo;

    @Column
    @CreationTimestamp
    private Timestamp createdOn;



}
