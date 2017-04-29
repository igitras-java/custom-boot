package com.igitras.cbframework.exception.access;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * Access denied while the client ip is in the black list.
 *
 * @author mason
 */
public class IpForbiddenException extends AccessDeniedException {

    private static final long serialVersionUID = -4039173989983607900L;

    public IpForbiddenException() {
        this("IP Forbidden");
    }

    public IpForbiddenException(String message) {
        // @formatter:off
        this(message, builder().build());
        // @formatter:on
    }

    public IpForbiddenException(String message, ErrorMessage error) {
        super(message, error);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.LOCKED;
    }
}
