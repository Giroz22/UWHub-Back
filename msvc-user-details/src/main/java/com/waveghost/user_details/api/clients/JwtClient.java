package com.waveghost.user_details.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MSVC-AUTH")
public interface JwtClient {
    @GetMapping("/api/jwt/get-id")
    public ResponseEntity<String> getId(@RequestParam String authorizationHeader);
}
