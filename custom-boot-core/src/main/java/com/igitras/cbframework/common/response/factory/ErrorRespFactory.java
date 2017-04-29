package com.igitras.cbframework.common.response.factory;

import com.igitras.cbframework.ErrorDescriptor;
import com.igitras.cbframework.ErrorDescriptorFactory;
import com.igitras.cbframework.common.NormalizedFactory;
import com.igitras.cbframework.common.response.DefaultErrorResp;
import com.igitras.cbframework.common.response.ErrorResp;
import com.igitras.cbframework.common.response.normalize.LocalizableResolver;
import com.igitras.cbframework.exception.CustomBootException;
import com.igitras.cbframework.exception.ErrorMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Class {@link ErrorRespFactory}.
 *
 * @author mason
 */
public class ErrorRespFactory extends LocalizableResolver implements NormalizedFactory<ErrorResp> {

    @Autowired
    private ErrorDescriptorFactory descriptorFactory;

    @Override
    public ErrorResp create(Object context) {
        Assert.state(context instanceof CustomBootException, "Context must be a CustomBootException");
        return create((CustomBootException) context);
    }

    protected ErrorResp create(CustomBootException exception) {
        // The Error Descriptor from config
        ErrorDescriptor descriptor = descriptorFactory.getDescriptor(exception);
        return buildError(exception, descriptor);
    }

    protected DefaultErrorResp errorInstance() {
        return new DefaultErrorResp();
    }

    private ErrorResp buildError(ErrorMessage errorMessage, ErrorDescriptor descriptor) {
        DefaultErrorResp defaultError = errorInstance();
        final Locale locale = LocaleContextHolder.getLocale();
        if (descriptor != null) {
            defaultError.setCode(descriptor.getCode())
                    .setLink(descriptor.getLink());
        } else {
            String code = "No code";
            String[] codes = errorMessage.getCodes();
            if (codes != null && codes.length >= 1) {
                code = codes[0];
            }
            defaultError.setCode(code)
                    .setLink("No link");
        }
        String message = resolveMessage(errorMessage, locale);
        defaultError.setMessage(message);
        if (!CollectionUtils.isEmpty(errorMessage.getDetails())) {
            defaultError.setErrors(errorMessage.getDetails()
                    .stream()
                    .map(this::handle)
                    .collect(Collectors.toList()));
        }
        return defaultError;
    }

    private ErrorResp handle(ErrorMessage error) {
        if (error instanceof CustomBootException) {
            return create((CustomBootException) error);
        }        // The Error Descriptor from config
        ErrorDescriptor descriptor = descriptorFactory.getDescriptor(error.getCodes());
        return buildError(error, descriptor);
    }
}
