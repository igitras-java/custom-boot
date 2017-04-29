package com.igitras.cbframework;

/**
 * Error Descriptor provider.
 *
 * @author mason
 */
public interface ErrorDescriptorFactory {

    /**
     * Get the error Descriptor with given codes.
     *
     * @param codes codes
     * @return Codes related error descriptor
     */
    ErrorDescriptor getDescriptor(String... codes);

    /**
     * Get the error Descriptor with a given exception.
     *
     * @param exception exception
     * @return Exception related error descriptor
     */
    ErrorDescriptor getDescriptor(Exception exception);
}
