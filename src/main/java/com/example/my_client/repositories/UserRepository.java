package com.example.my_client.repositories;

import com.example.my_client.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    //Получаем запись из бд по логину
    Optional<User> findByLogin(String login);
}
