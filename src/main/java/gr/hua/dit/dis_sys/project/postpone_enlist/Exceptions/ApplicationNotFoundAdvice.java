package gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//If application doesn't exist send an HTTP STATUS NOT_FOUND and the message from ApplicationNotFoundException Class
@ControllerAdvice
public class ApplicationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ApplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String applicationNotFoundHandler(ApplicationNotFoundException ex) {
        return ex.getMessage();
    }
}
