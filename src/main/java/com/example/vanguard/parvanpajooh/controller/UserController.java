package com.example.vanguard.parvanpajooh.controller;

import com.example.vanguard.parvanpajooh.response.ShowUserDto;
import com.example.vanguard.parvanpajooh.service.UserService;
import com.parvanpajooh.aggregate.user.repository.dto.SaveUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/all")
    public List<ShowUserDto> getAll(){
       return service.showAll();
    }
}
