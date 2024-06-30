package com.example.vanguard.parvanpajooh.repository;

import com.example.vanguard.parvanpajooh.db.entity.Lunch;
import com.example.vanguard.parvanpajooh.db.entity.LunchChoice;
import com.example.vanguard.parvanpajooh.db.entity.Users;
import com.example.vanguard.parvanpajooh.db.entity.jpa.LunchChoiceJpa;
import com.example.vanguard.parvanpajooh.db.entity.jpa.LunchJpa;
import com.example.vanguard.parvanpajooh.db.entity.jpa.UserJpa;
import com.parvanpajooh.aggregate.lunchchoice.repository.LunchChoiceRepository;
import com.parvanpajooh.aggregate.lunchchoice.valueobject.Choice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class LunchChoiceRepositoryImpl implements LunchChoiceRepository {

    LunchChoiceJpa jpa;
    LunchJpa lunchJpa;
    UserJpa userJpa;

    public LunchChoiceRepositoryImpl(LunchChoiceJpa jpa, LunchJpa lunchJpa, UserJpa userJpa) {
        this.jpa = jpa;
        this.lunchJpa = lunchJpa;
        this.userJpa = userJpa;
    }

    @Override
    public void save(Choice first, Choice second, Long userId, LocalDate localDate) {
        LunchChoice choice = new LunchChoice();
        Optional<Lunch> firstChoice = lunchJpa.findById(first.value());
        Optional<Lunch> secondChoice = lunchJpa.findById(second.value());
        Optional<Users> user = userJpa.findById(userId);
        choice.setFirstChoice(firstChoice.get());
        choice.setSecondChoice(secondChoice.get());
        choice.setLocalDate(localDate);
        choice.setUser(user.get());
        jpa.save(choice);
    }
}
