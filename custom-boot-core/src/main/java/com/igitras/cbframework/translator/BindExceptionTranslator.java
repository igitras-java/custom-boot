package com.igitras.cbframework.translator;

import static com.igitras.cbframework.exception.ErrorMessageBuilder.builder;

import com.igitras.cbframework.CustomBootExceptionTranslator;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;
import com.igitras.cbframework.exception.param.value.ParameterValueException;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

/**
 * Class {@link BindExceptionTranslator}.
 *
 * @author mason
 */
public class BindExceptionTranslator implements CustomBootExceptionTranslator<BindException, CustomBootException> {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(Exception exception) {
        return exception instanceof BindException;
    }

    @Override
    public CustomBootException translate(BindException exception) {
        return handle(exception);
    }

    private ErrorMessage build(FieldError error) {
        return builder().setDefaultMessage(error.getDefaultMessage())
                .addCodes(error.getCodes())
                .addArguments(error.getArguments())
                .build();
    }

    private CustomBootException handle(BindException exception) {
        ErrorMessage error = builder().addArguments(exception.getBindingResult()
                .getObjectName())
                .addDetails(exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(this::build)
                        .collect(Collectors.toList())
                        .toArray(new ErrorMessage[0]))
                .build();
        return new ParameterValueException("Validation failed.", error);
    }
}
