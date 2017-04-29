package com.igitras.cbframework.exception.internal.config;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import static java.lang.String.format;


/**
 * Exceptions when the configuration file not found.
 *
 * @author mason
 */
public final class MissingConfigItemException extends ConfigurationException {

    private static final long serialVersionUID = -6457380477319505032L;

    public MissingConfigItemException(String itemName) {
        // @formatter:off
        super(format("Missing configuration item: [%s].", itemName), builder().addArguments(itemName).build());
        // @formatter:on
    }


}
