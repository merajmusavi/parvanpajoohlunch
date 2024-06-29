package com.parvanpajooh.aggregate.user.usecase;

import com.parvanpajooh.aggregate.common.CommandUseCase;
import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.user.model.qry.SaveUserQry;
import com.parvanpajooh.aggregate.user.repository.UserRepository;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import com.parvanpajooh.aggregate.user.valueobject.Name;
import com.parvanpajooh.aggregate.user.valueobject.TelegramUserId;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveUserUc implements CommandUseCase<SaveUserQry> {
    private static final Logger logger = Logger.getLogger(SaveUserUc.class.getName());

    private UserRepository userRepository;

    public SaveUserUc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result<Boolean> execute(SaveUserQry saveUserQry) {
        Result<Name> nameResult = Name.makeNew(saveUserQry.name());
        Result<TelegramUserId> telegramUserIdResult = TelegramUserId.makeNew(saveUserQry.telegramUserId());
        if (nameResult.isFailure()) {
            logger.log(Level.WARNING, "Invalid name format: " + saveUserQry.name());
            return Result.failure(new IllegalArgumentException("invalid name format"));

        } else if (telegramUserIdResult.isFailure()) {
            logger.log(Level.WARNING, "Invalid name format: " + saveUserQry.name());

            return Result.failure(new IllegalArgumentException("invalid telegram userid Format format"));
        } else {
            userRepository.save(new SaveUserDto(
                    saveUserQry.name(),
                    saveUserQry.telegramUserId()
            ));

            logger.log(Level.INFO, "User saved successfully: " + saveUserQry.name());
            return Result.success(true);
        }

    }
}
