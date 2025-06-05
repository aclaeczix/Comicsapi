package mx.unam.aragon.ico.is.comicsapi.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<HashMap<String,String>>
            handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String,String> errors = new HashMap<>();
        errors.put("timestamp", LocalDateTime.now( ).toString());
        errors.put("mensaje","Error al validar el argumento");
        errors.put("codigo","2001");
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.ok("La peticion no tiene la estructura adecuada");
    }
}
