package com.example.vanguard.parvanpajooh.mapper;

import com.parvanpajooh.aggregate.lunch.Lunch;

public class LunchMapper {
    public static com.example.vanguard.parvanpajooh.db.entity.Lunch mapFromAggregateToEntity(Lunch lunch) {
        com.example.vanguard.parvanpajooh.db.entity.Lunch lunchEntity = new com.example.vanguard.parvanpajooh.db.entity.Lunch();

        lunchEntity.setName(lunch.getLunchName().value());
        return lunchEntity;
    }
}
