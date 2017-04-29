package com.igitras.cbframework.exception.internal.invocation.database;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.internal.invocation.InvocationException;

/**
 * Data Service Exception.
 *
 * @author mason
 */
public class DataServiceException extends InvocationException {

    private static final long serialVersionUID = -4627727031120595824L;

    public DataServiceException(String target) {
        // @formatter:off
        this(format("Invoking database [%s] failed.", target), builder().addArguments(target).build());
        // @formatter:on
    }

    public DataServiceException(String message, ErrorMessage error) {
        super(message, error);
    }
}
