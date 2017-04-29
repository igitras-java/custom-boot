package com.igitras.cbframework;

/**
 * Error Descriptor.
 *
 * @author mason
 */
public interface ErrorDescriptor {

    /**
     * Get the error code name.
     *
     * @return error code name
     */
    String getCode();

    /**
     * Get the error code link.
     *
     * @return error code link
     */
    String getLink();

    /**
     * Get the error code represent description.
     *
     * @return error code description
     */
    String getDescription();
}