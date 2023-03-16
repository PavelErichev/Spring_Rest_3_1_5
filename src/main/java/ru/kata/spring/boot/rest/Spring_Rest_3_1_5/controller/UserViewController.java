package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {

    @GetMapping
    public String userInfo() {
        return "user1";
    }

}