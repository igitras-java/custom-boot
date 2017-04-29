package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.internal.InternalException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

/**
 * Class {@link AsyncRequestTimeoutExceptionTranslator}.
 *
 * @author mason
 */
public class AsyncRequestTimeoutExceptionTranslator
        implements CustomBootExceptionTranslator<AsyncRequestTimeoutException, CustomBootException> {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncRequestTimeoutExceptionTranslator.class);

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof AsyncRequestTimeoutException;
    }

    @Override
    public CustomBootException translate(AsyncRequestTimeoutException exception) {
        return handle(exception);
    }

    private CustomBootException handle(AsyncRequestTimeoutException exception) {
        LOG.debug("Handle async request timeout exception. Exception: {}", exception);
        return new InternalException(exception.getClass()
                .getName());
    }
}
