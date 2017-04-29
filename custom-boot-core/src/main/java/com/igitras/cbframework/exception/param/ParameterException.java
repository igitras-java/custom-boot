package com.igitras.cbframework.exception.param;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;
import org.springframework.http.HttpStatus;

/**
 * Base Exception of parameter exception.
 *
 * @author mason
 */
public abstract class ParameterException extends CustomBootException {

    private static final long serialVersionUID = -6354564586252444299L;

    public ParameterException(String detail) {
        // @formatter:off
        this(String.format("Param Error: %s", detail), builder().addArguments(detail).build());
        // @formatter:on
    }

    public ParameterException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return BAD_REQUEST;
    }

}
