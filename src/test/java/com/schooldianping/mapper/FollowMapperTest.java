package com.schooldianping.mapper;

import com.schooldianping.model.User;
import com.schooldianping.service.FollowService;
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
public class FollowMapperTest {

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private FollowService followService;

    private User user;

    @Before
    public void setUp() {
        user = new User(1, "ying@fads.com", "ramble", "sdfadfaew", "handsome", 12);
    }

    @Test
    public void followingList() {
        assertArrayEquals(followMapper.followingList(user.getId()).toArray(), new Integer[]{});
    }

    @Test
    public void followAnyone() {
        assertFalse(followMapper.followAnyone(user.getId()));
    }

    @Test
    public void addFollow() {
        followService.follow(1, 2);
    }

    @Test
    public void createFollow() {
    }
}