package com.parvanpajooh.aggregate.lunch;

import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.lunch.valueobject.LunchName;

public class Lunch {
    LunchName lunchName;

    public LunchName getLunchName() {
        return lunchName;
    }

    public void setLunchName(LunchName lunchName) {
        this.lunchName = lunchName;
    }

    private Lunch(LunchName lunchName) {
        this.lunchName = lunchName;
    }

    public static Result<Lunch> makeNew(String lunchName) {
        Result<LunchName> lunchNameResult = LunchName.makeNew(lunchName);
        if (lunchNameResult.isFailure()) {
            return Result.failure(new IllegalArgumentException("invalid lunch name"));
        }
        return Result.success(new Lunch(lunchNameResult.value));
    }
}
