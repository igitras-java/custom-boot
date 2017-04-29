package com.igitras.cbframework.common.attribute;

import com.igitras.cbframework.common.attribute.status.Status;
import com.igitras.cbframework.common.attribute.status.StatusAttribute;
import com.igitras.cbframework.common.attribute.trace.TraceAttribute;
import com.igitras.cbframework.common.attribute.trace.TraceInfo;

import java.util.Calendar;
import java.util.UUID;

/**
 * Class {@link AttributesFactory}.
 *
 * @author mason
 */
public abstract class AttributesFactory {

    /**
     * Build the initial version status attribute.
     *
     * @return status attribute
     */
    public static StatusAttribute status() {
        return new Status();
    }

    /**
     * Build the initial version trace attribute.
     *
     * @return trace attribute
     */
    public static TraceAttribute trace() {
        return new TraceInfo().setId(UUID.randomUUID()
                .toString())
                .setTimestamp(Calendar.getInstance()
                        .getTimeInMillis())
                .setSpan(-1L);
    }
}
