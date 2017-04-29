package com.igitras.cbframework;

import com.igitras.cbframework.exception.CustomBootException;

import org.springframework.core.Ordered;

/**
 * Custom boot exception translator. Translate the given exception to Custom Boot Exception.
 *
 * @param <T> target exception
 * @param <O> origin exception
 * @author mason
 */
public interface CustomBootExceptionTranslator<O extends Exception, T extends CustomBootException> extends Ordered {

    /**
     * Checking support or not.
     *
     * @param exception exception
     * @return support or not.
     */
    boolean support(Exception exception);

    /**
     * Translate the given exception to custom boot exception.
     *
     * @param exception exception.
     * @return custom boot exception
     */
    T translate(O exception);
}
