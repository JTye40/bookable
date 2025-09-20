package com.jt40.bookable.dtos;

public record UserResponseDto(
        Long id,
        String username,
        String email,
        String firstName,
        String lastName
) {
}
