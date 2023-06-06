package org.example.entity.converter;

import org.example.entity.types.EstadoEnvio;

import javax.persistence.AttributeConverter;

public class EstadoEnvioConvertidor  implements AttributeConverter<EstadoEnvio, String>  {
    @Override
    public String convertToDatabaseColumn(EstadoEnvio estadoEnvio) {
        return estadoEnvio.getCodigo();
    }

    @Override
    public EstadoEnvio convertToEntityAttribute(String s) {
        return EstadoEnvio.getEstadoEnvio(s);
    }
}
