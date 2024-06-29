package School.School_micro.Exception.GlobalException;

import School.School_micro.Exception.BusinessException.BusinessException;
import School.School_micro.Exception.CustomException.EmptyObjectException.EmptyObjectException;
import School.School_micro.Exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<BusinessException> handelResourceNotFoundException(ResourceNotFound ex){
        String message = ex.getMessage();
        BusinessException response = BusinessException.builder()
                .statusCode(HttpStatus.NOT_FOUND).errorMessage(message).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyObjectException.class)
    public ResponseEntity<String> handelEmptyObjectException(EmptyObjectException ex){
        String message = ex.getMessage();
        return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
    }

}
