package com.igitras.cbframework.exception;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.util.Assert;

/**
 * Class {@link ResolvableArgument}.
 *
 * @author mason
 */
public class ResolvableArgument implements MessageSourceResolvable, MessageMaintainer {

    private String[] codes;
    private Object[] arguments;
    private String defaultMessage;

    public ResolvableArgument() {
    }

    public ResolvableArgument(Exception exception) {
        Assert.notNull(exception, "Exception must not be null.");
        this.defaultMessage = exception.getMessage();
        this.codes = new String[]{exception.getClass().getName(), exception.getClass().getSimpleName()};
    }

    @Override
    public ResolvableArgument addArguments(Object... arg) {
        if (this.arguments == null) {
            this.arguments = new Object[arg.length];
            System.arraycopy(arg, 0, this.arguments, 0, arg.length);
        } else {
            Object[] newArgs = new Object[this.arguments.length + arg.length];
            System.arraycopy(this.arguments, 0, newArgs, 0, this.arguments.length);
            System.arraycopy(arg, 0, newArgs, this.arguments.length, arg.length);
            this.arguments = newArgs;
        }
        return this;
    }

    @Override
    public ResolvableArgument addCodes(String... codes) {
        if (this.codes == null) {
            this.codes = new String[codes.length];
            System.arraycopy(codes, 0, this.codes, 0, codes.length);
        } else {
            String[] newCodes = new String[this.codes.length + codes.length];
            System.arraycopy(this.codes, 0, newCodes, 0, this.codes.length);
            System.arraycopy(codes, 0, newCodes, this.codes.length, codes.length);
            this.codes = newCodes;
        }
        return this;
    }

    @Override
    public String[] getCodes() {
        if (codes != null) {
            return this.codes;
        }
        return new String[0];
    }

    @Override
    public Object[] getArguments() {
        if (arguments != null) {
            return arguments;
        }
        return new Object[0];
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public ResolvableArgument setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
        return this;
    }
}
