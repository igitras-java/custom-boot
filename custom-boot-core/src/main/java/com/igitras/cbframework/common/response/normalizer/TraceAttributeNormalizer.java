package com.igitras.cbframework.common.response.normalizer;

import static com.igitras.cbframework.utils.AttributesUtils.trace;
import static com.igitras.cbframework.utils.LocalInfoProvider.getLocalHostname;
import static com.igitras.cbframework.utils.LocalInfoProvider.getLocalIpAddress;

import com.igitras.cbframework.common.Normalizer;
import com.igitras.cbframework.common.attribute.trace.TraceAttribute;
import com.igitras.cbframework.common.attribute.trace.TraceInfo;
import com.igitras.cbframework.common.attribute.trace.TraceNode;
import com.igitras.cbframework.common.response.DefaultNormalizedResp;

import org.springframework.util.Assert;

/**
 * Class {@link TraceAttributeNormalizer}.
 *
 * @author mason
 */
public class TraceAttributeNormalizer implements Normalizer<DefaultNormalizedResp> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void normalize(DefaultNormalizedResp origin) {
        Assert.notNull(origin, "Origin normalized response must not be null.");
        TraceAttribute trace = trace();
        TraceNode provider = trace.getProvider();
        if (provider instanceof TraceInfo.TraceNodeIml) {
            TraceInfo.TraceNodeIml node = ((TraceInfo.TraceNodeIml) provider);
            node.setIp(getLocalIpAddress());
            node.setHost(getLocalHostname());
            // TODO: local instance id is not support yet.
        }
        origin.setTrace(trace);
    }

    @Override
    public boolean support(Object target) {
        return target != null && target instanceof DefaultNormalizedResp;
    }
}
