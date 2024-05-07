package com.company.clickapp.service;

import com.company.clickapp.dto.CardDto;
import com.company.clickapp.entities.Card;
import com.company.clickapp.repository.CardRepository;
import com.company.clickapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardDto saveCard(CardDto dto){
        Card card = mapToEntity(dto);
        cardRepository.save(card);
        userRepository.getReferenceById(dto.getUserId()).getCards().add(card);
        return mapToDto(card);
    }

    public Card mapToEntity(CardDto dto){
        return Card.builder()
                .cardNumber(dto.getCardNumber())
                .user(userRepository.getReferenceById(dto.getUserId()))
                .balance(dto.getBalance())
                .build();
    }

    private CardDto mapToDto(Card card){
        return CardDto.builder()
                .id(card.getId())
                .cardNumber(card.getCardNumber())
                .userId(card.getUser().getId())
                .balance(card.getBalance())
                .build();
    }
}
