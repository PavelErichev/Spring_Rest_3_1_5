package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.service;

import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void update(int id, User updatedUser);

    void deleteUser(int id);

}