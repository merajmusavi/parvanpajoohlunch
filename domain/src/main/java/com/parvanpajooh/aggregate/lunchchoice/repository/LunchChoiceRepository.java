package com.parvanpajooh.aggregate.lunchchoice.repository;

import com.parvanpajooh.aggregate.lunchchoice.valueobject.Choice;

import java.time.LocalDate;

public interface LunchChoiceRepository {
    void save(Choice first, Choice second, Long userId, LocalDate localDate);
}
