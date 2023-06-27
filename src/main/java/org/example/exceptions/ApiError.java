package org.example.exceptions;

public class ApiError  extends  RuntimeException{
    public ApiError(String mensaje) {
        super (mensaje);

    }
}
