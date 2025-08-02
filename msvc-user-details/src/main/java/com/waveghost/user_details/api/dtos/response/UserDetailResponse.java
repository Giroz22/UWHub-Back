package com.waveghost.user_details.api.dtos.response;

import java.time.LocalDate;

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
public class UserDetailResponse {
    private String id;
    private String name;              
    private String lastname;          
    private LocalDate dateOfBirth;               
    private String profilePictureUrl; 
    private String athlete;      
    private String coach;             
    private String judge; 
}
