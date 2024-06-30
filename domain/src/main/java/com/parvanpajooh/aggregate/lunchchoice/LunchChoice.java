package com.parvanpajooh.aggregate.lunchchoice;

import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.lunch.Lunch;
import com.parvanpajooh.aggregate.lunchchoice.valueobject.Choice;
import com.parvanpajooh.aggregate.user.User;

import java.time.LocalDate;

public class LunchChoice {

    Long userId;
    Choice firstChoiceId;
    Choice secondChoiceId;
    LocalDate localDate;

    private LunchChoice(Long userId, Choice firstChoiceId, Choice secondChoiceId, LocalDate localDate) {
        this.localDate = localDate;
        this.secondChoiceId = secondChoiceId;
        this.firstChoiceId = firstChoiceId;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Choice getFirstChoiceId() {
        return firstChoiceId;
    }

    public void setFirstChoiceId(Choice firstChoiceId) {
        this.firstChoiceId = firstChoiceId;
    }

    public Choice getSecondChoiceId() {
        return secondChoiceId;
    }

    public void setSecondChoiceId(Choice secondChoiceId) {
        this.secondChoiceId = secondChoiceId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static Result<LunchChoice> makeNew(Long userId, Choice firstChoiceId,
                                              Choice secondChoiceId, LocalDate localDate) {
        return Result.success(new LunchChoice(
                userId,
                firstChoiceId,
                secondChoiceId,
                localDate
        ));

    }
}
