package com.igitras.cbframework;

import com.igitras.cbframework.common.response.ErrorResp;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.internal.InternalException;
import com.igitras.cbframework.exception.uncatalog.UncatalogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * Class {@link CustomBootExceptionHandler}. Building response entity with exception.
 *
 * @author mason
 */
@ControllerAdvice
public class CustomBootExceptionHandler<E extends ErrorResp> extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CustomBootExceptionHandler.class);

    @Autowired
    private CustomBootExceptionResponseAdapter<E> exceptionResponseAdapter;

    @Autowired
    private List<CustomBootExceptionTranslator> translators;

    @Override
    protected ResponseEntity handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        return this.translators.stream()
                .filter(translator -> translator.support(ex))
                .findFirst()
                .map(translator -> translator.translate(ex))
                .map(e -> exceptionResponseAdapter.adapt(e, status))
                .orElseGet(() -> {
                    LOG.debug("Found not translatable exception {}, should never come to here.", ex.getClass());
                    UncatalogException exception = new UncatalogException(ex);
                    return exceptionResponseAdapter.adapt(exception, status);
                });
    }

    /**
     * Handle all the category custom boot exception.
     *
     * @param exception custom boot exception
     * @return error response entity
     */
    @ExceptionHandler(CustomBootException.class)
    public ResponseEntity handleSystemException(CustomBootException exception) {
        LOG.warn("CustomBootException {} has been handled. Message: {}", exception.getClass(), exception.getMessage());
        LOG.debug("CustomBootException {} has been handled: {}", exception.getClass(), exception);
        return exceptionResponseAdapter.adapt(exception);
    }

    /**
     * Handle All the exceptions to Server Error. Will try to translate all the exceptions to a
     * {@link CustomBootException}. If not translator exists, using {@link InternalException} by default.
     *
     * @param exception un-category exception.
     * @return Response Entity.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        LOG.warn("Exception {} has been handled. Message: {}", exception.getClass(), exception.getMessage());
        LOG.debug("Exception {} has been handled: {}", exception.getClass(), exception);
        return this.translators.stream()
                .filter(translator -> translator.support(exception))
                .findFirst()
                .map(translator -> translator.translate(exception))
                .map(e -> exceptionResponseAdapter.adapt(e))
                .orElseGet(() -> {
                    LOG.debug("No translator found for exception {}, should never come to here.", exception.getClass());
                    InternalException internalException = new InternalException();
                    return exceptionResponseAdapter.adapt(internalException);
                });
    }
}
