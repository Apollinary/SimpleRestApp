package org.example.dao;

public interface UserService {

    UserRepository getUserRepository();

    User findById(long id);
    long addUser(User user);
    UserStatus updateUserStatus(long userId, UserStatus newStatus);
}

