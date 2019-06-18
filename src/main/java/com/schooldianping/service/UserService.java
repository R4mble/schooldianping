package com.schooldianping.service;

import com.schooldianping.mapper.UserMapper;
import com.schooldianping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        userMapper.createUser(email, username, password);
        return true;
    }

    public boolean login(User user) {

    }
}
