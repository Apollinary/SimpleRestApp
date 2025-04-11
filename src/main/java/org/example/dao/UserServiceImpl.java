package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;
import org.example.mapping.AddUserRequestToUserEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("myUserService")
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddUserRequestToUserEntityMapper addUserRequestToUserEntityMapper;

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        User user = addUserRequestToUserEntityMapper.map(request);
        long userId = userRepository.save(user).getUserId();
        return AddUserResponse.builder().status("OK").id(userId).build();
    }

    @Override
    public UserStatus updateUserStatus(long userId, UserStatus newStatus) {
        User userToUpdate = userRepository.findById(userId).get();
        UserStatus previousStatus = userToUpdate.getStatus();
        userToUpdate.setStatus(newStatus);
        userRepository.save(userToUpdate);
        return previousStatus;
    }
}
