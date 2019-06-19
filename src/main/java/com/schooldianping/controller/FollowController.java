package com.schooldianping.controller;

import com.schooldianping.model.User;
import com.schooldianping.service.FollowService;
import com.schooldianping.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ramble
 */
@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity follow(@RequestParam Integer id, @RequestParam Integer toId) {
        return followService.follow(id, toId);
    }



    @GetMapping("/following")
    public List<User> follow(@AuthenticationPrincipal User user) {
        return followService.followingList(user.getId());
    }

    @DeleteMapping("/following")
    public boolean deleteFollowing(@RequestParam Integer id, @RequestParam Integer toId) {
        return followService.deleteFollowing(id, toId);
    }
}
