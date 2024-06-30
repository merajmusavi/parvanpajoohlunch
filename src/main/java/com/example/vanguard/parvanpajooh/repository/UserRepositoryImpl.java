package com.example.vanguard.parvanpajooh.repository;

import com.example.vanguard.parvanpajooh.db.entity.Users;
import com.example.vanguard.parvanpajooh.db.entity.jpa.UserJpa;
import com.example.vanguard.parvanpajooh.mapper.UserMapper;
import com.parvanpajooh.aggregate.user.User;
import com.parvanpajooh.aggregate.user.repository.UserRepository;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepository {
    private final UserJpa userJpa;

    public UserRepositoryImpl(UserJpa userRepository) {
        this.userJpa = userRepository;

    }

    @Override
    public void save(SaveUserDto saveUserDto) {
        Users user = UserMapper.mapDtoToEntity(saveUserDto);
        userJpa.save(user);
    }

    @Override
    public List<User> findAll() {
        List<Users> all = userJpa.findAll();
        List<User> users = new ArrayList<>();
        for (Users user : all) {
            users.add(UserMapper.mapToUser(user));
        }
        return users;

    }

    @Override
    public Boolean exists(Long userId) {
        Optional<Users> foundedUser = userJpa.findById(userId);
        return foundedUser.isPresent();
    }
}
