package org.example.exceptions;

import lombok.Data;

@Data
public class PandoraErrorDto {
    private Integer status;
    private String message;
}
