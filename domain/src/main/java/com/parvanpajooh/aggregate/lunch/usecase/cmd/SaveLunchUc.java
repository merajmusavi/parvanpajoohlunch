package com.parvanpajooh.aggregate.lunch.usecase.cmd;

import com.parvanpajooh.aggregate.common.CommandUseCase;
import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.lunch.Lunch;
import com.parvanpajooh.aggregate.lunch.model.SaveLunchQry;
import com.parvanpajooh.aggregate.lunch.repository.LunchRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveLunchUc implements CommandUseCase<SaveLunchQry> {
    LunchRepository lunchRepository;

    public SaveLunchUc(LunchRepository lunchRepository) {
        this.lunchRepository = lunchRepository;
    }

    @Override
    public Result<Boolean> execute(SaveLunchQry saveLunchQry) {
        Result<Lunch> lunchResult = Lunch.makeNew(saveLunchQry.lunchName());
        if (lunchResult.isSuccess()) {
            lunchRepository.save(lunchResult.value);
            return Result.success(true);
        } else {
            return Result.failure(new IllegalArgumentException("invalid lunch name error!"));
        }
    }
}
