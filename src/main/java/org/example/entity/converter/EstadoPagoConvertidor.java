package org.example.entity.converter;

import org.example.entity.types.EstadoPago;

import javax.persistence.AttributeConverter;

public class EstadoPagoConvertidor implements AttributeConverter<EstadoPago, String> {
    @Override
    public String convertToDatabaseColumn(EstadoPago estadoPago) {
        return estadoPago.getEstado();
    }

    @Override
    public EstadoPago convertToEntityAttribute(String s) {
        return EstadoPago.valueOf(s);
    }
}
