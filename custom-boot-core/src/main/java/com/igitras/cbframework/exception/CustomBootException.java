package com.igitras.cbframework.exception;

import com.igitras.cbframework.StatusHolder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class {@link CustomBootException}. Base class of the exception hierarchy.
 *
 * @author mason
 */
public abstract class CustomBootException extends RuntimeException implements ErrorMessage, StatusHolder {

    private static final long serialVersionUID = 6316850601629066841L;

    private final ErrorMessage delegate;

    public CustomBootException(String message, ErrorMessage error) {
        super(message);
        Assert.notNull(error, "Error Message must not be null while create customBootException.");
        this.delegate = error;
    }

    @Override
    public String[] getCodes() {
        String[] codes = delegate.getCodes();

        if (codes == null || codes.length == 0) {
            codes = new String[]{getClass().getName(), getClass().getSimpleName()};
        }

        return codes;
    }

    @Override
    public Object[] getArguments() {
        return delegate.getArguments();
    }

    @Override
    public String getDefaultMessage() {
        String defaultMessage = delegate.getDefaultMessage();

        if (StringUtils.isEmpty(defaultMessage)) {
            defaultMessage = getMessage();
        }

        return defaultMessage;
    }


    @Override
    public List<ErrorMessage> getDetails() {
        return delegate.getDetails();
    }

}
