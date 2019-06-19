package com.schooldianping.service;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.schooldianping.mapper.FollowMapper;
import com.schooldianping.model.User;
import com.schooldianping.model.UserAttention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ramble
 */
@Service
public class FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UserService userService;

    public ResponseEntity follow(Integer id, Integer toId) {
        if (followAnyone(id)) {
            if (alreadyFollowing(id, toId)) {
                return ResponseEntity.ok("你已关注用户" + userService.getUserById(id).getUsername());
            }
            followMapper.addFollow(id, toId);
            return ResponseEntity.status(200).body("成功关注用户" + userService.getUserById(id).getUsername());
        }
        followMapper.createFollow(id, toId);
        return ResponseEntity.status(200).body("成功关注用户" + userService.getUserById(id).getUsername());
    }

    public List<User> followingList(Integer id) {
        UserAttention userAttention = followMapper.followingList(id);
        return userService.getUserList(userAttention.getFollowing());
    }

    public boolean followAnyone(Integer id) {
        return followMapper.followAnyone(id);
    }

    public boolean deleteFollowing(Integer id, Integer toId) {
        return followMapper.deleteFollowing(id, toId);
    }

    public boolean alreadyFollowing(Integer id, Integer toId) {
        return followMapper.alreadyFollowing(id, toId);
    }
}
