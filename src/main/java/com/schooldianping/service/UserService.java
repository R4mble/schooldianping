package com.schooldianping.service;

import com.schooldianping.exception.UserNotExistException;
import com.schooldianping.exception.WrongPasswordException;
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

    public boolean createUser(String email, String username, String password) {
        boolean alreadyExists = userMapper.checkDuplicate(email, username);
        if (alreadyExists) {
            return false;
        }
        userMapper.createUser(email, username, CommonUtils.encrypt(password));
        return true;
    }

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }


    public User login(String nameOrEmail, String password) {

        User user = CommonUtils.isEmail(nameOrEmail) ?
                        userMapper.getPasswordByEmail(nameOrEmail) :
                        userMapper.getPasswordByName(nameOrEmail);

        if (user == null) {
            throw new UserNotExistException();
        }

        boolean pass = CommonUtils.checkPassword(password, user.getPassword());

        if (!pass) {
            throw new WrongPasswordException();
        }

        return user;
    }


    public List<User> getUserList(List<Integer> uidList) {

        return null;
    }
}
