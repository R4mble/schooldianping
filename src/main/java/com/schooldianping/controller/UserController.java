package com.schooldianping.controller;

import com.schooldianping.constant.WebConstants;
import com.schooldianping.model.User;
import com.schooldianping.service.JwtService;
import com.schooldianping.service.UserService;
import com.schooldianping.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ramble
 */
@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        boolean res =  userService.createUser(user.getEmail(), user.getUsername(), user.getPassword());
        if (res) {
            return ResponseEntity.ok("注册成功");
        }
        return ResponseEntity.badRequest().body("注册失败");
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/login")
    public ResponseEntity userLogin(@NotBlank(message = "用户名或邮箱不能为空") @RequestParam String nameOrEmail,
                                    @NotBlank(message = "密码不能为空") @RequestParam String password,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {

        User user = userService.login(nameOrEmail, password);
        request.getSession().setAttribute(WebConstants.LOGIN_SESSION_KEY, user);
        CommonUtils.setCookie(response, user.getId());
        Map<String, Object> map = new HashMap<>(1);
        map.put("user", jwtService.toToken(user));
        return ResponseEntity.ok(map);
    }
}
