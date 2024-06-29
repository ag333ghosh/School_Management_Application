package School.School_micro.Exception.CustomException.EmptyObjectException;

import org.springframework.stereotype.Component;


public class EmptyObjectException extends RuntimeException {
    public EmptyObjectException(String message){
        super(message);
    }
}
