package com.example.my_client.security;

import com.example.my_client.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

@Component
public class AuthenticationUser implements AuthenticationProvider {

        private final UserDetailsService userDetailsService;

        @Autowired
    public AuthenticationUser(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    //В данном методе прописываем всю логику по аутентификации
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //Здесь получаем логин из формы
        String login = authentication.getName();

        //Обращаемся к интерфейсу который позволяет работать с юзерами(не путать с нашим классом)
        UserDetails user = userDetailsService.loadUserByUsername(login);
        //Получаем пароль с формы аутентификации
        String password = authentication.getCredentials().toString();

        //Если пароль полученный из формы не равен паролю в БД
        if(!password.equals(user.getPassword())){

            //То выбрасываем исключение
            throw new BadCredentialsException("Пароль не верный!");
        }
        //Возвращаем объект аутентификации. В данном объектке будет лежать пользователь, который аутентифицировался, его пароль и права доступа
        return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
