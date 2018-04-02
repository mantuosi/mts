package com.mantuosi.mts.core.dao.message;

import com.mantuosi.mts.core.bean.message.Message;
import com.mantuosi.mts.core.bean.message.MessageQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    int countByExample(MessageQuery example);

    int deleteByExample(MessageQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExampleWithBLOBs(MessageQuery example);

    List<Message> selectByExample(MessageQuery example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageQuery example);

    int updateByExampleWithBLOBs(@Param("record") Message record, @Param("example") MessageQuery example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageQuery example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}