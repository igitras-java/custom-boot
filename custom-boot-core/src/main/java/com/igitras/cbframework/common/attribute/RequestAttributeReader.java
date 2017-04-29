package com.igitras.cbframework.common.attribute;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Class {@link RequestAttributeReader}. One reader support only one type of attribute.
 *
 * @author mason
 */
public interface RequestAttributeReader<T extends RequestAttribute> {

    /**
     * Determine and limit the supported attribute.
     *
     * @param clazz supported attribute type
     * @return support or not
     */
    boolean support(Class clazz);

    /**
     * Read the attribute from the request.
     *
     * @param request http request
     * @return request attribute
     */
    T read(HttpServletRequest request);


    default Long readLong(String headerName, HttpServletRequest request) {
        Assert.notNull(request, "Request must not be null while reading [Long] header.");
        Assert.hasText(headerName, "Header name must not be null while reading [Long] header.");
        String header = request.getHeader(headerName);

        if (!StringUtils.isEmpty(header)) {
            return Long.parseLong(header);
        }
        
        return null;
    }

    default String readString(String headerName, HttpServletRequest request) {
        Assert.notNull(request, "Request must not be null while reading [String] header.");
        Assert.hasText(headerName, "Header name must not be null while reading [String] header.");

        String header = request.getHeader(headerName);
        return StringUtils.isEmpty(header) ? null : header;
    }
}
