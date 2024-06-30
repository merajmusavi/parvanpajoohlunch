package com.example.vanguard.parvanpajooh.controller.lunchchoice;

import com.example.vanguard.parvanpajooh.request.LunchChoiceDto;
import com.example.vanguard.parvanpajooh.service.lunchchoice.LunchChoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
public class LunchChoiceController {


    LunchChoiceService lunchChoiceService;

    public LunchChoiceController(LunchChoiceService lunchChoiceService) {
        this.lunchChoiceService = lunchChoiceService;
    }

    @PostMapping
    public ResponseEntity<?> saveLunchChoice(@RequestBody LunchChoiceDto lunchChoiceDto) {
        lunchChoiceService.saveLunchChoice(lunchChoiceDto);
        return ResponseEntity.ok("ok");
    }
}
