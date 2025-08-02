package com.waveghost.user_details.infrastructure.errors;

public class UserDetailAlreadyExistException extends RuntimeException {
    public UserDetailAlreadyExistException(String id) {
        super("User with id: " + id + " already exists.");
    }
}
