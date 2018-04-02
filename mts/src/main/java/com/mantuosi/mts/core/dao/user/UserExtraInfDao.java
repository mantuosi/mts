package com.mantuosi.mts.core.dao.user;

import com.mantuosi.mts.core.bean.user.UserExtraInf;
import com.mantuosi.mts.core.bean.user.UserExtraInfQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtraInfDao {
    int countByExample(UserExtraInfQuery example);

    int deleteByExample(UserExtraInfQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserExtraInf record);

    int insertSelective(UserExtraInf record);

    List<UserExtraInf> selectByExample(UserExtraInfQuery example);

    UserExtraInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserExtraInf record, @Param("example") UserExtraInfQuery example);

    int updateByExample(@Param("record") UserExtraInf record, @Param("example") UserExtraInfQuery example);

    int updateByPrimaryKeySelective(UserExtraInf record);

    int updateByPrimaryKey(UserExtraInf record);
}