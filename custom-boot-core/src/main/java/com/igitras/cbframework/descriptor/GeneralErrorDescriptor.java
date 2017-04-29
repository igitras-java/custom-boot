package com.igitras.cbframework.descriptor;

import com.igitras.cbframework.ErrorDescriptor;

/**
 * Class {@link GeneralErrorDescriptor}.
 *
 * @author mason
 */
public class GeneralErrorDescriptor implements ErrorDescriptor {

    private String identity;
    private String code;
    private String link;
    private String description;

    public String getIdentity() {
        return identity;
    }

    public GeneralErrorDescriptor setIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    @Override
    public String getCode() {
        return code;
    }

    public GeneralErrorDescriptor setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String getLink() {
        return link;
    }

    public GeneralErrorDescriptor setLink(String link) {
        this.link = link;
        return this;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public GeneralErrorDescriptor setDescription(String description) {
        this.description = description;
        return this;
    }
}
