package com.texplore.carbonemissiontracker.service;

import com.texplore.carbonemissiontracker.dto.UserRequest;
import com.texplore.carbonemissiontracker.model.User;
import com.texplore.carbonemissiontracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .user_name(userRequest.getUser_name())
                .email_id(userRequest.getEmail_id())
                .mobile_no(userRequest.getMobile_no())
                .build();

        userRepository.save(user);
        log.info("User {} is saved", user.getUser_id());
        return user;
    }
}
