package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.entity.User;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUser(@AuthenticationPrincipal User user, Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        model.addAttribute("user", user);
        return "admin";
    }

    @GetMapping("/user-create")
    public String addNewUser(@AuthenticationPrincipal User user, Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(value = "roless") String[] role) {
        userService.saveUser(user, role);
        return "redirect:/admin";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PutMapping(value = "/user-update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "roless") String[] role) {
        userService.saveUser(user, role);
        return "redirect:/admin";
    }
}