package com.jt40.bookable.mappers;

import com.jt40.bookable.dtos.UserCreateDto;
import com.jt40.bookable.dtos.UserResponseDto;
import com.jt40.bookable.entities.User;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UserMapper {

    public UserResponseDto toResponseDto(User user) {
        if (user == null) return null;
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public User toEntity(UserCreateDto dto) {
        if (dto == null) return null;
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .dateOfBirth((Date) dto.dateOfBirth())
                .build();
    }
}
