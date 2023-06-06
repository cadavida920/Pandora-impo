package org.example.entity.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoEnvioTest {

    @Test
    void valueOf() {
        EstadoEnvio pc = EstadoEnvio.valueOf("PROCESO_COMPRA");
        assertEquals(EstadoEnvio.PROCESO_COMPRA, pc);
    }
}