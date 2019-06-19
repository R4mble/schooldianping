package com.schooldianping.service;

import com.schooldianping.exception.TipException;
import com.schooldianping.mapper.UserMapper;
import com.schooldianping.model.User;
import com.schooldianping.pojo.UserPublic;
import com.schooldianping.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramble
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean createUser(String email, String username, String password) {

        if (userMapper.checkDuplicateEmail(email)) {
            throw new TipException("该邮箱已注册, 是否直接登录");
        }

        if (userMapper.checkDuplicateName(username)) {
            throw new TipException("用户名" + username + "已被注册, 尝试下" + username + "123");
        }

        return userMapper.createUser(email, username, CommonUtils.encrypt(password)) == 1;
    }

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }


    public User login(String nameOrEmail, String password) {

        User user = CommonUtils.isEmail(nameOrEmail) ?
                        userMapper.getPasswordByEmail(nameOrEmail) :
                        userMapper.getPasswordByName(nameOrEmail);

        if (user == null) {
            throw new TipException("该用户不存在");
        }

        boolean pass = CommonUtils.checkPassword(password, user.getPassword());

        if (!pass) {
            throw new TipException("用户名或密码错误");
        }

        return user;
    }


    public List<UserPublic> getUserList(Integer[] uidList) {
        List<UserPublic> users = new ArrayList<>();
        for (Integer uid : uidList) {
            users.add(new UserPublic(userMapper.findById(uid)));
        }
        return users;
    }
}
