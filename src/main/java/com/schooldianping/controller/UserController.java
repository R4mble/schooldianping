package com.schooldianping.controller;

import com.schooldianping.model.User;
import com.schooldianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Ramble
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public boolean createUser(@Valid @RequestBody User user) {
        return userService.createUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/login")
    public boolean userLogin(@Valid @RequestBody User user) {
        return userService.login(user);
    }

}
