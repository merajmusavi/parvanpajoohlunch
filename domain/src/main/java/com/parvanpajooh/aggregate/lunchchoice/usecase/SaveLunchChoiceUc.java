package com.parvanpajooh.aggregate.lunchchoice.usecase;

import com.parvanpajooh.aggregate.common.CommandUseCase;
import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.lunch.repository.LunchRepository;
import com.parvanpajooh.aggregate.lunchchoice.model.cmd.SaveLunchChoiceCmd;
import com.parvanpajooh.aggregate.lunchchoice.repository.LunchChoiceRepository;
import com.parvanpajooh.aggregate.lunchchoice.valueobject.Choice;
import com.parvanpajooh.aggregate.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveLunchChoiceUc implements CommandUseCase<SaveLunchChoiceCmd> {
    LunchChoiceRepository lunchChoiceRepository;
    LunchRepository lunchRepository;
    UserRepository userRepository;

    public SaveLunchChoiceUc(LunchChoiceRepository lunchChoiceRepository, LunchRepository lunchRepository, UserRepository userRepository) {
        this.lunchChoiceRepository = lunchChoiceRepository;
        this.lunchRepository = lunchRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Result<Boolean> execute(SaveLunchChoiceCmd saveLunchCmd) {
        Boolean user = userRepository.exists(saveLunchCmd.userId());
        boolean firstChoiceExists = lunchRepository.exists(saveLunchCmd.firstChoice());
        boolean secondChoiceExists = lunchRepository.exists(saveLunchCmd.secondChoice());

        if (user && firstChoiceExists && secondChoiceExists) {
            Result<Choice> firstChoiceResult = Choice.makeNew(saveLunchCmd.firstChoice());
            Result<Choice> secondChoiceResult = Choice.makeNew(saveLunchCmd.secondChoice());

            lunchChoiceRepository.save(
                    firstChoiceResult.value,
                    secondChoiceResult.value,
                    saveLunchCmd.userId(),
                    saveLunchCmd.localDate()
            );
        }
        return Result.success(true);

    }
}
