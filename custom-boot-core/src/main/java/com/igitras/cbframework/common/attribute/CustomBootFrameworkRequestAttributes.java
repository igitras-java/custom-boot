package com.igitras.cbframework.common.attribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Custom boot framework request attributes. Default implementation of the {@link CustomBootRequestAttributes}.
 *
 * @author mason
 * @since 2.0.0
 */
public class CustomBootFrameworkRequestAttributes implements CustomBootRequestAttributes {

    private static final Logger LOG = LoggerFactory.getLogger(CustomBootFrameworkRequestAttributes.class);
    private final Map<String, Object> attributeHolder = new ConcurrentHashMap<>();

    @Override
    public <T> T getAttribute(String name) {
        if (attributeHolder.containsKey(name)) {
            return (T) attributeHolder.get(name);
        }
        return null;
    }

    @Override
    public String[] getAttributes() {
        Set<String> keySet = attributeHolder.keySet();
        return keySet.toArray(new String[keySet.size()]);
    }

    @Override
    public boolean hasAttribute(String name) {
        return attributeHolder.containsKey(name);
    }

    @Override
    public <T> void setAttribute(String name, T attribute) {
        Assert.notNull(attribute, "not allowed to set an empty attribute");
        if (attributeHolder.containsKey(name)) {
            LOG.warn("there is already an attribute with name {} exists, will override it", name);
        }
        attributeHolder.put(name, attribute);
    }
}
