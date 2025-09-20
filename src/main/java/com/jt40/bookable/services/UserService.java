package com.jt40.bookable.services;

import com.jt40.bookable.dtos.UserCreateDto;
import com.jt40.bookable.dtos.UserResponseDto;
import com.jt40.bookable.entities.User;
import com.jt40.bookable.mappers.UserMapper;
import com.jt40.bookable.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto registerUser(UserCreateDto dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

}
