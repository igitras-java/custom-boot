package com.igitras.cbframework.translator;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ResolvableArgument;
import com.igitras.cbframework.exception.param.value.ParameterValueException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Class {@link TypeMismatchExceptionTranslator}.
 *
 * @author mason
 */
public class TypeMismatchExceptionTranslator
        implements CustomBootExceptionTranslator<TypeMismatchException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof TypeMismatchException;
    }

    @Override
    public CustomBootException translate(TypeMismatchException exception) {
        if (exception instanceof MethodArgumentConversionNotSupportedException) {
            return handle((MethodArgumentConversionNotSupportedException) exception);
        } else if (exception instanceof ConversionNotSupportedException) {
            return handle((ConversionNotSupportedException) exception);
        } else if (exception instanceof MethodArgumentTypeMismatchException) {
            return handle((MethodArgumentTypeMismatchException) exception);
        } else {
            return handle(exception);
        }
    }

    private CustomBootException handle(TypeMismatchException exception) {
        return new ParameterValueException(new ResolvableArgument(exception).addArguments(exception.getRequiredType()));
    }

    private CustomBootException handle(MethodArgumentTypeMismatchException exception) {
        return new ParameterValueException(
                new ResolvableArgument(exception).addArguments(exception.getName(), exception.getRequiredType()));
    }

    private CustomBootException handle(ConversionNotSupportedException exception) {
        return new ParameterValueException(new ResolvableArgument(exception).addArguments(exception.getPropertyName(),
                exception.getRequiredType()));
    }

    private CustomBootException handle(MethodArgumentConversionNotSupportedException exception) {
        return new ParameterValueException(
                new ResolvableArgument(exception).addArguments(exception.getName(), exception.getRequiredType()));
    }
}
