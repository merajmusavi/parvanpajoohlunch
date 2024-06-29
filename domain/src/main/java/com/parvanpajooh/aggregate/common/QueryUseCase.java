package com.parvanpajooh.aggregate.common;

public interface QueryUseCase<QUERY, SUCCESS_RESULT> {
    public abstract Result<SUCCESS_RESULT> execute(QUERY query);
}
