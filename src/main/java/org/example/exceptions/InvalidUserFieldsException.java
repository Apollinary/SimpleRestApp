package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Incorrect attributes.")
public class InvalidUserFieldsException extends RuntimeException {
    public InvalidUserFieldsException(String message) {
        super(message);
    }
}