package com.igitras.cbframework.exception.request;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import static java.lang.String.format;

import org.springframework.http.HttpStatus;


/**
 * Exception when the requesting resource not exist.
 *
 * @author mason
 */
public final class ResourceNotFoundException extends RequestException {

    private static final long serialVersionUID = -1308741786103945438L;

    public ResourceNotFoundException(String resource) {
        // @formatter:off
        super(format("Request Error: resource [%s] not found", resource), builder().addArguments(resource).build());
        // @formatter:on
    }

    @Override
    public HttpStatus getStatus() {
        return NOT_FOUND;
    }
}
