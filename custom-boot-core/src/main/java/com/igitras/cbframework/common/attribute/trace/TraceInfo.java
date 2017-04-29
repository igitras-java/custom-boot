package com.igitras.cbframework.common.attribute.trace;

/**
 * Trace Information.
 *
 * @author mason
 */
public class TraceInfo implements TraceAttribute {

    private static final long serialVersionUID = 4875185515443532210L;

    private String id;

    private Long span;

    private Long timestamp;

    private TraceNode provider = new TraceNodeIml();

    private TraceNode consumer = new TraceNodeIml();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public TraceInfo setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public Long getSpan() {
        return span;
    }

    @Override
    public TraceInfo setSpan(Long span) {
        this.span = span;
        return this;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public TraceInfo setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TraceNode getProvider() {
        return provider;
    }

    public TraceInfo setProvider(TraceNode provider) {
        this.provider = provider;
        return this;
    }

    public TraceNode getConsumer() {
        return consumer;
    }

    @Override
    public TraceInfo setConsumer(TraceNode consumer) {
        this.consumer = consumer;
        return this;
    }


    /**
     * Provider of the request. Usually is the server.
     */
    public static class TraceNodeIml implements TraceNode {

        private String id;
        private String host;
        private String ip;

        @Override
        public String getId() {
            return id;
        }

        public TraceNode setId(String id) {
            this.id = id;
            return this;
        }

        @Override
        public String getHost() {
            return host;
        }

        public TraceNode setHost(String host) {
            this.host = host;
            return this;
        }

        @Override
        public String getIp() {
            return ip;
        }

        public TraceNode setIp(String ip) {
            this.ip = ip;
            return this;
        }
    }
}
