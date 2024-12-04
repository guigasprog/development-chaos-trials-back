package com.chaos_trials.api.domain.model.ability;

import com.chaos_trials.api.application.enums.ClassEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "public", name = "ability")
public class Ability {

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "description")
    private String description;

    @Column(name = "effect")
    private String effect;

    @Column(name = "permitted_level")
    private Integer permittedLevel;

    @Column(name = "class")
    private Integer classEnum;

}
