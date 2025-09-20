package com.jt40.bookable.dtos;

import java.util.Date;

public record UserCreateDto(
        String username,
        String email,
        String password,
        String firstName,
        String lastName,
        Date dateOfBirth
) {
}
