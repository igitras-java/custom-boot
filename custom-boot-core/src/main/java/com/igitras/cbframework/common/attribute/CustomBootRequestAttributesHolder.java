package com.igitras.cbframework.common.attribute;

import org.springframework.core.NamedInheritableThreadLocal;

/**
 * Request context holder for all the custom boot related information. Created by the request generated and destroyed
 * while the request finished.
 *
 * @author mason
 * @since 2.0.0
 */
public abstract class CustomBootRequestAttributesHolder {

    private static final ThreadLocal<CustomBootRequestAttributes> requestContext =
            new NamedInheritableThreadLocal<>("Custom boot Request context");

    /**
     * Reset the RequestAttributes for the current thread.
     */
    public static void resetRequestContext() {
        requestContext.remove();
    }

    /**
     * Bind the given RequestAttributes to the current thread.
     *
     * @param attributes the CustomBootRequestAttributes to expose,
     *                   or {@code null} to reset the thread-bound context
     */
    public static void setRequestContext(CustomBootRequestAttributes attributes) {
        if (attributes == null) {
            resetRequestContext();
        } else {
            requestContext.set(attributes);
        }
    }

    /**
     * Return the CustomBootRequestAttributes currently bound to the thread.
     * <p>Exposes the previously bound CustomBootRequestAttributes instance, if any.
     *
     * @return the CustomBootRequestAttributes currently bound to the thread
     */
    public static CustomBootRequestAttributes currentRequestContext() {
        return requestContext.get();
    }

}
