package com.igitras.cbframework.translator;

import static org.springframework.util.StringUtils.arrayToCommaDelimitedString;
import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ResolvableArgument;
import com.igitras.cbframework.exception.request.BadRequestException;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.ServletException;

/**
 * Class {@link ServletExceptionTranslator}.
 *
 * @author mason
 */
public class ServletExceptionTranslator
        implements CustomBootExceptionTranslator<ServletException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof ServletException;
    }

    @Override
    public CustomBootException translate(ServletException exception) {
        // TODO:
        if (exception instanceof NoSuchRequestHandlingMethodException) {
            return handle((NoSuchRequestHandlingMethodException) exception);
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            return handle((HttpRequestMethodNotSupportedException) exception);
        } else if (exception instanceof HttpMediaTypeNotSupportedException) {
            return handle((HttpMediaTypeNotSupportedException) exception);
        } else if (exception instanceof HttpMediaTypeNotAcceptableException) {
            return handle((HttpMediaTypeNotAcceptableException) exception);
        } else if (exception instanceof MissingPathVariableException) {
            return handle((MissingPathVariableException) exception);
        } else if (exception instanceof MissingServletRequestParameterException) {
            return handle((MissingServletRequestParameterException) exception);
        } else if (exception instanceof ServletRequestBindingException) {
            return handle((ServletRequestBindingException) exception);
        } else if (exception instanceof NoHandlerFoundException) {
            return handle((NoHandlerFoundException) exception);
        } else if (exception instanceof MissingServletRequestPartException) {
            return handle((MissingServletRequestPartException) exception);
        }
        return handle(exception);
    }

    private CustomBootException handle(ServletException exception) {
        return new BadRequestException(exception.getRootCause()
                .getMessage());
    }

    private CustomBootException handle(MissingServletRequestPartException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getRequestPartName()));
    }

    private CustomBootException handle(NoHandlerFoundException exception) {
        return new BadRequestException(
                new ResolvableArgument(exception).addArguments(exception.getHttpMethod(), exception.getRequestURL()));
    }

    private CustomBootException handle(ServletRequestBindingException exception) {
        return new BadRequestException(new ResolvableArgument(exception));
    }

    private CustomBootException handle(MissingServletRequestParameterException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getParameterType(),
                exception.getParameterName()));
    }

    private CustomBootException handle(MissingPathVariableException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getVariableName()));
    }

    private CustomBootException handle(HttpMediaTypeNotAcceptableException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(
                collectionToCommaDelimitedString(exception.getSupportedMediaTypes())));
    }

    private CustomBootException handle(HttpMediaTypeNotSupportedException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getContentType(),
                collectionToCommaDelimitedString(exception.getSupportedMediaTypes())));
    }

    private CustomBootException handle(HttpRequestMethodNotSupportedException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getMethod(),
                arrayToCommaDelimitedString(exception.getSupportedMethods())));
    }

    private CustomBootException handle(NoSuchRequestHandlingMethodException exception) {
        return new BadRequestException(new ResolvableArgument(exception).addArguments(exception.getMethodName()));
    }
}
