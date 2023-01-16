package com.inventory.api.exception;

public class UserNotUpdatedException extends RuntimeException {
    public UserNotUpdatedException(Long userId) {
        super(String.format("No user was found for ID User '%d'", userId));
    }
}
