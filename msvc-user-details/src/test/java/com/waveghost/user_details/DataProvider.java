package com.waveghost.user_details;

import java.time.LocalDate;

import com.waveghost.user_details.persistence.entities.UserDetailEntity;

public class DataProvider {

    public static UserDetailEntity getNewUserSaved(){
        return UserDetailEntity
            .builder()
            .id("12345")
            .name("John")
            .lastname("Doe")
            .dateOfBirth(LocalDate.of(1990, 1, 1))
            .profilePictureUrl("http://example.com/profile.jpg")
            .athlete(null)
            .coach(null)
            .judge(null)
            .build();
    }
    
    public static UserDetailEntity getNewUser(){
        return UserDetailEntity
            .builder()
            .id("12345")
            .name("John")
            .lastname("Doe")
            .dateOfBirth(LocalDate.of(1990, 1, 1))
            .profilePictureUrl("http://example.com/profile.jpg")
            .build();
    }
}