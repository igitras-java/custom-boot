package com.igitras.cbframework.exception.access.auth;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.access.AccessDeniedException;

import org.springframework.http.HttpStatus;

/**
 * Authentication failed exception.
 *
 * @author mason
 */
public class AuthenticationFailedException extends AccessDeniedException {

    private static final long serialVersionUID = 8120022773618749910L;

    public AuthenticationFailedException() {
        this("Authentication Failed.");
    }

    /**
     * Create an {@link AuthenticationFailedException} with message.
     *
     * @param message message
     */
    public AuthenticationFailedException(String message) {
        // @formatter:off
        this(message, builder().addArguments(message).build());
        // @formatter:on
    }

    public AuthenticationFailedException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return UNAUTHORIZED;
    }
}
