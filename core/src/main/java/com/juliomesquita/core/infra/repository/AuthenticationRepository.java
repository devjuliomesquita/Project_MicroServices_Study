package com.juliomesquita.core.infra.repository;

import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<AuthenticationUser, Long> {
    AuthenticationUser findByUsername(String username);
}
