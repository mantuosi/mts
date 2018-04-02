package com.mantuosi.mts.core.dao.message;

import com.mantuosi.mts.core.bean.message.MessageReply;
import com.mantuosi.mts.core.bean.message.MessageReplyQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageReplyDao {
    int countByExample(MessageReplyQuery example);

    int deleteByExample(MessageReplyQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageReply record);

    int insertSelective(MessageReply record);

    List<MessageReply> selectByExampleWithBLOBs(MessageReplyQuery example);

    List<MessageReply> selectByExample(MessageReplyQuery example);

    MessageReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageReply record, @Param("example") MessageReplyQuery example);

    int updateByExampleWithBLOBs(@Param("record") MessageReply record, @Param("example") MessageReplyQuery example);

    int updateByExample(@Param("record") MessageReply record, @Param("example") MessageReplyQuery example);

    int updateByPrimaryKeySelective(MessageReply record);

    int updateByPrimaryKeyWithBLOBs(MessageReply record);

    int updateByPrimaryKey(MessageReply record);
}