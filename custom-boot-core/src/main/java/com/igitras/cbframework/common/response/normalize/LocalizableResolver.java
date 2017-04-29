package com.igitras.cbframework.common.response.normalize;


import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class {@link LocalizableResolver}. Localize the resolvable and the arguments if it can be resolved.
 *
 * @author mason
 */
public class LocalizableResolver implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String resolveMessage(MessageSourceResolvable resolvable, Locale locale) {
        Assert.notNull(resolvable, "MessageSourceResolvable must not be null.");
        Assert.notNull(locale, "Locale must not be null.");
        try {
            return messageSource.getMessage(new ArgumentsResolveFirstResolvable(resolvable, messageSource, locale),
                    locale);
        } catch (NoSuchMessageException exception) {
            return resolvable.getDefaultMessage();
        }
    }

    private Object[] normalizeArgs(Object... args) {
        final Locale locale = LocaleContextHolder.getLocale();

        return Stream.of(args)
                .map(arg -> {
                    if (arg instanceof String) {
                        String key = (String) arg;
                        return messageSource.getMessage(key, null, key, locale);
                    } else if (arg instanceof MessageSourceResolvable) {
                        return messageSource.getMessage((MessageSourceResolvable) arg, locale);
                    } else {
                        return arg;
                    }
                })
                .collect(Collectors.toList())
                .toArray(new Object[args.length]);
    }

}
