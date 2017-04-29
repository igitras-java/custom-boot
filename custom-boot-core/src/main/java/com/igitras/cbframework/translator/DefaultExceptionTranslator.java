package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.uncatalog.UncatalogException;

/**
 * Class {@link DefaultExceptionTranslator}.
 *
 * @author mason
 */
public class DefaultExceptionTranslator implements CustomBootExceptionTranslator<Exception, CustomBootException> {

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    /**
     * By default will process all the exceptions.
     *
     * @param exception exception
     * @return true
     */
    @Override
    public boolean support(Exception exception) {
        return true;
    }

    @Override
    public CustomBootException translate(Exception exception) {
        return new UncatalogException(exception);
    }
}
