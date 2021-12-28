package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//If application already exists send an HTTP STATUS CONFLICT and the message from ApplicationAlreadyExistsException Class
@ControllerAdvice
public class ApplicationAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(ApplicationAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String applicationAlreadyExistsHandler(ApplicationAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
