package com.example.vanguard.parvanpajooh.service;

import com.parvanpajooh.aggregate.user.model.qry.SaveUserQry;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import com.parvanpajooh.aggregate.user.usecase.SaveUserUc;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserService {
    private final SaveUserUc saveUserUc;

    public UserService(SaveUserUc saveUserUc) {
        this.saveUserUc = saveUserUc;
    }

    public void saveUser(SaveUserDto saveUserDto) {
        saveUserUc.execute(new SaveUserQry(saveUserDto.name(), saveUserDto.telegramUserId()));
    }
}
