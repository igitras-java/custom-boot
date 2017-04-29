package com.igitras.cbframework.adapter;


import com.igitras.cbframework.CustomBootExceptionResponseAdapter;
import com.igitras.cbframework.common.NormalizedFactory;
import com.igitras.cbframework.common.Normalizer;
import com.igitras.cbframework.common.response.ErrorResp;
import com.igitras.cbframework.exception.CustomBootException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Class {@link AbstractResponseAdapter}. Adapt the {@link CustomBootException} to response entity.
 *
 * @author mason
 */
public abstract class AbstractResponseAdapter<E extends ErrorResp>
        implements CustomBootExceptionResponseAdapter<E> {

    @Override
    public ResponseEntity<E> adapt(CustomBootException exception) {
        return adapt(exception, exception.getStatus());
    }

    @Override
    public ResponseEntity<E> adapt(CustomBootException exception, HttpStatus status) {
        E normalizedError = normalizedFactory().create(exception);
        for (Normalizer<E> normalizer : normalizers()) {
            if (normalizer.support(normalizedError)) {
                normalizer.normalize(normalizedError);
            }
        }

        MultiValueMap<String, String> headers = buildHeaders(exception);
        return new ResponseEntity<>(normalizedError, headers, status);
    }

    protected abstract List<Normalizer<E>> normalizers();

    protected abstract NormalizedFactory<E> normalizedFactory();

    /**
     * Build headers with exception. Subclass can override this to implement custom logical.
     *
     * @param exception exception
     * @return header map.
     */
    protected abstract MultiValueMap<String, String> buildHeaders(CustomBootException exception);

}
