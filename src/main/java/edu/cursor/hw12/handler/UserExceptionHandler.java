package edu.cursor.hw12.handler;

import edu.cursor.hw12.entities.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler extends Throwable {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public HttpResponse handleUserInternalServerError() {
        return new HttpResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occured", true);
    }
}

