package com.qa.springboot.mapper;

import com.qa.springboot.pojo.User;
import com.qa.springboot.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectUserByLimit (@Param("offset")int offset,@Param("limit")int limit,@Param("truename")String truename);

    int selectTotal(@Param("truename")String truename);
    
    User selectUsername(String username);
    
    void deleteByUids(@Param("uids")Integer[]uids);
}