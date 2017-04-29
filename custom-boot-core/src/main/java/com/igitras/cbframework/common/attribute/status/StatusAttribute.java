package com.igitras.cbframework.common.attribute.status;


import com.igitras.cbframework.common.attribute.RequestAttribute;
import com.igitras.cbframework.exception.ErrorMessage;

/**
 * Class {@link StatusAttribute}.
 *
 * @author mason
 */
public interface StatusAttribute extends RequestAttribute {

    /**
     * Get status code.
     *
     * @return code
     */
    String getCode();

    /**
     * Set status code.
     *
     * @param code code
     * @return Status Attribute
     */
    StatusAttribute setCode(String code);

    /**
     * Get status messages.
     *
     * @return message
     */
    String[] getMessages();

    /**
     * Set status messages.
     *
     * @param messages messages
     * @return Status Attribute
     */
    StatusAttribute setMessages(String... messages);

    /**
     * Get error messages.
     *
     * @return error messages
     */
    ErrorMessage[] getErrorMessages();

    /**
     * Set error messages.
     *
     * @param messages msgs
     * @return Statue Attribute
     */
    StatusAttribute setErrorMessages(ErrorMessage... messages);
}
