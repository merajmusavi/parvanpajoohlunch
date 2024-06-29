package com.example.vanguard.parvanpajooh.service.lunch;

import com.parvanpajooh.aggregate.lunch.model.SaveLunchQry;
import com.parvanpajooh.aggregate.lunch.usecase.cmd.SaveLunchUc;
import com.parvanpajooh.aggregate.user.repository.dto.SaveLunchDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class LunchService {
    SaveLunchUc saveLunchUc;

    public LunchService(SaveLunchUc saveLunchUc) {
        this.saveLunchUc = saveLunchUc;
    }

    public void saveLunch(SaveLunchDto saveLunchDto){
        saveLunchUc.execute(new SaveLunchQry(
                saveLunchDto.name()
        ));
    }
}
