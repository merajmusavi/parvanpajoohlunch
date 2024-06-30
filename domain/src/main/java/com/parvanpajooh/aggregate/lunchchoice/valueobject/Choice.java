package com.parvanpajooh.aggregate.lunchchoice.valueobject;

import com.parvanpajooh.aggregate.common.Result;

public record Choice(Long value) {
    public static Result<Choice> makeNew(Long choice) {
        return Result.success(new Choice(choice));
    }

    public static Choice constructFromPersisted(Long choice) {
        return new Choice(choice);
    }
}
