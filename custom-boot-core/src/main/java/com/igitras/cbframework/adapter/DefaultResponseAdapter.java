package com.igitras.cbframework.adapter;


import static java.util.Collections.emptyList;

import com.igitras.cbframework.common.NormalizedFactory;
import com.igitras.cbframework.common.Normalizer;
import com.igitras.cbframework.common.response.ErrorResp;
import com.igitras.cbframework.exception.CustomBootException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Class {@link DefaultResponseAdapter}.
 *
 * @param <E> Error type
 * @author mason
 */
public class DefaultResponseAdapter<E extends ErrorResp> extends AbstractResponseAdapter<E> {

    @Autowired(required = false)
    private List<Normalizer<E>> normalizers;

    @Autowired
    private NormalizedFactory<E> normalizedFactory;

    @Override
    protected MultiValueMap<String, String> buildHeaders(CustomBootException exception) {
        Assert.notNull(exception, "Exception must not be null.");
        return null;
    }

    @Override
    protected List<Normalizer<E>> normalizers() {
        if (CollectionUtils.isEmpty(this.normalizers)) {
            return emptyList();
        }
        return this.normalizers;
    }

    @Override
    protected NormalizedFactory<E> normalizedFactory() {
        return this.normalizedFactory;
    }
}
