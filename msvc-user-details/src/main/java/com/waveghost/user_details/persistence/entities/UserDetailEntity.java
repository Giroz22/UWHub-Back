package com.waveghost.user_details.persistence.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailEntity {
    @Id
    private String id;
    private String name;              
    private String lastname;          
    private LocalDate dateOfBirth;               
    private String profilePictureUrl; 
    private String athlete;      
    private String coach;             
    private String judge;             
}
