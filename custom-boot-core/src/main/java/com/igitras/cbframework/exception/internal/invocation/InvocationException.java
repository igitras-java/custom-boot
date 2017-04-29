package com.igitras.cbframework.exception.internal.invocation;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.internal.InternalException;

/**
 * Class {@link InvocationException}. Throw then invoking external service or database or caching system failed.
 *
 * @author mason
 */
public class InvocationException extends InternalException {

    private static final long serialVersionUID = 4646312171775219751L;

    public InvocationException(String target) {
        // @formatter:off
        this(format("Invoking [%s] failed.", target), builder().addArguments(target).build());
        // @formatter:on
    }

    public InvocationException(String message, ErrorMessage error) {
        super(message, error);
    }
}
