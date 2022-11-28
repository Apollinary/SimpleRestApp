package org.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("myUserService")
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public long addUser(User user) {
        return userRepository.save(user).getUserId();
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
