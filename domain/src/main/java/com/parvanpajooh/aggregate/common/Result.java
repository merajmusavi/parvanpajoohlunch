package com.parvanpajooh.aggregate.common;

public class Result<T> {
    public final T value;

    public final Throwable error;

    public Result(T value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public static <T> Result<T> success(T value) {
        return new Result<T>(value, null);
    }

    public static <T> Result<T> failure(Throwable error) {
        return new Result<T>(null, error);
    }

    public Boolean isFailure() {
        return error != null;
    }

    public Boolean isSuccess() {
        return error == null;
    }

    public T getValue() {
        if (isSuccess()) {
            return value;
        } else {
            throw new IllegalArgumentException("this result doesnt contain value");
        }


    }

    public Throwable getError() {
        if (isFailure()) {
            return error;
        } else {
            throw new IllegalArgumentException("this result doesnt have error");
        }
    }
}
