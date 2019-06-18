package com.schooldianping.mapper;

import com.schooldianping.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
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
        user = new User("1", "ying@fads.com", "ramble", "sdfadfaew", "handsome", 12);
    }


    @Test
    public void findById() {
        userMapper.findById("1");
    }

    @Test
    public void createUser() {
        userMapper.createUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    @Test
    public void checkDuplicate() {
        assertTrue(userMapper.checkDuplicate("ying@fads.com", "fdsa"));
        assertFalse(userMapper.checkDuplicate("yidng@fads.com", "fddsa"));
    }
}