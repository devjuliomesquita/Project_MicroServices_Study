package com.juliomesquita.authentication.infra.gateway;

import com.juliomesquita.authentication.infra.dtos.RegisterRequest;
import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import com.juliomesquita.core.domain.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {
    private final PasswordEncoder passwordEncoder;

    public AuthenticationUser requestToAuthenticationUser(RegisterRequest request) {
        return AuthenticationUser
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
}
