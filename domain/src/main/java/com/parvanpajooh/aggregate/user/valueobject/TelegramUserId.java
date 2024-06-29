package com.parvanpajooh.aggregate.user.valueobject;

import com.parvanpajooh.aggregate.common.Result;

public record TelegramUserId(String value) {

    public static Result<TelegramUserId> makeNew(String telegramUserId) {
        if (isValidTelegramUserId(telegramUserId)){
            return Result.success(new TelegramUserId(telegramUserId));
        }else {
            return Result.failure(new IllegalArgumentException(""));
        }
    }

    private static Boolean isValidTelegramUserId(String telegramUserId) {
        return telegramUserId.length() >= 5 && telegramUserId.length() <= 10;
    }

}
