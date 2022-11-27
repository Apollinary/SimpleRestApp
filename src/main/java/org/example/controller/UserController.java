package org.example.controller;


import org.example.dao.User;
import org.example.dao.UserService;
import org.example.dao.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PatchMapping(value = "/updateUser/{userId}/userStatus/{userStatus}")
    public ResponseTransfer updateUserStatus(@PathVariable("userId") final long userId, @PathVariable("userStatus") final UserStatus newUserStatus) {
        UserStatus previousUserStatus = userService.updateUserStatus(userId, newUserStatus);
        return new ResponseTransfer(userId, previousUserStatus, newUserStatus);
    }

    @PostMapping(value = "/users/add", consumes = {"application/json"})
    public long addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

}
