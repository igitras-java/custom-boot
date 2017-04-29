package com.igitras.cbframework.common.attribute;

/**
 * Custom boot request attributes.
 *
 * @author mason
 * @since 2.0.0
 */
public interface CustomBootRequestAttributes {

    /**
     * Get an pre-set attribute.
     *
     * @param name key
     * @param <T>  attribute type
     * @return pre-set attribute
     */
    <T> T getAttribute(String name);

    /**
     * Set an attribute to the context with given key.
     *
     * @param name      context key
     * @param attribute attribute
     * @param <T>       attribute type
     */
    <T> void setAttribute(String name, T attribute);

    /**
     * Checking if the attribute exists.
     *
     * @param name attribute name
     */
    boolean hasAttribute(String name);

    /**
     * Get all the attribute keys.
     *
     * @return attribute keys.
     */
    String[] getAttributes();
}
