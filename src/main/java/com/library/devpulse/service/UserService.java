package com.library.devpulse.service;


import com.library.devpulse.annotation.Profiled;
import com.library.devpulse.domain.User;
import com.library.devpulse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Profiled("UserService.findUser")
    public List<User> findUserByName(String name) {
        return userRepository.findByNameContaining(name);

    }
}
