package com.igitras.cbframework.exception.request;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.ResolvableArgument;

/**
 * Bad Request Exception.
 *
 * @author mason
 */
public final class BadRequestException extends RequestException {
    private static final long serialVersionUID = 2721579400419652465L;

    public BadRequestException(String details) {
        // @formatter:off
        super(format("Request Error: %s", details), builder().addArguments(details).build());
        // @formatter:on
    }

    public BadRequestException(ResolvableArgument argument) {
        super(format("Request Error: %s", argument.getDefaultMessage()), builder().addArguments(argument).build());
    }
}
