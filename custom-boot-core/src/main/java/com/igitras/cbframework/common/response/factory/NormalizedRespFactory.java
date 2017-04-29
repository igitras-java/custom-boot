package com.igitras.cbframework.common.response.factory;

import com.igitras.cbframework.common.NormalizedFactory;
import com.igitras.cbframework.common.response.DefaultNormalizedResp;
import com.igitras.cbframework.common.response.NormalizedResp;
import com.igitras.cbframework.common.response.normalize.LocalizableResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class {@link NormalizedRespFactory}.
 *
 * @author mason
 */
public class NormalizedRespFactory extends LocalizableResolver implements NormalizedFactory<NormalizedResp> {
    private static final Logger LOG = LoggerFactory.getLogger(NormalizedRespFactory.class);

    @Override
    public NormalizedResp create(Object context) {
        DefaultNormalizedResp resp = newInstance();

        if (context == null || context instanceof Exception) {
            LOG.debug("generate error resp");
        } else {
            resp.setData(context);
        }

        return new DefaultNormalizedResp<>().setData(context);
    }

    protected DefaultNormalizedResp newInstance(){
        return new DefaultNormalizedResp<>();
    }
}
