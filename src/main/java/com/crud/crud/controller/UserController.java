package com.crud.crud.controller;

import com.crud.crud.dto.UserDTO;
import com.crud.crud.entity.User;
import com.crud.crud.mapper.UserMapper;
import com.crud.crud.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserDTO, Long> {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        super(userService, userMapper);
        this.userService = userService;
        this.userMapper = userMapper;
    }

}

