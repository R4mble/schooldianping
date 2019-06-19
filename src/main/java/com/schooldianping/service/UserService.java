package com.schooldianping.service;

import com.schooldianping.mapper.UserMapper;
import com.schooldianping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

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


    public boolean login(String nameOrEmail, String password) {
        String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        boolean isEmail = Pattern.compile(emailPattern).matcher(nameOrEmail).matches();
        String realPassword = userMapper.getPasswordByEmailOrName(nameOrEmail, isEmail);
        if (realPassword == null) {
            return false;
        } else {
            return encryptService.checkPassword(password, realPassword);
        }
    }
}
