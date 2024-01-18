package com.juliomesquita.authentication.infra.controller;

import com.juliomesquita.authentication.infra.dtos.AuthenticationRequest;
import com.juliomesquita.authentication.infra.dtos.AuthenticationResponse;
import com.juliomesquita.authentication.infra.dtos.RegisterRequest;
import com.juliomesquita.authentication.infra.gateway.AuthenticationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationGateway gateway;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(this.gateway.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(this.gateway.authentication(request));
    }
}
