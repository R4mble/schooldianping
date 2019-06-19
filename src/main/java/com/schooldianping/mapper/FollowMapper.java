package com.schooldianping.mapper;

import com.schooldianping.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ramble
 */

@Mapper
public interface FollowMapper {

    List<Integer> followingList(Integer id);

    boolean followAnyone(Integer id);

    boolean addFollow(@Param("id") Integer id, @Param("toId") Integer toId);

    boolean createFollow(@Param("id") Integer id, @Param("toId") Integer toId);
}
