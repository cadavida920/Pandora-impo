package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ResourceNotFound.class, ApiError.class})
    public ResponseEntity<PandoraErrorDto> handleProductNotFound(RuntimeException resourceNotFound) {
        PandoraErrorDto pandoraErrorDto = new PandoraErrorDto();
        pandoraErrorDto.setMessage(resourceNotFound.getMessage());
        pandoraErrorDto.setStatus(404);
        return new ResponseEntity<>(pandoraErrorDto, HttpStatus.NOT_FOUND);
    }
}
