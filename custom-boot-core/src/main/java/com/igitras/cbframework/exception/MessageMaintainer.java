package com.igitras.cbframework.exception;

/**
 * Class {@link MessageMaintainer}.
 *
 * @author mason
 */
public interface MessageMaintainer {

    /**
     * Add message code(s) to the maintainer.
     *
     * @param codes codes
     * @return Maintainer
     */
    MessageMaintainer addCodes(String... codes);

    /**
     * Add arguments to the maintainer.
     *
     * @param arguments arguments
     * @return Maintainer
     */
    MessageMaintainer addArguments(Object... arguments);

    /**
     * Add default Error message.
     *
     * @param defaultMessage default message
     * @return Maintainer
     */
    MessageMaintainer setDefaultMessage(String defaultMessage);
}
