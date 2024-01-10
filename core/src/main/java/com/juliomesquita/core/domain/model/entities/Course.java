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
public class Course implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String title;
    @Override
    public Long getId() {
        return null;
    }
}
