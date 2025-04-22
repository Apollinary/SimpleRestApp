package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserStatus;
import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;
import org.example.exceptions.UserNotFoundException;
import org.example.mapping.AddUserRequestToUserEntityMapper;
import org.example.repository.UserRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("myUserService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RedisTemplate<Long, User> redisTemplate;
    private final AddUserRequestToUserEntityMapper addUserRequestToUserEntityMapper;

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public User findById(Long id) {
        log.debug("Start retrieving employee with ID: {}", id);
        User user = userRepository.findById(id).orElse(new User());
        if (user.getUserId() == 0) {
            throw new UserNotFoundException(String.valueOf(id));
        }
        log.debug("Finish retrieving employee with ID: {}", id);
        return user;
    }

    @Override
    public User findByIdCached(Long id) {
        log.debug("Start retrieving cached employee with ID: {}", id);

        User user = redisTemplate.opsForValue().get(id);
        if (user == null) {
            user = userRepository.findById(id).orElse(new User());
            redisTemplate.opsForValue().set(user.getUserId(), user);
        }
        log.debug("Finish retrieving cached employee with ID: {}", id);

        return user;
    }

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        User user = addUserRequestToUserEntityMapper.map(request);
        long userId = userRepository.save(user).getUserId();
        return AddUserResponse.builder().status("OK").id(userId).build();
    }

    @Override
    public UserStatus updateUserStatus(Long userId, UserStatus newStatus) {
        User userToUpdate = userRepository.findById(userId).get();
        UserStatus previousStatus = userToUpdate.getStatus();
        userToUpdate.setStatus(newStatus);
        userRepository.save(userToUpdate);
        return previousStatus;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
