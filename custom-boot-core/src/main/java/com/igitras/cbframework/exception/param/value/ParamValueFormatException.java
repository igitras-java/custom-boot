package com.igitras.cbframework.exception.param.value;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

/**
 * Parameter Exception when param value not match the pattern.
 *
 * @author mason
 */
public final class ParamValueFormatException extends ParameterValueException {

    private static final long serialVersionUID = 6672772025055721120L;

    public ParamValueFormatException(String paramName, Object pattern) {
        // @formatter:off
        super(format("Param Error: %s doesn't match pattern %s", paramName, pattern),
                builder().addArguments(paramName, pattern).build());
        // @formatter:on
    }
}
