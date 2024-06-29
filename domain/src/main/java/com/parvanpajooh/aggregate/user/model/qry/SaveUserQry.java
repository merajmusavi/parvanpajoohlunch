package com.parvanpajooh.aggregate.user.model.qry;

public record SaveUserQry(
        String name,
        String telegramUserId
) {
}
