package com.example.vanguard.parvanpajooh.controller.lunch;

import com.example.vanguard.parvanpajooh.service.lunch.LunchService;
import com.parvanpajooh.aggregate.user.repository.dto.SaveLunchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    LunchService lunchService;

    public LunchController(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SaveLunchDto saveLunchDto) {
        lunchService.saveLunch(saveLunchDto);
        return ResponseEntity.ok("ok");
    }

}
