package com.chaos_trials.api.web.controller.ability;

import com.chaos_trials.api.application.enums.ClassEnum;
import com.chaos_trials.api.application.usecase.ability_tree.AbilityTreeUseCase;
import com.chaos_trials.api.domain.model.ability.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/abilities")
public class AbilityController {

    private final AbilityTreeUseCase abilityTreeUseCase;

    @Autowired
    public AbilityController(AbilityTreeUseCase abilityTreeUseCase) {
        this.abilityTreeUseCase = abilityTreeUseCase;
    }

    /**
     * Endpoint para buscar todas as habilidades associadas a uma classe e sua hierarquia
     *
     * @param classEnum O identificador da classe fornecido como string
     * @return Lista de habilidades relacionadas
     */
    @GetMapping("/{classEnum}")
    public ResponseEntity<List<Ability>> getAbilityTree(@PathVariable("classEnum") String classEnum) {

        ClassEnum selectedClass = ClassEnum.valueOf(classEnum.toUpperCase());

        List<Ability> abilities = abilityTreeUseCase.getAbilityTree(selectedClass);

        return ResponseEntity.ok(abilities);


    }
}

