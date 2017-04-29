package com.igitras.cbframework.exception;

/**
 * Class {@link HierarchyMaintainer}.
 *
 * @author mason
 */
public interface HierarchyMaintainer<T> {

    /**
     * Add details error message.
     *
     * @param details error message details
     * @return Maintainer
     */
    HierarchyMaintainer addDetails(T... details);
}
