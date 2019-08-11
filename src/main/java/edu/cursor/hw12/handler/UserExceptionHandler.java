package edu.cursor.hw12.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleUserInternalServerError() {
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occured");
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorResponse handleUserOk() {
        return new ErrorResponse("Ok", "Data is saved");
    }

    @Data
    public static class ErrorResponse {
        private final String code;
        private final String message;
    }
}

