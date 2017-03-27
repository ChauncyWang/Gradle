package com.chauncy.niochet.entity.mapper;

import com.chauncy.niochet.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chauncy on 17-3-25.
 */
public interface UserMapper {
	User selectUser(@Param("id") String id, @Param("password")String password);
}
