package com.parvanpajooh.aggregate.user.repository;

import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;

public interface UserRepository {
    void save(SaveUserDto saveUserDto);
}
