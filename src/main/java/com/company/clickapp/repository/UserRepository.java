package com.company.clickapp.repository;

import com.company.clickapp.entities.Card;
import com.company.clickapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
