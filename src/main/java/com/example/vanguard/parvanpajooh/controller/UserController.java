package com.example.vanguard.parvanpajooh.controller;

import com.example.vanguard.parvanpajooh.request.User;
import com.example.vanguard.parvanpajooh.service.UserService;
import com.parvanpajooh.aggregate.user.model.qry.SaveUserQry;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import com.parvanpajooh.aggregate.user.usecase.SaveUserUc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> SaveUser(@RequestBody SaveUserDto user) {
        service.saveUser(user);
        return ResponseEntity.ok("ok");
    }
}
