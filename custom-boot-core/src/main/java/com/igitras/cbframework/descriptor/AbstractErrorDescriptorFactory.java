package com.igitras.cbframework.descriptor;

import com.igitras.cbframework.CodeHolder;
import com.igitras.cbframework.ErrorDescriptor;
import com.igitras.cbframework.ErrorDescriptorFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * Abstract Error Code Provider. Loading the descriptor from file or database and provide details for users.
 *
 * @author mason
 */
public abstract class AbstractErrorDescriptorFactory implements ErrorDescriptorFactory, InitializingBean {

    final Map<String, ErrorDescriptor> errorDescriptorMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        loadDescriptors();
    }

    @Override
    public ErrorDescriptor getDescriptor(String... codes) {
        Assert.notNull(codes, "Code should not be null");
        return Stream.of(codes)
                .map(errorDescriptorMap::get)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    @Override
    public ErrorDescriptor getDescriptor(Exception exception) {
        Set<String> codes = new TreeSet<>();
        if (exception instanceof CodeHolder) {
            Collections.addAll(codes, ((CodeHolder) exception).getCodes());
        } else {
            // @formatter:off
            codes.add(exception.getClass().getName());
            codes.add(exception.getClass().getSimpleName());
            // @formatter:on
        }
        return getDescriptor(codes.toArray(new String[codes.size()]));
    }

    public abstract void loadDescriptors();
}
