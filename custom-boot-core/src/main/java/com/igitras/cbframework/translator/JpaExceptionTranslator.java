package com.igitras.cbframework.translator;


import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.param.value.ParameterValueException;
import com.igitras.cbframework.exception.uncatalog.UncatalogException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Data Access Exception Translator.
 *
 * @author mason
 */
public class JpaExceptionTranslator
        implements CustomBootExceptionTranslator<DataAccessException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof DataAccessException;
    }

    @Override
    public CustomBootException translate(DataAccessException exception) {
        if (exception instanceof DataIntegrityViolationException) {
            return handleDataIntegrityViolationException((DataIntegrityViolationException) exception);
        }

        if (exception instanceof EmptyResultDataAccessException) {
            return handleEmptyResultDataAccessException((EmptyResultDataAccessException) exception);
        }

        return handleDataAccessException(exception);
    }

    private CustomBootException handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return new ParameterValueException(exception.getRootCause().getMessage());
    }

    private CustomBootException handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return new ParameterValueException(exception.getMessage());
    }

    private CustomBootException handleDataAccessException(DataAccessException exception) {
        return new UncatalogException(exception);
    }
}
