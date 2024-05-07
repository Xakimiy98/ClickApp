package com.company.clickapp.controller;

import com.company.clickapp.dto.CardDto;
import com.company.clickapp.dto.UserDto;
import com.company.clickapp.entities.User;
import com.company.clickapp.service.CardService;
import com.company.clickapp.service.TransactionService;
import com.company.clickapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransactionService transactionService;


    @GetMapping("/t/{gettingBalance}")
    public boolean transfer(@RequestBody UserDto userDto,
                            @RequestBody CardDto cardDto,
                            @PathVariable Long gettingBalance){

        return transactionService.tran(userDto, cardDto, gettingBalance);

    }
}
