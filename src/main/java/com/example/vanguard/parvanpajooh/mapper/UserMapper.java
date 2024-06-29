package com.example.vanguard.parvanpajooh.mapper;

import com.example.vanguard.parvanpajooh.db.entity.Users;
import com.example.vanguard.parvanpajooh.response.ShowUserDto;
import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.user.User;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;

public class UserMapper {
    public static Users mapDtoToEntity(SaveUserDto saveUserDto) {
        Users user = new Users();
        user.setTelegramUserId(saveUserDto.telegramUserId());
        user.setName(saveUserDto.name());
        return user;
    }

    public static void mapAggregateToDto(User user, ShowUserDto showUserDto) {
        showUserDto.setName(user.getName().value());
        showUserDto.setTelegramUserId(user.getTelegramUserId().value());
    }

    public static User mapToUser(Users user) {
        Result<User> userResult = User.makeNew(user.getName(), user.getTelegramUserId());

        return userResult.getValue();
    }
}
