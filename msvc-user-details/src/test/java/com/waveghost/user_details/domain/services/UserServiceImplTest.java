package com.waveghost.user_details.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waveghost.user_details.DataProvider;
import com.waveghost.user_details.infrastructure.errors.UserDetailAlreadyExistException;
import com.waveghost.user_details.infrastructure.mappers.UserDetailMapper;
import com.waveghost.user_details.persistence.entities.UserDetailEntity;
import com.waveghost.user_details.persistence.repository.UserDetailRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock    
    private UserDetailRepository userDetailRepository;

    @Mock
    private UserDetailMapper userDetailMapper;

    @InjectMocks
    private UserServiceImpl userDetailService;

    @Test
    void shouldSaveUser_whenUserIsValid() {
        //Given
        when(userDetailRepository.save(any(UserDetailEntity.class)))
        .thenReturn(DataProvider.getNewUserSaved());

        UserDetailEntity newUser = DataProvider.getNewUser();

        //When
        UserDetailEntity result = this.userDetailService.create(newUser);

        //Then
        assertEquals("John", result.getName());
    }

    @Test
    void shouldThrowError_whenUserDetailAlreadyExists() {
        //Given
        when(this.userDetailRepository.existsById(anyString())).thenReturn(true);

        UserDetailEntity newUser = DataProvider.getNewUser();

        //When - Then
        assertThrows(
            UserDetailAlreadyExistException.class, 
            () -> this.userDetailService.create(newUser)
        );
    }

    @Test
    void shouldReturnUser_whenSetAthlete() {
        //Given
        UserDetailEntity user = DataProvider.getNewUser();
        when(userDetailRepository.findById("12345")).thenReturn(Optional.of(user));
        when(userDetailRepository.save(any(UserDetailEntity.class))).thenReturn(user);

        //When
        UserDetailEntity result = this.userDetailService.setAthlete("12345");

        //Then
        assertEquals("Is Athlete", result.getAthlete());
    }
}
