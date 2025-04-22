package org.example.service;

import org.example.dao.UserStatus;
import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;
import org.example.repository.UserRepository;

import java.util.List;

public interface UserService {

    UserRepository getUserRepository();

    User findById(Long id);

    User findByIdCached(Long id);

    AddUserResponse addUser(AddUserRequest request);

    UserStatus updateUserStatus(Long userId, UserStatus newStatus);

    List<User> getAllUsers();

}

