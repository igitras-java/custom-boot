package com.igitras.cbframework.common.attribute;

/**
 * Class {@link FallbackRequestAttributes}.
 *
 * @author mason
 * @since 2.0.0
 */
public class FallbackRequestAttributes implements CustomBootRequestAttributes {

    @Override
    public <T> T getAttribute(String name) {
        return null;
    }

    @Override
    public <T> void setAttribute(String name, T attribute) {

    }

    @Override
    public boolean hasAttribute(String name) {
        return false;
    }

    @Override
    public String[] getAttributes() {
        return new String[0];
    }
}
