package com.juliomesquita.core.infra.repository;

import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationUserRepository extends PagingAndSortingRepository<AuthenticationUser, Long> {
    AuthenticationUser findByUsername(String username);
    Optional<AuthenticationUser> findByEmail(String email);
}
