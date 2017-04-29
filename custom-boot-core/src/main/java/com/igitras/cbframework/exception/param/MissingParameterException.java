package com.igitras.cbframework.exception.param;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static org.springframework.util.StringUtils.arrayToCommaDelimitedString;

import static java.lang.String.format;
import static java.lang.String.join;

/**
 * Parameter Exception when missing some param.
 *
 * @author mason
 */
public final class MissingParameterException extends ParameterException {

    private static final long serialVersionUID = 8810039359631396123L;

    public MissingParameterException(String... paramNames) {
        // @formatter:off
        super(format("Missing param: %s", join(", ", paramNames)),
                builder().addArguments(arrayToCommaDelimitedString(paramNames)).build());
        // @formatter:on
    }
}
