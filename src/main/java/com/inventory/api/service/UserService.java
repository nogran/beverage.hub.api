package com.inventory.api.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.inventory.api.exception.EmailAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.inventory.api.domain.model.User;
import com.inventory.api.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        String email = user.getEmail();
        if (isEmailPresent(email))
            throw new EmailAlreadyExistsException(email);
        return save(user);
    }

    public User update(User user) {
        save(user);
        return save(user);
    }

    private User save(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    private boolean isEmailPresent(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().withoutPadding().encodeToString(password.getBytes());
    }
}