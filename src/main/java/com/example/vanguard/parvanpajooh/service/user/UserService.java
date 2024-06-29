package com.example.vanguard.parvanpajooh.service.user;

import com.example.vanguard.parvanpajooh.mapper.UserMapper;
import com.example.vanguard.parvanpajooh.response.ShowUserDto;
import com.parvanpajooh.aggregate.user.User;
import com.parvanpajooh.aggregate.user.model.qry.SaveUserQry;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import com.parvanpajooh.aggregate.user.usecase.cmd.SaveUserUc;
import com.parvanpajooh.aggregate.user.usecase.qry.GetListOfUsersUc;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Lazy
public class UserService {
    private final SaveUserUc saveUserUc;

    private final GetListOfUsersUc getListOfUsersUc;

    public UserService(SaveUserUc saveUserUc, GetListOfUsersUc getListOfUsersUc) {
        this.saveUserUc = saveUserUc;
        this.getListOfUsersUc = getListOfUsersUc;
    }

    public void saveUser(SaveUserDto saveUserDto) {
        saveUserUc.execute(new SaveUserQry(saveUserDto.name(), saveUserDto.telegramUserId()));
    }

    public List<ShowUserDto> showAll() {
        List<User> users = getListOfUsersUc.execute().getValue();
        List<ShowUserDto> showUserDtoList = new ArrayList<>();
        ShowUserDto showUserDto = new ShowUserDto();
        for (User user : users) {
            UserMapper.mapAggregateToDto(user, showUserDto);
            showUserDtoList.add(showUserDto);

        }
        return showUserDtoList;
    }
}
