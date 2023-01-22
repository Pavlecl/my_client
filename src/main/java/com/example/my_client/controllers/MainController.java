package com.example.my_client.controllers;

import com.example.my_client.security.UserMyDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index(){

        //Получаем объект аутентификации с помощью SecurityContextHolder обращаемся к контексту и на нем вызываем метод аутентификации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //Преобразовываем объект аутентификации в специальный объект класса по работе с пользователями
        UserMyDetails userMyDetails = (UserMyDetails) authentication.getPrincipal();

        return "index";
    }
}
