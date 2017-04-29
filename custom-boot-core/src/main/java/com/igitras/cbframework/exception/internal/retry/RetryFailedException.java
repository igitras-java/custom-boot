package com.igitras.cbframework.exception.internal.retry;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.internal.InternalException;

/**
 * Retried and failed exception. Throw when the task retried for some times, and also failed. Throw when
 * {@link NeedRetryException} exceed the limits.
 *
 * @author mason
 */
public final class RetryFailedException extends InternalException {

    private static final long serialVersionUID = 4217176473090240522L;

    public RetryFailedException(NeedRetryException exception) {
        this(exception, 3);
    }

    public RetryFailedException(NeedRetryException exception, int retriedTime) {
        super(format("Retry failed: %s", exception.getMessage()), builder().addArguments(retriedTime)
                .addArguments(exception.getArguments())
                .addDetails(exception)
                .build());
    }
}
