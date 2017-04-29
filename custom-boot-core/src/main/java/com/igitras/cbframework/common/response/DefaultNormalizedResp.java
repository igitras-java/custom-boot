package com.igitras.cbframework.common.response;

import com.igitras.cbframework.ContentHolder;
import com.igitras.cbframework.common.attribute.status.Status;
import com.igitras.cbframework.common.attribute.status.StatusAttribute;
import com.igitras.cbframework.common.attribute.status.StatusAttributeHolder;
import com.igitras.cbframework.common.attribute.trace.TraceAttribute;
import com.igitras.cbframework.common.attribute.trace.TraceAttributeHolder;
import com.igitras.cbframework.common.attribute.trace.TraceInfo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Class {@link DefaultNormalizedResp}.
 *
 * @author mason
 */
public class DefaultNormalizedResp<T>
        implements NormalizedResp, ContentHolder<T>, TraceAttributeHolder, StatusAttributeHolder {

    private static final long serialVersionUID = -5238758400364254759L;
    @JsonDeserialize(as = TraceInfo.class)
    private TraceAttribute trace;
    @JsonDeserialize(as = Status.class)
    private StatusAttribute status;
    private T data;

    @Override
    public T getData() {
        return data;
    }

    public DefaultNormalizedResp setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public StatusAttribute getStatus() {
        return status;
    }

    @Override
    public DefaultNormalizedResp setStatus(StatusAttribute status) {
        this.status = status;
        return this;
    }

    @Override
    public TraceAttribute getTrace() {
        return trace;
    }

    @Override
    public DefaultNormalizedResp setTrace(TraceAttribute trace) {
        this.trace = trace;
        return this;
    }
}
