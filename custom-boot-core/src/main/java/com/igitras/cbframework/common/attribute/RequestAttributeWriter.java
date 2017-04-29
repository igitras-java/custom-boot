package com.igitras.cbframework.common.attribute;

import javax.servlet.http.HttpServletResponse;

/**
 * Class {@link RequestAttributeWriter}. One writer support only one type of attribute.
 *
 * @author mason
 */
public interface RequestAttributeWriter<T extends RequestAttribute> {

    /**
     * Determine and limit the supported attribute.
     *
     * @param clazz supported attribute type
     * @return support or not
     */
    boolean support(Class clazz);

    /**
     * Write the attribute to response.
     *
     * @param attribute attribute
     * @param response  response
     */
    void write(T attribute, HttpServletResponse response);
}
