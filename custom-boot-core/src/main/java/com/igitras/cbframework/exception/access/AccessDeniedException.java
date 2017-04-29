package com.igitras.cbframework.exception.access;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * Base exception for user not allow to visit the resource.
 *
 * @author mason
 */
public abstract class AccessDeniedException extends CustomBootException {

    private static final long serialVersionUID = 2663751739941414140L;

    /**
     * Create Access decision with message.
     *
     * @param message message
     */
    public AccessDeniedException(String message) {
        // @formatter:off
        this(message, builder().addArguments(message).build());
        // @formatter:on
    }

    public AccessDeniedException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return FORBIDDEN;
    }
}
