package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.access.AuthorizationFailedException;
import org.springframework.security.access.AccessDeniedException;

/**
 * Class {@link AccessDeniedExceptionTranslator}. Translate the access denied exception to
 * {@link AuthorizationFailedException}.
 *
 * @author mason
 */
public class AccessDeniedExceptionTranslator
        implements CustomBootExceptionTranslator<AccessDeniedException, CustomBootException> {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public CustomBootException translate(AccessDeniedException exception) {
        return new AuthorizationFailedException(exception.getMessage());
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof AccessDeniedException;
    }
}
