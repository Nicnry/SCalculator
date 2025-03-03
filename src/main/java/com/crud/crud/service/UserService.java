package com.crud.crud.service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public UserDTO partialUpdate(Long id, User user) {
        Optional<User> existingUserOpt = repository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getDeletedAt() != null) {
                existingUser.setDeletedAt(user.getDeletedAt());
            }

            User updatedEntity = repository.save(existingUser);

            return baseMapper.toDTO(updatedEntity);
        }
        return null;
    }
}
