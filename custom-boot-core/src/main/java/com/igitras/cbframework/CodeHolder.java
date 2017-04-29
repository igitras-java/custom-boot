package com.igitras.cbframework;

/**
 * Class {@link CodeHolder}.
 *
 * @author mason
 */
public interface CodeHolder {

    /**
     * Get codes. A code represent for a message.
     *
     * @return codes
     */
    String[] getCodes();

    /**
     * Get the default message.
     *
     * @return default message
     */
    String getDefaultMessage();
}
