package com.igitras.cbframework.common.attribute.trace;


import com.igitras.cbframework.common.attribute.RequestAttributeReader;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.UUID;

/**
 * Class {@link TraceAttributeReader}.
 *
 * @author mason
 */
public abstract class TraceAttributeReader<T extends TraceAttribute> implements RequestAttributeReader<T> {

    @Override
    public boolean support(Class clazz) {
        return TraceAttribute.class.isAssignableFrom(clazz);
    }

    protected T preProcessAttribute(T attribute) {
        Assert.notNull(attribute, "Trace Attribute must not be null.");
        // @formatter:off
        attribute.setId(UUID.randomUUID().toString())
                .setTimestamp(Calendar.getInstance().getTimeInMillis())
                .setSpan(-1L);
        // @formatter:on
        return attribute;
    }

}
