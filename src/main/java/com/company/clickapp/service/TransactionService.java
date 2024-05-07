package com.company.clickapp.service;

import com.company.clickapp.dto.CardDto;
import com.company.clickapp.dto.UserDto;
import com.company.clickapp.entities.Card;
import com.company.clickapp.entities.Click;
import com.company.clickapp.entities.User;
import com.company.clickapp.repository.CardRepository;
import com.company.clickapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final Click click;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Transactional
    public boolean tran(UserDto userDto, CardDto cardDto, Long gettingBalance){
            User user =  userRepository.getReferenceById(userDto.getId());
            Card card =  cardRepository.getReferenceById(cardDto.getId());

        if (user.getCards().stream().anyMatch(e -> e.getId().equals(card.getId()))){
            double v = gettingBalance * click.getUserkomisya();
            click.setBalance(click.getBalance()+v);
            card.setBalance(card.getBalance()+(gettingBalance-v));
            return true;
        }else if (user.getCards().stream().noneMatch(e -> e.getId().equals(card.getId()))){
            double v = gettingBalance * click.getKomisya();
            click.setBalance(click.getBalance()+v);
            card.setBalance(card.getBalance()+(gettingBalance-v));
            return true;
        }
        return false;
    }
}
