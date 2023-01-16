package com.inventory.api.controller;

import java.util.List;
import java.util.Optional;

import com.inventory.api.exception.UserNotFoundException;
import com.inventory.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventory.api.domain.model.User;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        log.info("GET /api/v1/inventory/users");
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(User user) {
        log.info("POST /api/v1/inventory/user");
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> update(Long userId) {
        log.info("PUT /api/v1/inventory/user/{userId} with param ID User '{}'", userId);
        var user = userService.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException(userId);
        }
        userService.update(user.get());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
