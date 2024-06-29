package com.parvanpajooh.aggregate.user.valueobject;

import com.parvanpajooh.aggregate.common.Result;

public record Name(String value) {

    public static Result<Name> makeNew(String username) {
        return Result.success(new Name(username));
    }

    public static Name constructFromPersisted(String name) {
        return new Name(name);
    }
}
