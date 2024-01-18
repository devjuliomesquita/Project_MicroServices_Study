package com.juliomesquita.authentication.infra.gateway;

import com.juliomesquita.authentication.infra.config.security.service.JwtService;
import com.juliomesquita.authentication.infra.dtos.AuthenticationRequest;
import com.juliomesquita.authentication.infra.dtos.AuthenticationResponse;
import com.juliomesquita.authentication.infra.dtos.RegisterRequest;
import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import com.juliomesquita.core.infra.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationGateway {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationUserRepository repository;
    private final AuthenticationMapper mapper;

    public AuthenticationResponse register(RegisterRequest request) {
        AuthenticationUser authenticationUser = this.mapper.requestToAuthenticationUser(request);
        AuthenticationUser userSaved = this.repository.save(authenticationUser);
        String token = this.jwtService.generateToken(userSaved);


        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Optional<AuthenticationUser> user = this.repository.findByEmail(request.getEmail());
        String token = this.jwtService.generateToken(user.get());

        return AuthenticationResponse.builder().token(token).build();
    }
}
