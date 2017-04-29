package com.igitras.cbframework;

import org.springframework.http.HttpStatus;

/**
 * Class {@link StatusHolder}. Http status holder, holding the http status.
 *
 * @author mason
 */
public interface StatusHolder {

    /**
     * Return the http status.
     *
     * @return http status
     */
    HttpStatus getStatus();
}
