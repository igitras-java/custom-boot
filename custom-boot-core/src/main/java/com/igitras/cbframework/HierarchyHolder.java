package com.igitras.cbframework;

import java.util.List;

/**
 * Class {@link HierarchyHolder}.
 *
 * @author mason
 */
public interface HierarchyHolder<T> {

    /**
     * Get the details layer hierarchies.
     *
     * @return details
     */
    List<T> getDetails();
}
