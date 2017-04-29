package com.igitras.cbframework.common.attribute.trace;

import com.igitras.cbframework.common.attribute.RequestAttribute;

/**
 * Class {@link TraceAttribute}.
 *
 * @author mason
 */
public interface TraceAttribute extends RequestAttribute {

    /**
     * Get the trace attribute id.
     *
     * @return trace id
     */
    String getId();

    /**
     * Set the trace Id.
     *
     * @param id trace id
     * @return trace attribute
     */
    TraceAttribute setId(String id);

    /**
     * Get the trace span number.
     *
     * @return span number
     */
    Long getSpan();

    /**
     * Set the trace span number.
     *
     * @param span span number
     * @return trace attribute
     */
    TraceAttribute setSpan(Long span);

    /**
     * Get the trace start time.
     *
     * @return trace start time
     */
    Long getTimestamp();

    /**
     * Set the trace start timestamp
     *
     * @param timestamp trace start time
     * @return trace attribute
     */
    TraceAttribute setTimestamp(Long timestamp);

    /**
     * Get the trace provider, usually is the server.
     *
     * @return provider node
     */
    TraceNode getProvider();

    /**
     * Set the trace provider, usually is the server
     *
     * @param provider provider node
     * @return trace attribute
     */
    TraceAttribute setProvider(TraceNode provider);

    /**
     * Get the trace consumer, usually is the client.
     *
     * @return consumer node
     */
    TraceNode getConsumer();

    /**
     * Set the trace consumer, usually is the client
     *
     * @param consumer consumer node
     * @return trace attribute
     */
    TraceAttribute setConsumer(TraceNode consumer);

}
