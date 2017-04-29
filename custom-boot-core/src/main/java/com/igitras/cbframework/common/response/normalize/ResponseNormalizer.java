package com.igitras.cbframework.common.response.normalize;


import com.igitras.cbframework.common.NormalizedFactory;
import com.igitras.cbframework.common.Normalizer;
import com.igitras.cbframework.common.response.NormalizedResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * Normalize the buildResponse to the given type.
 *
 * @author mason
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ResponseNormalizer<N extends NormalizedResp> implements ResponseBodyAdvice<Object> {

    private final List<Normalizer<N>> normalizers;

    @Autowired
    private NormalizedFactory<N> factory;

    @Autowired(required = false)
    public ResponseNormalizer(List<Normalizer<N>> normalizers) {
        this.normalizers = normalizers;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // normalize all
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {

        N result = factory.create(body);
        for (Normalizer<N> normalizer : normalizers) {
            if (normalizer.support(result)) {
                normalizer.normalize(result);
            }
        }

        return result;
    }
}
