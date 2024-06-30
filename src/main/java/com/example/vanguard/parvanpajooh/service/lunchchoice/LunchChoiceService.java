package com.example.vanguard.parvanpajooh.service.lunchchoice;

import com.example.vanguard.parvanpajooh.request.LunchChoiceDto;
import com.parvanpajooh.aggregate.lunch.usecase.cmd.SaveLunchUc;
import com.parvanpajooh.aggregate.lunchchoice.model.cmd.SaveLunchChoiceCmd;
import com.parvanpajooh.aggregate.lunchchoice.usecase.SaveLunchChoiceUc;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Lazy
public class LunchChoiceService {
    SaveLunchChoiceUc saveLunchChoiceUc;

    public LunchChoiceService(SaveLunchChoiceUc saveLunchChoiceUc) {
        this.saveLunchChoiceUc = saveLunchChoiceUc;
    }

    public void saveLunchChoice(LunchChoiceDto lunchChoiceDto) {
        saveLunchChoiceUc.execute(
                new SaveLunchChoiceCmd(
                        lunchChoiceDto.getUserId(),
                        lunchChoiceDto.getFirstChoiceId(),
                        lunchChoiceDto.getSecondChoiceId(),
                        LocalDate.now()
                )
        );
    }

}
