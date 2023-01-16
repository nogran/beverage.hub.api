package com.inventory.api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super(String.format("No user was found for ID User '%d'", userId));
    }
}
