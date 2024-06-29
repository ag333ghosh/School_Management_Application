package School.School_micro.Exception.BusinessException;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessException {
    String errorMessage;
    HttpStatus statusCode;
}
