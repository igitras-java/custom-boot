package com.igitras.cbframework.exception.uncatalog;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.igitras.cbframework.exception.CustomBootException;
import org.springframework.http.HttpStatus;

/**
 * Class {@link UncatalogException}. Uncatalog Exception will be report as Message class name and error message only.
 *
 * @author mason
 */
public class UncatalogException extends CustomBootException {

    private static final long serialVersionUID = 1781921128672028651L;

    private final Exception origin;

    public UncatalogException(Exception ex) {
        super(ex.getMessage(), builder().addArguments(ex.getClass(), ex.getMessage()).build());
        this.origin = ex;
    }

    @Override
    public HttpStatus getStatus() {
        return INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getMessage() {
        return String.format("Found uncatalog exception [%s], message: [%s]",
                origin.getClass().getName(), origin.getMessage());
    }
}
