package com.igitras.cbframework.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class {@link ErrorMessageBuilder}.
 *
 * @author mason
 */
public class ErrorMessageBuilder implements MessageMaintainer, HierarchyMaintainer<ErrorMessage> {

    private final CustomBootExceptionErrorMessage errorMessage;

    private ErrorMessageBuilder() {
        this.errorMessage = new CustomBootExceptionErrorMessage();
    }

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }

    @Override
    public ErrorMessageBuilder addArguments(Object... arguments) {
        errorMessage.addArguments(arguments);
        return this;
    }

    @Override
    public ErrorMessageBuilder addCodes(String... codes) {
        errorMessage.addCodes(codes);
        return this;
    }

    @Override
    public ErrorMessageBuilder setDefaultMessage(String defaultMessage) {
        errorMessage.setDefaultMessage(defaultMessage);
        return this;
    }

    @Override
    public ErrorMessageBuilder addDetails(ErrorMessage... details) {
        errorMessage.addDetails(details);
        return this;
    }

    public ErrorMessage build() {
        return this.errorMessage;
    }

    /**
     * Class {@link CustomBootExceptionErrorMessage}.
     */
    private class CustomBootExceptionErrorMessage extends ResolvableArgument
            implements ErrorMessage, MessageMaintainer, HierarchyMaintainer<ErrorMessage> {

        private List<ErrorMessage> details;

        @Override
        public List<ErrorMessage> getDetails() {
            if (details != null) {
                return details;
            }
            return Collections.emptyList();
        }

        @Override
        public CustomBootExceptionErrorMessage addDetails(ErrorMessage... detail) {
            if (this.details == null) {
                this.details = new ArrayList<>();
            }
            Collections.addAll(this.details, detail);
            return this;
        }
    }
}
