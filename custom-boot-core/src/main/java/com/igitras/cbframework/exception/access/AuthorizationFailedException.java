package com.igitras.cbframework.exception.access;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import com.igitras.cbframework.exception.ErrorMessage;

/**
 * Authorization Failed Exception.
 *
 * @author mason
 */
public class AuthorizationFailedException extends AccessDeniedException {

    private static final long serialVersionUID = 4536862855099653274L;

    public AuthorizationFailedException() {
        this("Authorization Failed");
    }

    public AuthorizationFailedException(String message) {
        // @formatter:off
        this(message, builder().addArguments(message).build());
        // @formatter:on
    }

    public AuthorizationFailedException(String message, ErrorMessage error) {
        super(message, error);
    }
}
