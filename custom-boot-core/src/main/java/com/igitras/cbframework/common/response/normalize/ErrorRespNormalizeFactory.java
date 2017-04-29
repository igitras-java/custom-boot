//package com.igitras.cbframework.common.response.normalize;
//
//
//import com.igitras.cbframework.ErrorDescriptor;
//import com.igitras.cbframework.common.response.DefaultErrorResp;
//import com.igitras.cbframework.common.response.ErrorResp;
//import com.igitras.cbframework.exception.CustomBootException;
//import com.igitras.cbframework.exception.ErrorMessage;
//import com.igitras.cbframework.CustomBootExceptionTranslator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * Class {@link ErrorRespNormalizeFactory}.
// *
// * @author mason
// */
//public class ErrorRespNormalizeFactory extends AbstractErrorNormalizeFactory<ErrorResp> {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ErrorRespNormalizeFactory.class);
//
//    @Autowired
//    private List<CustomBootExceptionTranslator> translators;
//
//    @Override
//    public List<CustomBootExceptionTranslator> getExceptionTranslators() {
//        return translators;
//    }
//
//    @Override
//    public ErrorResp error(CustomBootException exception) {
//
//        // The Error Descriptor from config
//        ErrorDescriptor descriptor = getErrorDescriptorProvider().getDescriptor(exception);
//
//        return buildError(exception, descriptor);
//    }
//
//    private ErrorResp handle(ErrorMessage error) {
//        if (error instanceof CustomBootException) {
//            return error((CustomBootException) error);
//        }
//
//        // The Error Descriptor from config
//        ErrorDescriptor descriptor = getErrorDescriptorProvider().getDescriptor(error.getCodes());
//
//        return buildError(error, descriptor);
//    }
//
//    private ErrorResp buildError(ErrorMessage errorMessage, ErrorDescriptor descriptor) {
//        DefaultErrorResp defaultError = new DefaultErrorResp();
//
//        final Locale locale = LocaleContextHolder.getLocale();
//
//        if (descriptor != null) {
//            defaultError.setCode(descriptor.getCode()).setLink(descriptor.getLink());
//        } else {
//            String code = "No code";
//            String[] codes = errorMessage.getCodes();
//            if (codes != null && codes.length >= 1) {
//                code = codes[0];
//            }
//            defaultError.setCode(code).setLink("No link");
//        }
//
//        String message = resolveMessage(errorMessage, locale);
//        defaultError.setMessage(message);
//
//        if (!CollectionUtils.isEmpty(errorMessage.getDetails())) {
//            defaultError.setErrors(errorMessage.getDetails()
//                    .stream()
//                    .map(this::handle)
//                    .collect(Collectors.toList()));
//        }
//
//        return defaultError;
//    }
//
//
//    @Override
//    public <T> void postNormalize(T resp) {
//        if (!(resp instanceof DefaultErrorResp)) {
//            LOG.warn("Normalized obj is not a DefaultError! Should never come to this!");
//            return;
//        }
//        DefaultErrorResp error = (DefaultErrorResp) resp;
//
//        StatusAttribute status = status();
//
//        ErrorMessage[] messages = status.getErrorMessages();
//        if (Objects.isNull(messages)) {
//            return;
//        }
//        error.setErrors(Stream.of(messages)
//                .map(this::handle)
//                .collect(Collectors.toList()));
//    }
//
//}
