package com.igitras.cbframework.exception.internal;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * Internal Exception such as external service invocation, invalid configuration, invalid status etc.
 *
 * @author mason
 */
public class InternalException extends CustomBootException {

    private static final long serialVersionUID = -6551155371392415226L;

    public InternalException() {
        this("Internal Error");
    }

    /**
     * Build internal exception with a message that can be localized.
     *
     * @param message message
     */
    public InternalException(String message) {
        this(message, builder().addArguments(message)
                .build());
    }

    public InternalException(String message, ErrorMessage errorMessage) {
        super(message, errorMessage);
    }

    @Override
    public HttpStatus getStatus() {
        return INTERNAL_SERVER_ERROR;
    }
}
