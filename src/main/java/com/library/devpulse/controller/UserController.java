package com.library.devpulse.controller;


import com.library.devpulse.domain.User;
import com.library.devpulse.repository.UserRepository;
import com.library.devpulse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }
}
