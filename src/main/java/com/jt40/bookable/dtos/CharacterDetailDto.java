package com.jt40.bookable.dtos;

public record CharacterDetailDto(
        String name,
        String aliases,
        Integer currentAge,
        String personality,
        String traits,
        String skills,
        String achievements,
        String imageUrl
) {
}
