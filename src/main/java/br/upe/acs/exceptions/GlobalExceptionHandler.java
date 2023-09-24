package br.upe.acs.exceptions;

import org.springframework.http.HttpStatus;
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
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(CepInvalidException.class)
    public ResponseEntity<Object> handleInvalidCepException(CepInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.getMessage());
    }
}
