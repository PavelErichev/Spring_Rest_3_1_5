package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.entity.User;

@Controller
public class AdminViewController {

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin1";
    }

    /*@GetMapping("/admin/user-create")
    public String newUser(){
        return "user-create";
    }

    @GetMapping("/userAdmin")
    public String getUserAdmin() {
        return "userAdmin";
    }*/

}