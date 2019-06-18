package com.schooldianping.controller;

import com.schooldianping.model.User;
import com.schooldianping.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public boolean follow(@RequestParam Integer id, @RequestParam Integer toId) {
        return followService.follow(id, toId);
    }

    @PostMapping("/following")
    public List<User> follow(@RequestParam Integer id) {
        return followService.followingList(id);
    }

    @DeleteMapping("/following")
    public boolean deleteFollowing(@RequestParam Integer id, @RequestParam Integer toId) {
        return followService.deleteFollowing(id, toId);
    }
}
