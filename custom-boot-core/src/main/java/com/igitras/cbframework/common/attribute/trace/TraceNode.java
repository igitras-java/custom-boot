package com.igitras.cbframework.common.attribute.trace;/**
 * Class {@link TraceNode}.
 *
 * @author mason
 */

import com.igitras.cbframework.common.attribute.RequestAttribute;

/**
 * Provider, usually is the server or client.
 */
public interface TraceNode extends RequestAttribute {

    /**
     * Get the node host name.
     *
     * @return host name
     */
    String getHost();

    /**
     * Get the node id or name.
     *
     * @return node identity
     */
    String getId();

    /**
     * Get the node inet address.
     *
     * @return inet address
     */
    String getIp();
}