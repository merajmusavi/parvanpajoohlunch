package com.parvanpajooh.aggregate.user.usecase.qry;

import com.parvanpajooh.aggregate.common.QueryUseCase;
import com.parvanpajooh.aggregate.common.Result;
import com.parvanpajooh.aggregate.user.User;
import com.parvanpajooh.aggregate.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListOfUsersUc {

    UserRepository userRepository;

    public GetListOfUsersUc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<List<User>> execute() {
        List<User> allUsers = userRepository.findAll();
        return Result.success(allUsers);
    }
}
