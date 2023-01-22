package com.example.my_client.services;

import com.example.my_client.models.User;
import com.example.my_client.repositories.UserRepository;
import com.example.my_client.security.UserMyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//Данный метод загружает пользователя по юзернейму
        @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByLogin(username);
        if(user.isEmpty()){
            //Выбрасывает исключение
            throw new UsernameNotFoundException("Пользователь не найден!");
        }
        //Возвращаем объект пользователя
        return new UserMyDetails(user.get());
    }
}
