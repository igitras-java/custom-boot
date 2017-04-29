//package com.igitras.cbframework.common.response.normalize;
//
//
//import static org.springframework.util.StringUtils.concatenateStringArrays;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//
//import java.util.List;
//import java.util.Locale;
//
///**
// * Base Response Factory converter. Convert all the buildResponse to BaseResponse.
// *
// * @author mason
// */
//public class DefaultNormalizeFactory extends AbstractNormalizeFactory<NormalizedNormal, NormalizedError> {
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
//    public <B> NormalizedNormal normal(B body) {
//        return new NormalizedNormal<>().setData(body);
//    }
//
//    @Override
//    public NormalizedError error(CustomBootException exception) {
//        NormalizedError error = new NormalizedError();
//
//        final Locale locale = LocaleContextHolder.getLocale();
//
//        String message = resolveMessage(exception, locale);
//
//        Status status = new Status().setCode(exception.getCatalog()).setMsg(new String[]{message});
//        error.setStatus(status);
//
//        return error;
//    }
//
//    @Override
//    public <T> void postNormalize(T response) {
//        if (response instanceof NormalizedResponse) {
//            NormalizedResponse normalizedResponse = (NormalizedResponse) response;
//            normalizedResponse.setTrace(trace());
//            String[] msg = concatenateStringArrays(normalizedResponse.getStatus()
//                    .getMsg(), status().getMsg());
//            normalizedResponse.getStatus()
//                    .setMsg(msg);
//        }
//    }
//}
