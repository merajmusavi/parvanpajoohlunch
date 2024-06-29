package com.example.vanguard.parvanpajooh.db.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LunchChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    Users user;

    @ManyToOne
    @JoinColumn(name = "lunch_first_choice_id", nullable = false)
    Lunch firstChoice;

    @ManyToOne
    @JoinColumn(name = "lunch_second_choice_id", nullable = false)
    Lunch secondChoice;

    @Column(nullable = false)
    private LocalDate localDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Lunch getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(Lunch firstChoice) {
        this.firstChoice = firstChoice;
    }

    public Lunch getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(Lunch secondChoice) {
        this.secondChoice = secondChoice;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}

