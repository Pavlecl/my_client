package com.example.my_client.config;

import com.example.my_client.security.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


//Основной конфиг для конфигурации безопастности в приложении
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    private final AuthenticationUser authenticationUser;

    @Autowired
    public SecurityConfig(AuthenticationUser authenticationUser) {
        this.authenticationUser = authenticationUser;
    }
    //Метод по настройке аутентификации
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(authenticationUser);
    }
}
