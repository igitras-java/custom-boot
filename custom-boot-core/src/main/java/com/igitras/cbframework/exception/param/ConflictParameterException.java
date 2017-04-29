package com.igitras.cbframework.exception.param;


import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.util.StringUtils.arrayToCommaDelimitedString;

import static java.lang.String.format;
import static java.lang.String.join;

import org.springframework.http.HttpStatus;

/**
 * Exception when parameter cannot exist together.
 *
 * @author mason
 */
public final class ConflictParameterException extends ParameterException {

    private static final long serialVersionUID = -8355126020931780273L;

    public ConflictParameterException(String... paramNames) {
        // @formatter:off
        super(format("Param conflict: %s", join(", ", paramNames)),
                builder().addArguments(arrayToCommaDelimitedString(paramNames)).build());
        // @formatter:on
    }

    @Override
    public HttpStatus getStatus() {
        return CONFLICT;
    }
}
