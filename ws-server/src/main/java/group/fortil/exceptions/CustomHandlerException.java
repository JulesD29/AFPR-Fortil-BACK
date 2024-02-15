package group.fortil.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomHandlerException {

    @ExceptionHandler(value = {CustomNotFoundException.class})
    public ResponseEntity<Object> handleCustomNotFoundException(CustomNotFoundException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        return new ResponseEntity<>(errorMessageDescription, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
