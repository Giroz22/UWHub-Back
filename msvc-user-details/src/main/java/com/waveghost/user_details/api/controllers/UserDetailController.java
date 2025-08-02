package com.waveghost.user_details.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.user_details.api.clients.JwtClient;
import com.waveghost.user_details.api.dtos.request.UserDetailRequest;
import com.waveghost.user_details.api.dtos.response.UserDetailResponse;
import com.waveghost.user_details.domain.abstract_services.IUserDetailService;
import com.waveghost.user_details.infrastructure.mappers.UserDetailMapper;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/user-details")
public class UserDetailController {
    
    @Autowired
    private IUserDetailService userDetailService;

    @Autowired
    private JwtClient jwtClient;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @GetMapping("/find-all")
    public ResponseEntity<List<UserDetailResponse>> findAll() {
        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.getAll()
            )
        );
    }

    @GetMapping("/find-me")
    public ResponseEntity<UserDetailResponse> findMe(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader
    )
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.getById(userId)
            )
        );
    }
    
    @PostMapping("/create")
    public ResponseEntity<UserDetailResponse> create(@Valid @RequestBody UserDetailRequest request) 
    {
        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.create(
                    this.userDetailMapper.ToEntity(request)
                )
            )
        );
    }

    @PostMapping("/update")
    public ResponseEntity<UserDetailResponse> update(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader, 
        @Valid @RequestBody UserDetailRequest request
    ) 
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.update(
                    userId,
                    this.userDetailMapper.ToEntity(request)
                )
            )
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader
    )
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        this.userDetailService.delete(userId);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/set-athlete")
    public ResponseEntity<UserDetailResponse> setAthlete(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader
    ) 
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.setAthlete(userId)
            )
        );
    }

    @PatchMapping("/set-coach")
    public ResponseEntity<UserDetailResponse> setCoach(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader
    ) 
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.setCoach(userId)
            )
        );
    }

    @PatchMapping("/set-judge")
    public ResponseEntity<UserDetailResponse> setJudge(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader
    ) 
    {
        String userId = getUserIdFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(
            this.userDetailMapper.ToResponse(
                this.userDetailService.setJudge(userId)
            )
        );
    }

    private String getUserIdFromAuthorizationHeader(String authorizationHeader) {
        return jwtClient.getId(authorizationHeader).getBody();
    }
    
}
