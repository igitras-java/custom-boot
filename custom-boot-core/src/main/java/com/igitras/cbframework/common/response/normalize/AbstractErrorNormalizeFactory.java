//package com.igitras.cbframework.common.response.normalize;
//
//
//import com.igitras.cbframework.ErrorDescriptorFactory;
//import com.igitras.cbframework.CustomBootExceptionTranslator;
//import com.igitras.cbframework.common.response.ErrorResp;
//import com.igitras.cbframework.common.response.ErrorRespNormalizer;
//import com.igitras.cbframework.exception.CustomBootException;
//import com.igitras.cbframework.exception.uncatalog.UncatalogException;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
///**
// * Class {@link AbstractErrorNormalizeFactory}.
// *
// * @author mason
// */
//public abstract class AbstractErrorNormalizeFactory<E extends ErrorResp> extends AbstractNormalizer
//        implements ErrorRespNormalizer<E> {
//
//    @Autowired
//    private ErrorDescriptorFactory errorDescriptorProvider;
//
//    public ErrorDescriptorFactory getErrorDescriptorProvider() {
//        return errorDescriptorProvider;
//    }
//
//    @Override
//    public E normalizeError(Exception exception) {
//        if (exception instanceof CustomBootException) {
//            return normalizeError((CustomBootException) exception);
//        }
//
//        return getExceptionTranslators().stream()
//                .filter(translator -> translator.support(exception))
//                .findFirst()
//                .map(translator -> translator.translate(exception))
//                .map(this::normalizeError)
//                .orElseGet(() -> {
//                    UncatalogException e = new UncatalogException(exception);
//                    return normalizeError(e);
//                });
//    }
//
//    @Override
//    public E normalizeError(CustomBootException exception) {
//        preNormalize();
//
//        E error = error(exception);
//
//        postNormalize(error);
//        return error;
//    }
//
//    public abstract List<CustomBootExceptionTranslator> getExceptionTranslators();
//
//}
