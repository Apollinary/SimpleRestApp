package org.example.dao;

import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;

public interface UserService {

    UserRepository getUserRepository();

    User findById(long id);

    AddUserResponse addUser(AddUserRequest request);

    UserStatus updateUserStatus(long userId, UserStatus newStatus);
}

