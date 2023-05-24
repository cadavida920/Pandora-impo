package org.example.entity.types;


import lombok.Getter;

import java.util.stream.Stream;


public enum EstadoEnvio  {
    PROCESO_COMPRA ("PC","En proceso de compra"),
    EN_TRANSITO_COL("ETC","En transito a colombia "),
    EN_BODEGA("EB","En bodega"),
    LISTO_PARA_ENVIAR("LPE","Listo para enviar"),
    ENTREGADO("ENTREGADO","En entrega");

    @Getter
    private String mensaje;
    @Getter
    private String codigo;

    EstadoEnvio (String codigo, String mensaje){
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public static EstadoEnvio getEstadoEnvio(String value) {
        return Stream.of(EstadoEnvio.values())
                .filter(estadoEnvio -> estadoEnvio.getCodigo().equals(value))
                .findFirst()
                .orElse(null);
    }


}
