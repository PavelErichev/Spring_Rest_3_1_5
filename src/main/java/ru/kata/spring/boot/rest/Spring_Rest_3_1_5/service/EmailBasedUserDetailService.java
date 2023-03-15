package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.entity.User;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.repository.UserRepository;

import java.util.Optional;

@Service
public class EmailBasedUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public EmailBasedUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}