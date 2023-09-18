package br.upe.acs.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRegisterException.class)
    public ResponseEntity<Object> handleInvalidRegisterException(InvalidRegisterException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(AcsException.class)
    public ResponseEntity<Object> handleAcsException(AcsException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
