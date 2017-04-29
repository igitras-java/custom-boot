package com.igitras.cbframework.exception.request;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * Request Exception base class.
 *
 * @author mason
 */
public abstract class RequestException extends CustomBootException {

    private static final long serialVersionUID = -4575058355077662357L;

    public RequestException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return BAD_REQUEST;
    }
}
