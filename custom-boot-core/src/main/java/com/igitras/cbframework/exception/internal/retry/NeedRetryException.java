package com.igitras.cbframework.exception.internal.retry;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.internal.InternalException;
import com.igitras.cbframework.exception.internal.invocation.InvocationException;

/**
 * Retry need exception. Throw when the task need retry. Should only be thrown by remote process call.
 *
 * @author mason
 */
public final class NeedRetryException extends InternalException {

    private static final long serialVersionUID = 4217176473090240522L;

    public NeedRetryException(InvocationException invocationException) {
        super(format("Retry required: %s", invocationException.getMessage()),
                builder().addArguments(invocationException.getArguments()).addDetails(invocationException).build());
    }

}
