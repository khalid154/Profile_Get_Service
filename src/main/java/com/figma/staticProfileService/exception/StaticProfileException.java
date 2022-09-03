package com.figma.staticProfileService.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : Khalid Hasan
 */
@Getter
public class StaticProfileException extends RuntimeException {
    private final HttpStatus status;

    public StaticProfileException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public StaticProfileException(String message) {
        super(message);
        status = org.springframework.http.HttpStatus.BAD_REQUEST;
    }
}
