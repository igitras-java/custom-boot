package com.igitras.cbframework.common.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Class {@link DefaultErrorResp}. Resp only for error Response.
 *
 * @author mason
 */
public class DefaultErrorResp implements ErrorResp {

    private static final long serialVersionUID = 4985443972999776854L;
    @NotNull
    private String code;
    private String message;
    @NotNull
    private String link;
    @JsonDeserialize(contentAs = DefaultErrorResp.class)
    private List<ErrorResp> errors;

    @Override
    public String getCode() {
        return code;
    }

    public DefaultErrorResp setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public List<ErrorResp> getErrors() {
        return errors;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public DefaultErrorResp setMessage(String message) {
        this.message = message;
        return this;
    }

    public DefaultErrorResp setLink(String link) {
        this.link = link;
        return this;
    }

    public DefaultErrorResp setErrors(List<ErrorResp> errors) {
        this.errors = errors;
        return this;
    }
}
