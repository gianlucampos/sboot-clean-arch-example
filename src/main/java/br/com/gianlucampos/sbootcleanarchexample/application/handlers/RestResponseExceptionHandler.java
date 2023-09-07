package br.com.gianlucampos.sbootcleanarchexample.application.handlers;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.CustomErrorRepresentation;
import br.com.gianlucampos.sbootcleanarchexample.domain.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<CustomErrorRepresentation> handleObjectNotFoundException(ObjectNotFoundException e) {
        CustomErrorRepresentation error = buildCustomError(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getStatusCode()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomErrorRepresentation> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        CustomErrorRepresentation error = buildCustomError(e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getStatusCode()));

    }


    private CustomErrorRepresentation buildCustomError(String errorMsg, Integer statusCode) {
        return CustomErrorRepresentation.builder()
                .errorMsg(errorMsg)
                .statusCode(statusCode)
                .correlationId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toString())
                .build();
    }

}
