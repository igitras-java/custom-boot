package com.igitras.cbframework.exception.internal.invocation;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.igitras.cbframework.exception.ErrorMessage;


/**
 * Class {@link WrapInvocationException}.
 *
 * @author mason
 */
public final class WrapInvocationException extends InvocationException {

    private static final long serialVersionUID = -3079098542701459447L;

    public WrapInvocationException(String target, ErrorMessage error) {
        super(format("Invoking [%s] failed.", target), builder().addArguments(target).addDetails(error).build());
    }

}
