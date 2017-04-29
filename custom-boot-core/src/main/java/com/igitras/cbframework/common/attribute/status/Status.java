package com.igitras.cbframework.common.attribute.status;

import com.igitras.cbframework.exception.ErrorMessage;

/**
 * Status representation.
 *
 * @author mason
 */
public class Status implements StatusAttribute {

    private static final long serialVersionUID = 4027964297108974418L;
    private String code;
    private String[] messages;
    private ErrorMessage[] errorMessages;

    public String getCode() {
        return code;
    }

    public Status setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public ErrorMessage[] getErrorMessages() {
        return errorMessages;
    }

    @Override
    public Status setErrorMessages(ErrorMessage[] errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    public String[] getMessages() {
        return messages;
    }

    public Status setMessages(String[] messages) {
        this.messages = messages;
        return this;
    }
}
