package com.schooldianping.service;

import com.schooldianping.mapper.FollowMapper;
import com.schooldianping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UserService userService;

    public boolean follow(Integer id, Integer toId) {
        if (followAnyone(id)) {
            return followMapper.addFollow(id, toId);
        }
        return followMapper.createFollow(id, toId);
    }

    public List<User> followingList(Integer id) {
        List<Integer> uidList = followMapper.followingList(id);
        userService.getUserList(uidList);

    }

    public boolean followAnyone(Integer id) {
        return followMapper.followAnyone(id);
    }

    public boolean deleteFollowing(Integer id, Integer toId) {
        return followMapper.deleteFollowing
    }
}
