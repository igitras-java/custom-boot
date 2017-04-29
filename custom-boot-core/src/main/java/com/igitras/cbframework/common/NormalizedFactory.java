package com.igitras.cbframework.common;

/**
 * Class {@link NormalizedFactory}.
 *
 * @author mason
 */
public interface NormalizedFactory<T> {

    /**
     * Create a new instance of given type.
     *
     * @param context context
     * @return new instance
     */
    T create(Object context);
}
