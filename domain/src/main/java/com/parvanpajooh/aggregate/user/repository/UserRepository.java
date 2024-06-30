package com.parvanpajooh.aggregate.user.repository;

import com.parvanpajooh.aggregate.user.User;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;

import java.util.List;

public interface UserRepository {
    void save(SaveUserDto saveUserDto);

    List<User> findAll();

    Boolean exists(Long userId);
}
