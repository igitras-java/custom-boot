package com.igitras.cbframework.common.attribute.trace;

/**
 * Class {@link TraceAttributeHolder}.
 *
 * @author mason
 */
public interface TraceAttributeHolder {

    TraceAttribute getTrace();

    TraceAttributeHolder setTrace(TraceAttribute trace);
}
