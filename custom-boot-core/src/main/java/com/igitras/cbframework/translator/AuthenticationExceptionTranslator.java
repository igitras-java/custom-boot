package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.access.auth.AuthenticationFailedException;

import org.springframework.security.core.AuthenticationException;

/**
 * Class {@link AuthenticationExceptionTranslator}.
 *
 * @author mason
 */
public class AuthenticationExceptionTranslator
        implements CustomBootExceptionTranslator<AuthenticationException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof AuthenticationException;
    }

    @Override
    public CustomBootException translate(AuthenticationException exception) {
        return new AuthenticationFailedException(exception.getMessage());
    }
}
