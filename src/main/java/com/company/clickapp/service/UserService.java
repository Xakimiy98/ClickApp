package com.company.clickapp.service;

import com.company.clickapp.dto.UserDto;
import com.company.clickapp.entities.Card;
import com.company.clickapp.entities.User;
import com.company.clickapp.repository.CardRepository;
import com.company.clickapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    public UserDto saveUser(UserDto dto){
        User user = mapToEntity(dto);
        userRepository.save(user);
        return mapToDto(user);
    }
    public User mapToEntity(UserDto dto){
        return User.builder()
                .name(dto.getName())
                .build();
    }

    private UserDto mapToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .cardsId(user.getCards().stream().map(Card::getId).collect(Collectors.toList()))
                .build();
    }

}
