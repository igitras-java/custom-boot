package com.igitras.cbframework.common;

import org.springframework.core.Ordered;

/**
 * Class {@link Normalizer}.
 *
 * @author mason
 */
public interface Normalizer<T> extends Ordered {

    /**
     * Construct the normalized result obj.
     *
     * @param origin origin normalized obj
     */
    void normalize(T origin);

    /**
     * Check if the current normalized support this or not.
     *
     * @param target target
     * @return support or not
     */
    boolean support(Object target);
}
