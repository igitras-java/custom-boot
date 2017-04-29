package com.igitras.cbframework.common.response;

import java.util.List;

/**
 * Response that when error occurred. Each system can defined a series of error getCode.
 *
 * @author mason
 */
public interface ErrorResp extends NormalizedResp {

    String ERROR_ATTRIBUTES = ErrorResp.class.getName() + ".ATTRIBUTES";

    /**
     * A getCode that represent the error.
     *
     * @return error getCode
     */
    String getCode();

    /**
     * The Error Message of the error getCode, include some customized params.
     *
     * @return error msg
     */
    String getMessage();

    /**
     * Error definition url, for user to get some details of the error.
     *
     * @return error link
     */
    String getLink();

    /**
     * Error details if this error is made up with a series of error.
     *
     * @return errors
     */
    List<ErrorResp> getErrors();
}
