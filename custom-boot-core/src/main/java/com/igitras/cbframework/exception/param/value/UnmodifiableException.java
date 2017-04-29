package com.igitras.cbframework.exception.param.value;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

/**
 * Parameter Exception when unmodifiable param value changed.
 *
 * @author mason
 */
public final class UnmodifiableException extends ParameterValueException {

    private static final long serialVersionUID = -3358816010569362470L;

    public UnmodifiableException(String paramName) {
        // @formatter:off
        super(format("Param Error: %s cannot be modified", paramName), builder().addArguments(paramName).build());
        // @formatter:on
    }
}
