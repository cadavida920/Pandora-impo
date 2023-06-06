package org.example.entity.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoPagoTest {

    @Test
    void valueOf() {
        String palabra = "PENDIENTE";

        EstadoPago estadoPendiente = EstadoPago.valueOf(palabra);

        assertEquals(EstadoPago.PENDIENTE, estadoPendiente);

    }
}