package com.schooldianping.mapper;

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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User user;

    @Before
    public void setUp() {
        user = new User(1, "hanbin@lol.com", "aixi", "shesheshe", "cool", 23);
    }


    @Test
    public void findById() {
        User a = userMapper.findById(1);
        assertEquals(a.getEmail(), "ying@fads.com");

    }

    @Test
    public void createUser() {
        userMapper.createUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    @Test
    public void checkDuplicate() {
    }

    @Test
    public void getPasswordByEmailOrName() {
    }
}