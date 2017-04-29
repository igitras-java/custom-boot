package com.igitras.cbframework.common.attribute.trace;

import com.igitras.cbframework.common.attribute.RequestAttributeReader;

import javax.servlet.http.HttpServletRequest;

/**
 * Class {@link TraceNodeReader}.
 *
 * @author mason
 */
public class TraceNodeReader implements RequestAttributeReader<TraceNode> {

    private static final String TRACE_CONSUMER_ID_HEADER_NAME = "X-Trace-Consumer-Id";
    private static final String TRACE_CONSUMER_HOST_HEADER_NAME = "X-Trace-Consumer-Host";
    private static final String TRACE_CONSUMER_IP_HEADER_NAME = "X-Trace-Consumer-Ip";
    private static final String TRACE_PROVIDER_ID_HEADER_NAME = "X-Trace-Provider-Id";
    private static final String TRACE_PROVIDER_HOST_HEADER_NAME = "X-Trace-Provider-Host";
    private static final String TRACE_PROVIDER_IP_HEADER_NAME = "X-Trace-Provider-Ip";
    private String hnId;
    private String hnHost;
    private String hnIp;

    /**
     * Create a provider trace node reader or consumer trace node reader.
     *
     * @param consumer consumer flag
     */
    public TraceNodeReader(boolean consumer) {
        if (consumer) {
            this.hnId = TRACE_CONSUMER_ID_HEADER_NAME;
            this.hnHost = TRACE_CONSUMER_HOST_HEADER_NAME;
            this.hnIp = TRACE_CONSUMER_IP_HEADER_NAME;
        } else {
            this.hnId = TRACE_PROVIDER_ID_HEADER_NAME;
            this.hnHost = TRACE_PROVIDER_HOST_HEADER_NAME;
            this.hnIp = TRACE_PROVIDER_IP_HEADER_NAME;
        }
    }

    @Override
    public TraceNode read(HttpServletRequest request) {
        return readNode(request);
    }

    @Override
    public boolean support(Class clazz) {
        return TraceNode.class.isAssignableFrom(clazz);
    }

    public TraceNodeReader setHnHost(String hnHost) {
        this.hnHost = hnHost;
        return this;
    }

    public TraceNodeReader setHnId(String hnId) {
        this.hnId = hnId;
        return this;
    }

    public TraceNodeReader setHnIp(String hnIp) {
        this.hnIp = hnIp;
        return this;
    }

    private TraceNode readNode(HttpServletRequest request) {
        TraceInfo.TraceNodeIml node = new TraceInfo.TraceNodeIml();
        node.setId(readString(hnId, request));
        node.setHost(readString(hnHost, request));
        node.setIp(readString(hnIp, request));
        return node;
    }
}
