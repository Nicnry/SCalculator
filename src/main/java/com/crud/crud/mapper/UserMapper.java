package com.crud.crud.mapper;

import org.springframework.stereotype.Component;

import com.crud.crud.dto.UserDTO;
import com.crud.crud.entity.User;

@Component
public class UserMapper extends BaseMapper<User, UserDTO, Long> {
    
    @Override
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = createDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setDeletedAt(user.getDeletedAt());
        return dto;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    @Override
    protected UserDTO createDTO() {
        return new UserDTO();
    }
}
