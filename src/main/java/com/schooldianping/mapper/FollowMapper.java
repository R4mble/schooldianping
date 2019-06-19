package com.schooldianping.mapper;

import com.schooldianping.model.User;
import com.schooldianping.model.UserAttention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ramble
 */

@Mapper
public interface FollowMapper {

    /**
     * 获取用户的关注列表
     *
     * @param id 用户id
     * @return 关注列表uid
     */
    UserAttention followingList(Integer id);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    boolean followAnyone(Integer id);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    boolean addFollow(@Param("id") Integer id, @Param("toId") Integer toId);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    boolean createFollow(@Param("id") Integer id, @Param("toId") Integer toId);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @param toId 用户id
     * @return User
     */
    boolean deleteFollowing(Integer id, Integer toId);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    boolean alreadyFollowing(Integer id, Integer toId);
}
