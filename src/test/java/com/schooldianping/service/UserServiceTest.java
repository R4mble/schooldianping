package com.schooldianping.service;

import com.schooldianping.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Ramble
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User[] userList;

    private User user;

    @Before
    public void setUp() {
        user = new User("hanbin@lol.com", "aixi", "shesheshe");
    }


    @Test
    public void createUser() {
        userService.createUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void login() {
        System.out.println(userService.login(user.getUsername(), user.getPassword()));
        System.out.println(userService.login(user.getEmail(), user.getPassword()));
    }

    @Test
    public void getUserList() {
    }
}