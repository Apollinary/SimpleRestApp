package org.example.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserStatus;
import org.example.dto.ResponseTransfer;
import org.example.dto.User;
import org.example.dto.rest.AddUserRequest;
import org.example.dto.rest.AddUserResponse;
import org.example.exceptions.UserNotFoundException;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{userId}")
    public User getUser(@PathVariable("userId") final Long userId) {
        return userService.findById(userId);
    }

    @GetMapping(value = "/users/cached/{userId}")
    public User getUserCached(@PathVariable("userId") final Long userId) {
        return userService.findByIdCached(userId);
    }

    @PatchMapping(value = "/updateUser/{userId}/userStatus/{userStatus}")
    public ResponseEntity<ResponseTransfer> updateUserStatus(@PathVariable("userId") final Long userId,
                                                             @PathVariable("userStatus") final UserStatus newUserStatus) {
        try {
            UserStatus previousUserStatus = userService.updateUserStatus(userId, newUserStatus);
            return ResponseEntity.ok(new ResponseTransfer(userId, previousUserStatus, newUserStatus));
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException(String.valueOf(userId));
        }
    }

    @PostMapping(value = "/users/add", consumes = {"application/json"})
    public AddUserResponse addUser(@RequestBody @Valid AddUserRequest request) {
        return userService.addUser(request);
    }

    @GetMapping(value = "/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
