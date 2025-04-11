package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.dto.rest.ServiceResponse;
import org.example.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CommonControllerAdvice {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ServiceResponse onException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return ServiceResponse.builder().status("ERROR").errorMessage(e.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ServiceResponse onException(Exception e, HttpServletRequest request) {
        return ServiceResponse.builder().status("ERROR").errorMessage(e.getMessage()).build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return ResponseEntity.notFound().build();
    }
}
