package org.example.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String mensaje) {
        super(mensaje);
    }
}
