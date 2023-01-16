package com.inventory.api.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super(String.format("Email not available for '%s'", email));
    }
}
