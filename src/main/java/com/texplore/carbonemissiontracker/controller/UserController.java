package com.texplore.carbonemissiontracker.controller;

import com.texplore.carbonemissiontracker.dto.UserRequest;
import com.texplore.carbonemissiontracker.dto.UserResponse;
import com.texplore.carbonemissiontracker.model.User;
import com.texplore.carbonemissiontracker.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        log.info("Creating User: {}", userRequest);
        UserResponse userResponse = mapToDto(userService.createUser(userRequest));
        log.info("User created: {}", userResponse.getUser_id());
        return userResponse;
    }

    private UserResponse mapToDto(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser_id(user.getUser_id());
        userResponse.setUser_name(user.getUser_name());
        return userResponse;
    }

}
