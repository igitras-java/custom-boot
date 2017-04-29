package com.igitras.cbframework.common.response.normalize;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;

import java.util.Arrays;
import java.util.Locale;

/**
 * Class {@link ArgumentsResolveFirstResolvable}.
 *
 * @author mason
 */
class ArgumentsResolveFirstResolvable implements MessageSourceResolvable {

    private final MessageSourceResolvable delegate;
    private final MessageSource messageSource;
    private final Locale locale;

    ArgumentsResolveFirstResolvable(MessageSourceResolvable delegate, MessageSource messageSource, Locale locale) {
        this.delegate = delegate;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public String[] getCodes() {
        return delegate.getCodes();
    }

    @Override
    public Object[] getArguments() {
        return Arrays.stream(delegate.getArguments())
                .map(this::localizedArg)
                .toArray();
    }

    @Override
    public String getDefaultMessage() {
        return delegate.getDefaultMessage();
    }

    private String localizedArg(Object arg) {
        if (arg == null) {
            return "null";
        }
        if (arg instanceof String) {
            String strArg = (String) arg;
            return messageSource.getMessage(strArg, null, strArg, locale);
        }
        if (arg instanceof MessageSourceResolvable) {
            MessageSourceResolvable resolvable = (MessageSourceResolvable) arg;
            return messageSource.getMessage(new ArgumentsResolveFirstResolvable(resolvable, messageSource, locale),
                    locale);
        }
        return String.valueOf(arg);
    }
}
