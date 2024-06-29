package com.example.vanguard.parvanpajooh.repository;

import com.example.vanguard.parvanpajooh.db.entity.jpa.LunchJpa;
import com.example.vanguard.parvanpajooh.mapper.LunchMapper;
import com.parvanpajooh.aggregate.lunch.Lunch;
import com.parvanpajooh.aggregate.lunch.repository.LunchRepository;
import org.springframework.stereotype.Service;


@Service
public class LunchRepositoryImpl implements LunchRepository {

    LunchJpa lunchJpa;

    public LunchRepositoryImpl(LunchJpa lunchJpa) {
        this.lunchJpa = lunchJpa;
    }


    @Override
    public void save(Lunch lunch) {
        com.example.vanguard.parvanpajooh.db.entity.Lunch lunchEntity = LunchMapper.mapFromAggregateToEntity(lunch);
        lunchJpa.save(lunchEntity);
    }
}
