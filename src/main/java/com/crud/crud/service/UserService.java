package com.crud.crud.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.crud.dto.UserDTO;
import com.crud.crud.entity.User;
import com.crud.crud.mapper.UserMapper;
import com.crud.crud.repository.UserRepository;

@Service
public class UserService extends BaseServiceImpl<User, UserDTO, Long> {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        super(userRepository, userMapper);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = repository.save(user);

        return userMapper.toDTO(savedUser);
    }
}
