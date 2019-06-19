package com.schooldianping.mapper;

import com.schooldianping.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramble
 */

@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    User findById(Integer id);

    /**
     * 创建用户
     *
     * @param email 用户email
     * @param username 用户名
     * @param password 加密后的密码
     */
    void createUser(@Param("email") String email, @Param("username") String username, @Param("password") String password);

    /**
     * 检查新增用户的邮箱或用户名是否已存在
     *
     * @param email 用户email
     * @param username 用户名
     * @return 状态
     */
    boolean checkDuplicate(@Param("email") String email, @Param("username") String username);

    /**
     * 检查新增用户的邮箱或用户名是否已存在
     *
     * @param nameOrEmail 用户email或者name
     * @param isEmail 是不是email
     * @return 密码或者空
     */
    String getPasswordByEmail(String Email);


    String getPasswordByName(String name);
}
