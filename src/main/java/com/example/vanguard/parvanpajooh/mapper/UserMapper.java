package com.example.vanguard.parvanpajooh.mapper;

import com.example.vanguard.parvanpajooh.db.entity.Users;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;

public class UserMapper {
    public static Users mapDtoToEntity(SaveUserDto saveUserDto) {
        Users user = new Users();
        user.setTelegramUserId(saveUserDto.telegramUserId());
        user.setName(saveUserDto.name());
        return user;
    }
}
