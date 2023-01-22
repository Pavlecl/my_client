package com.example.my_client.security;


import com.example.my_client.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserMyDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final User user;

    @Autowired
    public UserMyDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //Позволяет получить пароль у авторизированного пользователя
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    //Позволяет получить логин у авторизированного пользователя
    @Override
    public String getUsername() {

        return this.user.getLogin();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Метод получения объекта пользователя
    public User getUser() {
        return this.user;
    }


}
