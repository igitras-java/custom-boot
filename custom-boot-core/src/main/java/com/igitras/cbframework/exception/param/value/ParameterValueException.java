package com.igitras.cbframework.exception.param.value;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.ResolvableArgument;
import com.igitras.cbframework.exception.param.ParameterException;

/**
 * Base Exception of invalid param value.
 *
 * @author mason
 */
public class ParameterValueException extends ParameterException {

    private static final long serialVersionUID = -8016658273100227611L;

    public ParameterValueException(String detail) {
        // @formatter:off
        this(String.format("Param Error: %s", detail), builder().addArguments(detail).build());
        // @formatter:on
    }

    public ParameterValueException(ResolvableArgument argument) {
        this(String.format("Param Error: %s", argument.getDefaultMessage()), builder().addArguments(argument).build());
    }

    public ParameterValueException(String message, ErrorMessage error) {
        super(message, error);
    }
}
