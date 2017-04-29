package com.igitras.cbframework.common.response.normalizer;

import static org.springframework.util.StringUtils.concatenateStringArrays;

import com.igitras.cbframework.common.Normalizer;
import com.igitras.cbframework.common.attribute.status.StatusAttribute;
import com.igitras.cbframework.common.response.DefaultNormalizedResp;
import com.igitras.cbframework.common.response.normalize.LocalizableResolver;
import com.igitras.cbframework.utils.AttributesUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Class {@link StatusAttributeNormalizer}.
 *
 * @author mason
 */
public class StatusAttributeNormalizer extends LocalizableResolver implements Normalizer<DefaultNormalizedResp> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Object target) {
        return target != null && target instanceof DefaultNormalizedResp;
    }

    @Override
    public void normalize(DefaultNormalizedResp origin) {
        Assert.notNull(origin, "Origin normalized response must not be null.");
        StatusAttribute status = AttributesUtils.status();
        String[] msgs = Arrays.stream(status.getErrorMessages())
                .map(errorMessage -> resolveMessage(errorMessage, LocaleContextHolder.getLocale()))
                .collect(Collectors.toList())
                .toArray(new String[status.getErrorMessages().length]);
        status.setMessages(concatenateStringArrays(status.getMessages(), msgs));
    }
}
