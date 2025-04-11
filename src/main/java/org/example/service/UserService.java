package org.example.service;

import org.example.dao.UserStatus;
import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;
import org.example.repository.UserRepository;

import java.util.List;

public interface UserService {

    UserRepository getUserRepository();

    User findById(long id);

    AddUserResponse addUser(AddUserRequest request);

    UserStatus updateUserStatus(long userId, UserStatus newStatus);

    List<User> getAllUsers();

}

