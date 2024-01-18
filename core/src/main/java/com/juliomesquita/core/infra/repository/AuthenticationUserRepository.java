package com.juliomesquita.core.infra.repository;

import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationUserRepository extends JpaRepository<AuthenticationUser, Long> {
    AuthenticationUser findByUsername(String username);
    Optional<AuthenticationUser> findByEmail(String email);
}
