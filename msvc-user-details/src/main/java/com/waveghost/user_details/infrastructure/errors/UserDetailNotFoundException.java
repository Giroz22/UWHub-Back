package com.waveghost.user_details.infrastructure.errors;

public class UserDetailNotFoundException extends RuntimeException {
    public UserDetailNotFoundException(String id) {
        super("User with id: " + id + " was not found.");
    }
}
