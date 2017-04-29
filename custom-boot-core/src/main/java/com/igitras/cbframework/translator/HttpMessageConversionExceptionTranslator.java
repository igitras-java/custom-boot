package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.request.BadRequestException;

import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * Class {@link HttpMessageConversionExceptionTranslator}.
 *
 * @author mason
 */
public class HttpMessageConversionExceptionTranslator
        implements CustomBootExceptionTranslator<HttpMessageConversionException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof HttpMessageConversionException;
    }

    @Override
    public CustomBootException translate(HttpMessageConversionException exception) {
        if (exception instanceof HttpMessageNotReadableException) {
            return handle((HttpMessageNotReadableException) exception);
        } else if (exception instanceof HttpMessageNotWritableException) {
            return handle((HttpMessageNotWritableException) exception);
        }
        return handle(exception);
    }

    private CustomBootException handle(HttpMessageConversionException exception) {
        return new BadRequestException(exception.getMessage());
    }

    private CustomBootException handle(HttpMessageNotWritableException exception) {
        return new BadRequestException(exception.getClass()
                .getName());
    }

    private CustomBootException handle(HttpMessageNotReadableException exception) {
        return new BadRequestException(exception.getClass()
                .getName());
    }
}
