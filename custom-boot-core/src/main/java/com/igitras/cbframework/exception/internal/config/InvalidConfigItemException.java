package com.igitras.cbframework.exception.internal.config;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;

/**
 * Invalid Configuration File Path exception. Such as file required but given folder, or something like this. Or the
 * format of content is incorrect.
 *
 * @author mason
 */
public final class InvalidConfigItemException extends ConfigurationException {

    private static final long serialVersionUID = -6139249101300386600L;

    public InvalidConfigItemException(String itemName) {
        // @formatter:off
        super(format("Invalid configuration Item: [%s].", itemName), builder().addArguments(itemName).build());
        // @formatter:on
    }

}
