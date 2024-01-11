package com.juliomesquita.core.domain.model.entities;

import com.juliomesquita.core.domain.model.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AuthenticationUser implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "User";
    @Override
    public Long getId() {
        return null;
    }

    public AuthenticationUser(AuthenticationUser authenticationUser){
        this.id = authenticationUser.getId();
        this.username = authenticationUser.getUsername();
        this.password = authenticationUser.getPassword();
        this.role = authenticationUser.getRole();
    }
}
