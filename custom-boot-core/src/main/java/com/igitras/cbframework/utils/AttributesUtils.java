package com.igitras.cbframework.utils;


import static com.google.common.collect.ObjectArrays.concat;
import static com.igitras.cbframework.common.attribute.CustomBootRequestAttributesHolder.currentRequestContext;

import com.igitras.cbframework.common.attribute.AttributesFactory;
import com.igitras.cbframework.common.attribute.CustomBootRequestAttributes;
import com.igitras.cbframework.common.attribute.FallbackRequestAttributes;
import com.igitras.cbframework.common.attribute.status.StatusAttribute;
import com.igitras.cbframework.common.attribute.trace.TraceAttribute;
import com.igitras.cbframework.exception.ErrorMessage;


/**
 * Response information provider.
 *
 * @author mason
 */
public abstract class AttributesUtils {

    private static CustomBootRequestAttributes fallbackAttributes = new FallbackRequestAttributes();

    public static boolean hasAttribute(String name) {
        return requestContext().hasAttribute(name);
    }

    public static <T> void setAttribute(String name, T attribute) {
        requestContext().setAttribute(name, attribute);
    }

    /**
     * Get Trace Information of current request.
     *
     * @return trace info
     */
    public static TraceAttribute trace() {
        CustomBootRequestAttributes context = requestContext();
        String name = TraceAttribute.class.getName();
        TraceAttribute attribute = context.getAttribute(name);
        if (attribute == null) {
            attribute = AttributesFactory.trace();
            context.setAttribute(name, attribute);
        }

        return attribute;
    }

    /**
     * Get Status information of current request.
     *
     * @return status info
     */
    public static StatusAttribute status() {
        CustomBootRequestAttributes context = requestContext();
        String name = StatusAttribute.class.getName();
        StatusAttribute attribute = context.getAttribute(name);
        if (attribute == null) {
            attribute = AttributesFactory.status();
            context.setAttribute(name, attribute);
        }
        return attribute;
    }

    /**
     * Merge Status message and status catalog.
     *
     * @param status status info
     * @param trace  trace info
     */
    public static void mergeStatus(StatusAttribute status, TraceAttribute trace) {
        StatusAttribute statusAttribute = status();
        statusAttribute.setCode(status.getCode());
        String[] msg = statusAttribute.getMessages();
        String[] msgs = concat(status.getCode() + " errors occurred on " + trace.getProvider()
                .getIp(), status.getMessages());

        if (msg == null) {
            statusAttribute.setMessages(msgs);
        } else {
            statusAttribute.setMessages(concat(msg, msgs, String.class));
        }
    }

    /**
     * Merge Status message and status catalog.
     *
     * @param status status info
     */
    public static void mergeStatus(StatusAttribute status) {
        StatusAttribute statusAttribute = status();
        statusAttribute.setCode(status.getCode());
        String[] msg = statusAttribute.getMessages();
        String[] msgs = status.getMessages();
        ErrorMessage[] em = statusAttribute.getErrorMessages();
        ErrorMessage[] ems = status.getErrorMessages();

        if (msgs == null) {
            return;
        }

        if (msg == null) {
            statusAttribute.setMessages(msgs);
        } else {
            statusAttribute.setMessages(concat(msg, msgs, String.class));
        }

        if (em == null) {
            statusAttribute.setErrorMessages(ems);
        } else {
            statusAttribute.setErrorMessages(concat(em, ems, ErrorMessage.class));
        }
    }

    private static CustomBootRequestAttributes requestContext() {
        CustomBootRequestAttributes context = currentRequestContext();

        if (context == null) {
            return fallbackAttributes;
        }

        return context;
    }
}
