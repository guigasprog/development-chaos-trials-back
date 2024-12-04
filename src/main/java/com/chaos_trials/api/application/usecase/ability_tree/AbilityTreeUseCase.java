package com.chaos_trials.api.application.usecase.ability_tree;

import com.chaos_trials.api.application.enums.ClassEnum;
import com.chaos_trials.api.domain.model.ability.Ability;
import com.chaos_trials.api.domain.repository.ability.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AbilityTreeUseCase {

    private final AbilityRepository abilityRepository;

    public AbilityTreeUseCase(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }


    public List<Ability> getAbilityTree(ClassEnum classEnum) {

        Integer currentIndex = classEnum.getIndex();

        List<Integer> parentIndices = classEnum.getParentHierarchy();

        List<Integer> childIndices = ClassEnum.getChildIndices(currentIndex);

        Set<Integer> allIndices = new HashSet<>();
        allIndices.add(currentIndex);
        allIndices.addAll(parentIndices);
        allIndices.addAll(childIndices);
        return abilityRepository.findByClassEnumInOrderByClassEnum(new ArrayList<>(allIndices));
    }


}
