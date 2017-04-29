package com.igitras.cbframework.common.attribute.trace;

import javax.servlet.http.HttpServletRequest;

/**
 * Class {@link TraceInfoReader}.
 *
 * @author mason
 */
public class TraceInfoReader extends TraceAttributeReader<TraceInfo> {

    private static final String TRACE_ID_HEADER_NAME = "X-Trace-Id";
    private static final String TRACE_SPAN_HEADER_NAME = "X-Trace-Span";
    private static final String TRACE_TIMESTAMP_HEADER_NAME = "X-Trace-Timestamp";

    private String hnTraceId = TRACE_ID_HEADER_NAME;
    private String hnTraceSpan = TRACE_SPAN_HEADER_NAME;
    private String hnTraceTimestamp = TRACE_TIMESTAMP_HEADER_NAME;

    private TraceNodeReader consumerReader = new TraceNodeReader(true);
    private TraceNodeReader providerReader = new TraceNodeReader(false);

    public TraceInfoReader setHnTraceId(String hnTraceId) {
        this.hnTraceId = hnTraceId;
        return this;
    }

    public TraceInfoReader setHnTraceSpan(String hnTraceSpan) {
        this.hnTraceSpan = hnTraceSpan;
        return this;
    }

    public TraceInfoReader setHnTraceTimestamp(String hnTraceTimestamp) {
        this.hnTraceTimestamp = hnTraceTimestamp;
        return this;
    }

    public TraceInfoReader setConsumerReader(TraceNodeReader consumerReader) {
        this.consumerReader = consumerReader;
        return this;
    }

    public TraceInfoReader setProviderReader(TraceNodeReader providerReader) {
        this.providerReader = providerReader;
        return this;
    }

    @Override
    public TraceInfo read(HttpServletRequest request) {
        TraceInfo trace = traceInfo();

        String requestId = readString(hnTraceId, request);
        if (null != requestId) {
            trace.setId(requestId);
        }

        Long span = readLong(hnTraceSpan, request);
        if (null != span) {
            trace.setSpan(span);
        }

        Long timestamp = readLong(hnTraceTimestamp, request);
        if (timestamp != null) {
            trace.setTimestamp(timestamp);
        }

        trace.setConsumer(consumerReader.read(request));
        trace.setProvider(providerReader.read(request));

        return trace;
    }

    private TraceInfo traceInfo() {
        return preProcessAttribute(new TraceInfo());
    }
}
