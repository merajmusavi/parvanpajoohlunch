package com.parvanpajooh.aggregate.lunch.valueobject;

import com.parvanpajooh.aggregate.common.Result;

public record LunchName(String value) {
    public static Result<LunchName> makeNew(String name) {
        return Result.success(new LunchName(name));
    }

    public static LunchName constructFromPersisted(String name) {
        return new LunchName(name);
    }
}
