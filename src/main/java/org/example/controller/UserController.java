package org.example.controller;


import org.example.dao.User;
import org.example.dao.UserService;
import org.example.dao.UserStatus;
import org.example.exceptions.InvalidUserFieldsException;
import org.example.exceptions.UserNotFoundException;
import org.example.validation.UserValidator;
import org.example.validation.ValidationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/SimpleRest")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") final long userId) {
        User user = userService.findById(userId);
        if (user.getUserId() == ValidationConstants.ZERO) {
            throw new UserNotFoundException(String.valueOf(userId));
        }
        return ResponseEntity.ok(user);
    }

    @PatchMapping(value = "/updateUser/{userId}/userStatus/{userStatus}")
    public ResponseEntity<ResponseTransfer> updateUserStatus(@PathVariable("userId") final long userId, @PathVariable("userStatus") final UserStatus newUserStatus) {
        try {
            UserStatus previousUserStatus = userService.updateUserStatus(userId, newUserStatus);
            return ResponseEntity.ok(new ResponseTransfer(userId, previousUserStatus, newUserStatus));
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException(String.valueOf(userId));
        }
    }

    @PostMapping(value = "/users/add", consumes = {"application/json"})
    public long addUser(@RequestBody User newUser) {
        if (!UserValidator.isUserValid(newUser)) {
            throw new InvalidUserFieldsException("One or several user attributes filled incorrectly.");
        }
        return userService.addUser(newUser);
    }

}
