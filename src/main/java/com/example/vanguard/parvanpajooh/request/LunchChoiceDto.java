package com.example.vanguard.parvanpajooh.request;

public class LunchChoiceDto {
    Long firstChoiceId;
    Long secondChoiceId;
    Long userId;


    public Long getFirstChoiceId() {
        return firstChoiceId;
    }

    public void setFirstChoiceId(Long firstChoiceId) {
        this.firstChoiceId = firstChoiceId;
    }

    public Long getSecondChoiceId() {
        return secondChoiceId;
    }

    public void setSecondChoiceId(Long secondChoiceId) {
        this.secondChoiceId = secondChoiceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
