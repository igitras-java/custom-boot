package com.igitras.cbframework.exception;

import com.igitras.cbframework.ArgumentHolder;
import com.igitras.cbframework.CodeHolder;
import com.igitras.cbframework.HierarchyHolder;

import org.springframework.context.MessageSourceResolvable;

/**
 * Class {@link ErrorMessage}.
 *
 * @author mason
 */
public interface ErrorMessage
        extends MessageSourceResolvable, CodeHolder, ArgumentHolder, HierarchyHolder<ErrorMessage> {

}
