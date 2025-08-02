package com.waveghost.user_details.api.dtos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailRequest {

    @NotBlank(message = "Id cannot be blank")
    private String id;
    
    @NotBlank(message = "Name cannot be blank")
    private String name;              

    @NotBlank(message = "Lastname cannot be blank")
    private String lastname;
    
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;    

    private String profilePictureUrl;    
}
