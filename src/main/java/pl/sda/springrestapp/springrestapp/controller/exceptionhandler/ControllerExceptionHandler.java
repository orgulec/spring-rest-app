package pl.sda.springrestapp.springrestapp.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.springrestapp.springrestapp.exceptions.AlreadyOnListException;
import pl.sda.springrestapp.springrestapp.exceptions.NoCarOnListException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AlreadyOnListException.class)
    public ResponseEntity<String> handleExistingCarException(AlreadyOnListException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NoCarOnListException.class)
    public ResponseEntity<String> handleNotExistingCarException(NoCarOnListException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
