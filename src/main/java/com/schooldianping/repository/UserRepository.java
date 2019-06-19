package com.schooldianping.repository;

import com.schooldianping.mapper.UserMapper;
import com.schooldianping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramble
 */
@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userMapper.findById(id));
    }
}
