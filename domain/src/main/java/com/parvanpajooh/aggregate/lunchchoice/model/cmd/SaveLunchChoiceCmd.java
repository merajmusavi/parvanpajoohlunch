package com.parvanpajooh.aggregate.lunchchoice.model.cmd;

import com.parvanpajooh.aggregate.lunch.Lunch;
import com.parvanpajooh.aggregate.user.User;

import java.time.LocalDate;

public record SaveLunchChoiceCmd(Long userId,
                                 Long firstChoice,
                                 Long secondChoice,
                                 LocalDate localDate) {

}
