package com.company.clickapp.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Component
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double balance;
    final double komisya = 0.001;
    final double userkomisya = 0.001;
}
