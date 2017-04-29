package com.igitras.cbframework.exception.internal.invocation.external;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.internal.invocation.InvocationException;

/**
 * External Service Invocation Exception.
 *
 * @author mason
 */
public class ExternalInvocationException extends InvocationException {

    private static final long serialVersionUID = 6685682785304330618L;

    public ExternalInvocationException(String target) {
        // @formatter:off
        this(format("Invoking database [%s] failed.", target), builder().addArguments(target).build());
        // @formatter:on
    }

    public ExternalInvocationException(String message, ErrorMessage error) {
        super(message, error);
    }
}
