package com.chaos_trials.api.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ClassEnum {

    // Classes de Nível 1
    WISE(1, "Wise", 0),
    MAGE(11, "Mage", 1),
    ARCHMAGE(111, "Archmage", 11),
    GRANDMASTER(1111, "Grandmaster", 111),
    ELEMENTALLORD(1112, "Elemental Lord", 111),
    SPELLBLADE(112, "Spellblade", 11),
    WARLOCK(113, "Warlock", 11),
    ARCANIST(12, "Arcanist", 1),
    SORCERER(13, "Sorcerer", 1),
    ELEMENTALIST(14, "Elementalist", 1),
    ILLUSIONIST(15, "Illusionist", 1),
    CLERIC(16, "Cleric", 1),
    NECROMANCER(17, "Necromancer", 1),
    NECROLORD(171, "Necrolord", 17),
    SUMMONER(18, "Summoner", 1),
    DRUID(19, "Druid", 1),

    SUPPORT(2, "Support", 0),
    BARD(21, "Bard", 2),
    ENCHANTER(211, "Enchanter", 21),
    BALLADIST(212, "Balladist", 21),
    MINSTREL(22, "Minstrel", 2),
    ACROBAT(23, "Acrobat", 2),
    GAMBLER(24, "Gambler", 2),

    RANGER(3, "Ranger", 0),
    ARCHER(31, "Archer", 3),
    SNIPER(311, "Sniper", 31),
    DRUIDRANGER(312, "Druid Ranger", 31),
    ALCHEMIST(32, "Alchemist", 3),

    MELEE(4, "Melee", 0),
    WARRIOR(41, "Warrior", 4),
    KNIGHT(411, "Knight", 41),
    GLADIATOR(412, "Gladiator", 41),
    TEMPLAR(42, "Templar", 4),
    LANCER(43, "Lancer", 4),
    ROGUE(44, "Rogue", 4),
    ASSASSIN(441, "Assassin", 44),
    SHADOWKNIGHT(4411, "Shadow Knight", 441),
    NIGHTBLADE(4412, "Night Blade", 441),
    SHADOWDANCER(442, "Shadowdancer", 44),
    BERSERK(45, "Berserk", 4),

    TANK(5, "Tank", 0),
    VANGUARD(53, "Vanguard", 5),
    PALADIN(54, "Paladin", 5),
    INQUISITOR(55, "Inquisitor", 5),
    EXORCIST(56, "Exorcist", 5);

    private final Integer index;
    private String description;
    private Integer dadClass;

    public List<Integer> getParentHierarchy() {
        List<Integer> hierarchy = new ArrayList<>();
        Integer currentIndex = this.dadClass;

        while (currentIndex != 0) {
            hierarchy.add(currentIndex);
            currentIndex = getClassEnumByIndex(currentIndex).getDadClass();
        }

        return hierarchy;
    }

    // Retorna todos os filhos (com base no índice inicial)
    public static List<Integer> getChildIndices(Integer parentIndex) {
        return List.of(ClassEnum.values()).stream()
                .filter(c -> c.getIndex().toString().startsWith(parentIndex.toString()))
                .map(ClassEnum::getIndex)
                .collect(Collectors.toList());
    }

    // Busca o ClassEnum pelo índice
    public static ClassEnum getClassEnumByIndex(Integer index) {
        return Arrays.stream(ClassEnum.values())
                .filter(c -> c.getIndex().equals(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ClassEnum not found for index: " + index));
    }

}

