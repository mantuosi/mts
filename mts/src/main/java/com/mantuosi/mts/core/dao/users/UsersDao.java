package com.mantuosi.mts.core.dao.users;

import com.mantuosi.mts.core.bean.users.Users;
import com.mantuosi.mts.core.bean.users.UsersQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersDao {
    int countByExample(UsersQuery example);

    int deleteByExample(UsersQuery example);

    int deleteByPrimaryKey(String uid);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersQuery example);

    Users selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersQuery example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersQuery example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}