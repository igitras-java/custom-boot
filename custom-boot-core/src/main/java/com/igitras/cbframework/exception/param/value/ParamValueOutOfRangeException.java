package com.igitras.cbframework.exception.param.value;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import com.google.common.collect.Range;

/**
 * Parameter Exception when param value is out of given range.
 *
 * @author mason
 */
public final class ParamValueOutOfRangeException extends ParameterValueException {

    private static final long serialVersionUID = -6960669214006829421L;

    public ParamValueOutOfRangeException(String paramName, Range range) {
        // @formatter:off
        super(format("Param Error: %s must in range [%s]", paramName, range),
                builder().addArguments(paramName, range).build());
        // @formatter:on
    }
}
