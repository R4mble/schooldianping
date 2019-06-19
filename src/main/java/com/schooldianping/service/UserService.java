package com.schooldianping.service;

import com.schooldianping.mapper.UserMapper;
import com.schooldianping.model.User;
import com.schooldianping.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.List;

/**
 * @author Ramble
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EncryptService encryptService;

    public boolean createUser(String email, String username, String password) {
        boolean alreadyExists = userMapper.checkDuplicate(email, username);
        if (alreadyExists) {
            return false;
        }
        userMapper.createUser(email, username, encryptService.encrypt(password));
        return true;
    }

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }


    public boolean login(String nameOrEmail, String password) {

        String realPassword = null;

        if (CommonUtils.isEmail(nameOrEmail)) {
            realPassword = userMapper.getPasswordByEmail(nameOrEmail);
        } else {
            realPassword = userMapper.getPasswordByName(nameOrEmail);
        }
        if (realPassword == null) {
            return false;
        } else {
            return encryptService.checkPassword(password, realPassword);
        }
    }

    public List<User> getUserList(List<Integer> uidList) {

        return null;
    }
}
