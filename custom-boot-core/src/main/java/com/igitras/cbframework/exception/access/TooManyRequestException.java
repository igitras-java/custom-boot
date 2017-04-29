package com.igitras.cbframework.exception.access;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;

import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * Exception for user (may be a client, a service or some other system) whose requests met the maximum limitation.
 *
 * @author mason
 */
public class TooManyRequestException extends AccessDeniedException {

    private static final long serialVersionUID = -3200339063243281079L;

    public TooManyRequestException() {
        this("Too many requests.");
    }

    public TooManyRequestException(String message) {
        // @formatter:off
        this(message, builder().build());
        // @formatter:on
    }

    public TooManyRequestException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return TOO_MANY_REQUESTS;
    }
}
