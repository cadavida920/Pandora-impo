package org.example.entity.types;

import lombok.Getter;

public enum EstadoPago {
    PAGADO("PAGADO"), PARCIAL("PARCIAL"), PENDIENTE("PENDIENTE");

    @Getter
    private String estado;

    EstadoPago(String estado) {
        this.estado=estado;
    }

}
