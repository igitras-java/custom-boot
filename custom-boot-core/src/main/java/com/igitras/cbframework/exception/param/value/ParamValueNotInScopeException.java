package com.igitras.cbframework.exception.param.value;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

import java.util.Arrays;

/**
 * Parameter Exception when param value is not in the given scope.
 *
 * @author mason
 */
public final class ParamValueNotInScopeException extends ParameterValueException {

    private static final long serialVersionUID = 1566543619403080791L;

    public ParamValueNotInScopeException(final String paramName, Object[] scopes) {
        // @formatter:off
        super(format("Param Error: %s not in scope [%s]", paramName, Arrays.toString(scopes)),
                builder().addArguments(paramName, Arrays.toString(scopes)).build());
        // @formatter:on
    }
}
