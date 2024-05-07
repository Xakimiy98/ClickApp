package com.company.clickapp.controller;

import com.company.clickapp.dto.CardDto;
import com.company.clickapp.dto.UserDto;
import com.company.clickapp.service.CardService;
import com.company.clickapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/save")
    public CardDto save(@RequestBody CardDto dto){
        return cardService.saveCard(dto);
    }
}
