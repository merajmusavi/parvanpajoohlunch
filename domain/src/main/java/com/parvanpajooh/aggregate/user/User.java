package com.parvanpajooh.aggregate.user;

import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.user.valueobject.Name;
import com.parvanpajooh.aggregate.user.valueobject.TelegramUserId;

public class User {
    Name name;
    TelegramUserId telegramUserId;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public TelegramUserId getTelegramUserId() {
        return telegramUserId;
    }

    public void setTelegramUserId(TelegramUserId telegramUserId) {
        this.telegramUserId = telegramUserId;
    }

    private User(
            Name name,
            TelegramUserId telegramUserId
    ) {
        this.name = name;
        this.telegramUserId = telegramUserId;
    }

    public static Result<User> makeNew(
            String name,
            String telegramUserid
    ) {
        Result<Name> nameResult = Name.makeNew(name);
        Result<TelegramUserId> telegramUserIdResult = TelegramUserId.makeNew(telegramUserid);

        if (nameResult.isFailure()) {
            return Result.failure(new IllegalArgumentException("invalid name format"));
        } else if (telegramUserIdResult.isFailure()) {
            return Result.failure(new IllegalArgumentException("invalid telegram userid Format format"));
        } else {
            return Result.success(
                    new User(
                            nameResult.getValue(),
                            telegramUserIdResult.getValue()
                    )
            );
        }

    }
}
