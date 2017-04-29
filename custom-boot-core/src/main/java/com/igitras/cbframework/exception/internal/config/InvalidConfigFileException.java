package com.igitras.cbframework.exception.internal.config;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;
import static org.springframework.util.StringUtils.arrayToCommaDelimitedString;

import static java.lang.String.format;
import static java.lang.String.join;

/**
 * Invalid Configuration File Path exception. Such as file required but given folder, or something like this. Or the
 * format of content is incorrect.
 *
 * @author mason
 */
public final class InvalidConfigFileException extends ConfigurationException {

    private static final long serialVersionUID = -6139249101300386600L;

    public InvalidConfigFileException(String fileName) {
        // @formatter:off
        super(format("Invalid configuration files: [%s].", fileName), builder().addArguments(fileName).build());
        // @formatter:on
    }

}
