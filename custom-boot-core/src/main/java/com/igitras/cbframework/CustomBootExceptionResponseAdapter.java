package com.igitras.cbframework;

import com.igitras.cbframework.common.response.ErrorResp;
import com.igitras.cbframework.exception.CustomBootException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Class {@link CustomBootExceptionResponseAdapter}.
 *
 * @author mason
 */
public interface CustomBootExceptionResponseAdapter<E extends ErrorResp> {

    /**
     * Adapter for exception to a response entity.
     *
     * @param exception custom boot exception
     * @return response entity
     */
    ResponseEntity<E> adapt(CustomBootException exception);

    /**
     * Adapter for exception to a response entity and status with given status.
     *
     * @param exception custom boot exception
     * @param status    status
     * @return response entity
     */
    ResponseEntity<E> adapt(CustomBootException exception, HttpStatus status);
}
