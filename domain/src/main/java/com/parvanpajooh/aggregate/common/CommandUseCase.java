package com.parvanpajooh.aggregate.common;

public interface CommandUseCase<QUERY> {
    public abstract Result<Boolean> execute(QUERY query);
}
