package com.igitras.cbframework.exception.internal.config;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.internal.InternalException;

/**
 * Class {@link ConfigurationException}. Thrown when found system configuration is invalid. Always, should terminal
 * the application or send notification to system admin.
 *
 * @author mason
 */
public class ConfigurationException extends InternalException {

    private static final long serialVersionUID = 9219369891982064928L;

    public ConfigurationException(String message, Object... args) {
        // @formatter:off
        this(message, builder().addArguments(args).build());
        // @formatter:on
    }

    public ConfigurationException(String message, ErrorMessage error) {
        super(message, error);
    }
}
