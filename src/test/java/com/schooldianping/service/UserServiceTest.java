package com.schooldianping.service;

import com.schooldianping.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Transient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ramble
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private List<User> userList = new ArrayList<>();

    @Before
    public void setUp() {
        readFile();
    }

    public void readFile() {
        String pathname = "C:\\Users\\Windows\\Desktop\\schooldianping\\src\\main\\resources\\lol.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] hero = line.split(" ");
                userList.add(new User(hero[0], hero[1], hero[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void createUser() {
        for (User user : userList) {
            userService.createUser(user.getEmail(), user.getUsername(), user.getPassword());
        }
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void login() {
//        System.out.println(userService.login(user.getUsername(), user.getPassword()));
//        System.out.println(userService.login(user.getEmail(), user.getPassword()));
    }

    @Test
    public void getUserList() {
    }
}