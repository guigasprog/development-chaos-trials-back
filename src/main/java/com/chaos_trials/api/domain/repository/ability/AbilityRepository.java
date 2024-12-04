package com.chaos_trials.api.domain.repository.ability;

import com.chaos_trials.api.domain.model.ability.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AbilityRepository extends JpaRepository<Ability, UUID> {

    List<Ability> findByClassEnumInOrderByClassEnum(List<Integer> indices);

}
