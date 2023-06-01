package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateProductoDto {
    private String estadoEnvio;
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
}
